package com.twelvet.api.im.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: IM对象
 */
@Schema(description = "IM对象")
public class IMDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Schema(description = "是否自身")
	private boolean self;

	@Schema(description = "用户名称")
	private String username;

	@Schema(description = "发送内容")
	private String info;

	public boolean getSelf() {
		return self;
	}

	public void setSelf(boolean self) {
		this.self = self;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "IMDTO{" + "self=" + self + ", username='" + username + '\'' + ", info='" + info + '\'' + '}';
	}

}
