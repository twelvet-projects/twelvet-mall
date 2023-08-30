package com.twelvet.api.live.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 推拉流实体
 *
 * @author twelvet
 */
@Schema(description = "推拉流实体")
public class SrsRtcDTO {

	private String api;

	private String clientip;

	private String sdp;

	private String streamurl;

	private String tid;

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String getClientip() {
		return clientip;
	}

	public void setClientip(String clientip) {
		this.clientip = clientip;
	}

	public String getSdp() {
		return sdp;
	}

	public void setSdp(String sdp) {
		this.sdp = sdp;
	}

	public String getStreamurl() {
		return streamurl;
	}

	public void setStreamurl(String streamurl) {
		this.streamurl = streamurl;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	@Override
	public String toString() {
		return "SrsRtcDTO{" + "api='" + api + '\'' + ", clientip='" + clientip + '\'' + ", sdp='" + sdp + '\''
				+ ", streamurl='" + streamurl + '\'' + ", tid='" + tid + '\'' + '}';
	}

}
