package com.twelvet.api.im.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: IM对象
 */
@Schema(description = "IM对象")
public class IMVO implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Schema(description = "是否自身")
	private Boolean self;

	@Schema(description = "用户名称")
	private String username;

	@Schema(description = "发送内容")
	private String info;

	public Boolean getSelf() {
		return self;
	}

	public void setSelf(Boolean self) {
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
		return "IMVO{" + "self=" + self + ", username='" + username + '\'' + ", info='" + info + '\'' + '}';
	}

}
