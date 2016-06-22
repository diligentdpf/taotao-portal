package diao.taotao.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import diao.taotao.portal.pojo.CartItem;
import diao.taotao.portal.pojo.Order;
import diao.taotao.portal.service.CartService;
import diao.taotao.portal.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    /**
     * 打开购物车，确认
     */
    @RequestMapping("/order-cart")
    public String showOrderCart(HttpServletRequest request, HttpServletResponse response,
            Model model) {
        // 修改~，增加从cookie中取商品
        List<CartItem> list = cartService.getCartItemList(request, response);
        // 传递给页面
        model.addAttribute("cartList", list);
        return "order-cart";
    }

    /**
     * 调用taotao-order系统的服务生成订单
     */
    @RequestMapping("/create")
    public String createOrder(Order order, Model model) {
        try {
            String orderId = orderService.createOrder(order);
            model.addAttribute("orderId", orderId);
            model.addAttribute("payment", order.getPayment());
            model.addAttribute("date", new DateTime().plusDays(3).toString("yyyy-MM-dd"));
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "系统出错了，等会再试吧~");
            return "error/exception";
        }
    }
}
