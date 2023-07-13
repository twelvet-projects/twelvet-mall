package com.twelvet.api.system.domain;

import com.twelvet.framework.core.application.domain.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serial;

/**
 * @author twelvet
 * @WebSite twelvet.cn
 * @Description: 终端配置表 sys_oauth_client_details
 */
@Schema(description = "终端配置表")
public class SysClientDetails extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 终端编号
	 */

	@Schema(description = "终端编号")
	private String clientId;

	/**
	 * 资源ID标识
	 */
	@Schema(description = "资源ID标识")
	private String resourceIds;

	/**
	 * 终端安全码
	 */
	@Schema(description = "终端安全码")
	private String clientSecret;

	/**
	 * 终端授权范围
	 */
	@Schema(description = "终端授权范围")
	private String scope;

	/**
	 * 终端授权类型
	 */
	@Schema(description = "终端授权类型")
	private String authorizedGrantTypes;

	/**
	 * 服务器回调地址
	 */
	@Schema(description = "服务器回调地址")
	private String webServerRedirectUri;

	/**
	 * 访问资源所需权限
	 */
	@Schema(description = "访问资源所需权限")
	private String authorities;

	/**
	 * 设定终端的access_token的有效时间值（秒）
	 */
	@Schema(description = "设定终端的access_token的有效时间值（秒）")
	private Integer accessTokenValidity;

	/**
	 * 设定终端的refresh_token的有效时间值（秒）
	 */
	@Schema(description = "设定终端的refresh_token的有效时间值（秒）")
	private Integer refreshTokenValidity;

	/**
	 * 附加信息
	 */
	@Schema(description = "附加信息")
	private String additionalInformation;

	/**
	 * 是否登录时跳过授权
	 */
	@Schema(description = "是否登录时跳过授权")
	private String autoapprove;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	public String getWebServerRedirectUri() {
		return webServerRedirectUri;
	}

	public void setWebServerRedirectUri(String webServerRedirectUri) {
		this.webServerRedirectUri = webServerRedirectUri;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public Integer getAccessTokenValidity() {
		return accessTokenValidity;
	}

	public void setAccessTokenValidity(Integer accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}

	public Integer getRefreshTokenValidity() {
		return refreshTokenValidity;
	}

	public void setRefreshTokenValidity(Integer refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public String getAutoapprove() {
		return autoapprove;
	}

	public void setAutoapprove(String autoapprove) {
		this.autoapprove = autoapprove;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("clientId", getClientId())
			.append("resourceIds", getResourceIds())
			.append("clientSecret", getClientSecret())
			.append("scope", getScope())
			.append("authorizedGrantTypes", getAuthorizedGrantTypes())
			.append("webServerRedirectUri", getWebServerRedirectUri())
			.append("authorities", getAuthorities())
			.append("accessTokenValidity", getAccessTokenValidity())
			.append("refreshTokenValidity", getRefreshTokenValidity())
			.append("additionalInformation", getAdditionalInformation())
			.append("autoapprove", getAutoapprove())
			.toString();
	}

}
