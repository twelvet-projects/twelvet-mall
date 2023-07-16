package com.twelvet.server.goods.controller.client;

import com.twelvet.api.goods.domain.dto.OrderVO;
import com.twelvet.framework.core.application.controller.TWTController;
import com.twelvet.framework.core.application.domain.AjaxResult;
import com.twelvet.framework.security.annotation.AuthIgnore;
import com.twelvet.server.goods.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品Controller
 *
 * @author TwelveT
 * @WebSite twelvet.cn
 * @date 2023-07-16
 */
@AuthIgnore(value = false)
@Tag(description = "GoodsClientController", name = "订单服务")
@RestController
@RequestMapping("/client/order")
public class OrderClientController extends TWTController {

    @Autowired
    private OrderService orderService;

    /**
     * 提交订单
     */
    @Operation(summary = "提交订单")
    @PostMapping("/submit")
    public AjaxResult submit(OrderVO orderVO) {
        orderService.submit(orderVO);
        return AjaxResult.success();
    }

}
