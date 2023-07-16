package com.twelvet.server.goods.service.impl;

import com.twelvet.api.goods.domain.dto.OrderVO;
import com.twelvet.framework.redis.service.RedisService;
import com.twelvet.server.goods.service.OrderService;
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

    /**
     * 提交订单
     *
     * @param orderVO 订单VO
     */
    @Override
    public void submit(OrderVO orderVO) {
        String cacheObject = redisService.getCacheObject("test");
        log.info("获取Redis信息：{}", cacheObject);
    }
}
