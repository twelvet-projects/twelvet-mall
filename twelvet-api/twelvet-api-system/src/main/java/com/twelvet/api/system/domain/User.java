package com.twelvet.api.system.domain;

import com.twelvet.framework.utils.annotation.excel.Excel;
import com.twelvet.framework.core.application.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 客户对象 user
 *
 * @author TwelveT
 * @WebSite twelvet.cn
 * @date 2023-07-19
 */
@Schema(description = "客户对象")
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** ID */
	@Schema(description = "ID")
	private Long id;

	/** 用户名称 */
	@Schema(description = "用户名称")
	@Excel(name = "用户名称")
	private String nickname;

	/** 账号 */
	@Schema(description = "账号")
	@Excel(name = "账号")
	private String username;

	/** 密码 */
	@Schema(description = "密码")
	@Excel(name = "密码")
	private String password;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
			.append("nickname", getNickname())
			.append("username", getUsername())
			.append("password", getPassword())
			.toString();
	}

}
