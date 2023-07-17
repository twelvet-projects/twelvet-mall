package com.twelvet.server.goods.service.impl;

import com.twelvet.api.goods.domain.dto.OrderVO;
import com.twelvet.framework.redis.service.RedisService;
import com.twelvet.server.goods.mapper.GoodsMapper;
import com.twelvet.server.goods.service.OrderService;
import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 订单服务
 */
@Service
public class OrderServiceImpl implements OrderService {

	private final static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private RedisService redisService;

	@Autowired
	private RedissonClient redissonClient;

	@Autowired
	private GoodsMapper goodsMapper;

	/**
	 * 提交订单
	 * @param orderVO 订单VO
	 */
	@Override
	public void submit(OrderVO orderVO) {
		Long goodsId = orderVO.getGoodsId();
		int deductionInventory = goodsMapper.deductionInventory(goodsId);

		if (deductionInventory > 0) {
			log.info("成功购买商品");
		}
		else {
			log.error("库存不足");
		}
	}

}
