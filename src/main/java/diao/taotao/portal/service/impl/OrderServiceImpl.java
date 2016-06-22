package diao.taotao.portal.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import diao.taotao.common.util.HttpClientUtil;
import diao.taotao.common.util.JsonUtils;
import diao.taotao.common.util.TaotaoResult;
import diao.taotao.portal.pojo.Order;
import diao.taotao.portal.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Value("${ORDER_BASE_URL}")
    private String ORDER_BASE_URL;
    @Value("${ORDER_CREATE_URL}")
    private String ORDER_CREATE_URL;

    @Override
    public String createOrder(Order order) {
        // 调用taotao-order的服务提交订单。
        String json = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_CREATE_URL,
                JsonUtils.objectToJson(order));
        // 把json转换成taotaoResult
        TaotaoResult taotaoResult = TaotaoResult.format(json);
        if (taotaoResult.getStatus() == 200) {
            Object orderId = taotaoResult.getData();
            return orderId.toString();
        }
        return "";
    }

}
