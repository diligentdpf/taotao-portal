package diao.taotao.portal.pojo;

import java.util.List;

import diao.taotao.pojo.TbOrder;
import diao.taotao.pojo.TbOrderItem;
import diao.taotao.pojo.TbOrderShipping;

public class Order extends TbOrder {
    private List<TbOrderItem> orderItems;
    private TbOrderShipping orderShipping;

    /**
     * @return the orderItems
     */
    public List<TbOrderItem> getOrderItems() {
        return orderItems;
    }

    /**
     * @param orderItems the orderItems to set
     */
    public void setOrderItems(List<TbOrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    /**
     * @return the orderShipping
     */
    public TbOrderShipping getOrderShipping() {
        return orderShipping;
    }

    /**
     * @param orderShipping the orderShipping to set
     */
    public void setOrderShipping(TbOrderShipping orderShipping) {
        this.orderShipping = orderShipping;
    }

}
