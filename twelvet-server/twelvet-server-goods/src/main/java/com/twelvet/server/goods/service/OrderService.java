package com.twelvet.server.goods.service;

import com.twelvet.api.goods.domain.dto.OrderVO;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 订单服务
 */
public interface OrderService {

	/**
	 * 提交订单
	 * @param orderVO 订单VO
	 */
	void submit(OrderVO orderVO);

}
