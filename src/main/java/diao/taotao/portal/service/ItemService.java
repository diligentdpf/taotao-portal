package diao.taotao.portal.service;

import diao.taotao.portal.pojo.ItemInfo;

public interface ItemService {
    /**
     * 调用rest的服务查询商品基本信息
     */
    public ItemInfo getItemById(Long itemId);

    /**
     * 调用rest的服务查询商品描述信息
     */
    public String getItemDescById(Long itemId);

    /**
     * 调用rest的服务查询商品规格信息
     */
    public String getItemParam(Long itemId);
}
