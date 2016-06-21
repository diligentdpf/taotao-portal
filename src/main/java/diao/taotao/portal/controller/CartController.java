package diao.taotao.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import diao.taotao.common.util.TaotaoResult;
import diao.taotao.portal.pojo.CartItem;
import diao.taotao.portal.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    /** 添加商品信息到购物车 */
    @RequestMapping("/add/{itemId}")
    public String addCartItem(@PathVariable Long itemId,
            @RequestParam(defaultValue = "1") Integer num, HttpServletRequest request,
            HttpServletResponse response) {
        TaotaoResult result = cartService.addCartItem(itemId, num, request, response);
        // 重定向保证页面在刷新时不会做重复的提交，不会重复往购物车中添加东西
        return "redirect:/cart/success.html";
    }

    /**
     * 从cookie中把购物车信息（商品信息）取出来
     */
    @RequestMapping("/cart")
    public String showCart(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<CartItem> list = cartService.getCartItemList(request, response);
        model.addAttribute("cartList", list);
        return "cart";
    }

    /**
     * 添加购物车的成功页面
     */
    @RequestMapping("/success")
    public String showSuccess() {
        return "cartSuccess";
    }

    @RequestMapping("/delete/{itemId}")
    public String deleteCartItem(@PathVariable Long itemId, HttpServletRequest request,
            HttpServletResponse response) {
        cartService.deleteCartItem(itemId, request, response);
        return "redirect:/cart/cart.html";
    }
}
