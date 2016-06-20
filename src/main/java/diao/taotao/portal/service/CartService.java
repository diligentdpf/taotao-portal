package diao.taotao.portal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diao.taotao.common.util.TaotaoResult;

public interface CartService {
    /** 添加商品到购物车 */
    public TaotaoResult addCartItem(long itemId, int num, HttpServletRequest request,
            HttpServletResponse response);
}
