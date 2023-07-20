package com.twelvet.api.system.feign;

import com.twelvet.api.system.domain.User;
import com.twelvet.api.system.feign.factory.RemoteCusUserFallbackFactory;
import com.twelvet.framework.core.constants.SecurityConstants;
import com.twelvet.framework.core.constants.ServiceNameConstants;
import com.twelvet.framework.core.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author twelvet
 * @WebSite twelvet.cn
 * @Description: 用户信息服务
 */
@FeignClient(contextId = "RemoteCusUserService", value = ServiceNameConstants.SYSTEM_SERVICE,
		fallbackFactory = RemoteCusUserFallbackFactory.class)
public interface RemoteCusUserService {

	/**
	 * 通过用户名查询用户信息
	 * @param username 用户名称
	 * @return R<UserInfo>
	 */
	@GetMapping(value = "/api/cusUser/info/{username}", headers = SecurityConstants.HEADER_FROM_IN)
	R<User> getUserInfo(@PathVariable("username") String username);

}
