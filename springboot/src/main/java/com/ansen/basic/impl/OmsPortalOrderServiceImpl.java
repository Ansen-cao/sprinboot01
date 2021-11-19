package com.ansen.service.impl;

import com.ansen.common.api.CommonResult;
import com.ansen.component.CancelOrderSender;
import com.ansen.dto.OrderParam;
import com.ansen.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Desc
 * @Auhtor caomx
 * @Date 2021-09-15
 * @Version
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {
    private static Logger logger = LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);

    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        sendDelayMessageCancelOrder(11l);
        return CommonResult.success(null,"下单成功");
    }

    @Override
    public void cancelOrder(Long orderId) {
        logger.info("取消订单一系列的操作");
    }

    private void sendDelayMessageCancelOrder(Long orderId){
        long delayTimes = 30*1000;
        cancelOrderSender.sendMessage(orderId,delayTimes);
    }
}
