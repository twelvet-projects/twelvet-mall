package com.twelvet.api.system.feign.factory;

import com.twelvet.api.system.feign.RemoteCusUserService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author twelvet
 * @WebSite twelvet.cn
 * @Description: 用户信息服务降级处理
 */
@Component
public class RemoteCusUserFallbackFactory implements FallbackFactory<RemoteCusUserService> {

	private static final Logger log = LoggerFactory.getLogger(RemoteCusUserFallbackFactory.class);

	@Override
	public RemoteCusUserService create(Throwable throwable) {
		log.error("用户服务调用失败:{}", throwable.getMessage());
		return (username) -> null;
	}

}
