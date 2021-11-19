package com.ansen.service;

import com.ansen.common.api.CommonResult;
import com.ansen.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Desc 前台订单管理Service
 * @Auhtor caomx
 * @Date 2021-09-15
 * @Version
 */
public interface OmsPortalOrderService {

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /*
    取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);
}
