package com.twelvet.server.live.service.impl;

import com.twelvet.api.live.dto.SrsRtcDTO;
import com.twelvet.server.live.service.SrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author twelvet
 * @WebSite twelvet.cn
 * @Description: SRS服务
 */
@Service
public class SrsServiceImpl implements SrsService {

	@Autowired(required = false)
	private RestTemplate restTemplate;

	@Override
	public ResponseEntity<Object> push(SrsRtcDTO srsRtcDTO) {
		// 设置请求头
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// 封装请求体和请求头
		HttpEntity<SrsRtcDTO> httpEntity = new HttpEntity<>(srsRtcDTO, headers);

		// 发送 POST 请求
		String url = "http://live.io:1985/rtc/v1/publish/";
		return restTemplate.exchange(url, HttpMethod.POST, httpEntity, Object.class);

	}

	@Override
	public ResponseEntity<Object> pull(SrsRtcDTO srsRtcDTO) {
		// 设置请求头
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// 封装请求体和请求头
		HttpEntity<SrsRtcDTO> httpEntity = new HttpEntity<>(srsRtcDTO, headers);

		// 发送 POST 请求
		String url = "http://live.io:1985/rtc/v1/play/";
		return restTemplate.exchange(url, HttpMethod.POST, httpEntity, Object.class);
	}

}
