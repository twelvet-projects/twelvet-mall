package com.twelvet.server.goods.service;

import com.twelvet.api.goods.domain.dto.OrderDTO;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 订单服务
 */
public interface OrderService {

	/**
	 * 提交订单
	 * @param orderDTO 订单VO
	 */
	void submit(OrderDTO orderDTO);

}
