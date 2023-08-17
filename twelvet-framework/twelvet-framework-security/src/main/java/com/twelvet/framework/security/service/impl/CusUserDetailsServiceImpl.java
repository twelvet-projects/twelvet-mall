package com.twelvet.framework.security.service.impl;

import com.twelvet.api.system.domain.SysUser;
import com.twelvet.api.system.domain.User;
import com.twelvet.api.system.feign.RemoteCusUserService;
import com.twelvet.api.system.model.UserInfo;
import com.twelvet.framework.core.constants.SecurityConstants;
import com.twelvet.framework.core.domain.R;
import com.twelvet.framework.core.domain.utils.ResUtils;
import com.twelvet.framework.redis.service.constants.CacheConstants;
import com.twelvet.framework.security.constants.UserTypeConstants;
import com.twelvet.framework.security.domain.LoginUser;
import com.twelvet.framework.security.exception.UserFrozenException;
import com.twelvet.framework.security.service.TwUserDetailsService;
import com.twelvet.framework.utils.TUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author twelvet
 * @WebSite twelvet.cn
 * @Description: 客户登录服务
 */
public class CusUserDetailsServiceImpl implements TwUserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(TwTUserDetailsServiceImpl.class);

	/**
	 * 仅支持后台登录
	 */
	private final static String PLAT_FORM = "admin";

	/**
	 * 登录类型
	 */
	private final static String GRAN_TYPE = "password";

	@Autowired
	private RemoteCusUserService remoteCusUserService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		R<User> userResult = remoteCusUserService.getUserInfo(username);

		Set<String> dbAuthsSet = new HashSet<>();

		Collection<? extends GrantedAuthority> authorities = AuthorityUtils
			.createAuthorityList(dbAuthsSet.toArray(new String[0]));

		User user = userResult.getData();

		return new LoginUser(user.getId(), 0L, null, user.getUsername(), SecurityConstants.BCRYPT + user.getPassword(),
				true, true, true, true, authorities);
	}

	/**
	 * 是否支持此客户端校验
	 * @param clientId 目标客户端
	 * @param grantType 采用登录模式
	 * @return true/false
	 */
	@Override
	public boolean support(String clientId, String grantType) {
		return UserTypeConstants.CUS_USER.equals(clientId);
	}

	/**
	 * 排序值
	 * @return 数值
	 */
	@Override
	public int getOrder() {
		return Integer.MIN_VALUE + 1;
	}

}
