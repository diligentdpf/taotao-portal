package diao.taotao.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diao.taotao.common.util.TaotaoResult;
import diao.taotao.portal.pojo.CartItem;

public interface CartService {
	/** 添加商品到购物车 */
	public TaotaoResult addCartItem(long itemId, int num, HttpServletRequest request, HttpServletResponse response);

	/** 从cookie中把购物车中商品信息取出来 */
	public List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);
}
