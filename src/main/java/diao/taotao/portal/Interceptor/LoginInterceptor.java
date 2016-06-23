package diao.taotao.portal.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import diao.taotao.common.util.CookieUtils;
import diao.taotao.pojo.TbUser;
import diao.taotao.portal.service.impl.UserServiceImpl;

public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private UserServiceImpl userService;

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3)
			throws Exception {
		// 返回ModelAndView之后。
		// 响应用户之后。
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// handler执行之后，返回ModelAndView之前
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 在Handler执行之前处理
		// 判断用户是否登录
		// 从cookie中取token
		String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
		// 根据token换取用户信息，调用sso系统的接口。
		TbUser user = userService.getUserByToken(token);
		// 取不到用户信息
		if (null == user) {
			// 跳转到登录页面，把用户请求的url作为参数传递给登录页面。
			/**
			 * 在springmvc 容器中可以访问父容器spring的对象，但是不能访问父容器的属性；首先让spring把属性
			 * 加载到spring的对象中，然后再从spring的对象中获取属性
			 */
			response.sendRedirect(
					userService.SSO_BASE_URL + userService.SSO_PAGE_LOGIN + "?redirect=" + request.getRequestURL());
			// 返回false
			return false;
		}
		// 取到用户信息，放行，把用户信息放到request中
		request.setAttribute("user", user);
		// 返回值决定handler是否执行。true：执行，false：不执行。
		return true;
	}

}
