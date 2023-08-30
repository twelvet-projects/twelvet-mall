package com.twelvet.server.live.controller;

import com.twelvet.api.live.dto.SrsRtcDTO;
import com.twelvet.framework.security.annotation.AuthIgnore;
import com.twelvet.server.live.service.SrsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SRS服务操作
 *
 * @author twelvet
 */
@Tag(description = "RedisController", name = "缓存监控")
@RestController
@RequestMapping("/")
public class SrsController {

	@Autowired
	private SrsService srsService;

	/**
	 * 直播推流
	 * @param srsRtcDTO SrsRtcDTO
	 * @return String
	 */
	@AuthIgnore
	@Operation(summary = "直播推流")
	@GetMapping("/push")
	public ResponseEntity<Object> push(@RequestBody SrsRtcDTO srsRtcDTO) {
		return srsService.push(srsRtcDTO);
	}

	/**
	 * 直播流拉取
	 * @param srsRtcDTO SrsRtcDTO
	 * @return String
	 */
	@AuthIgnore
	@Operation(summary = "直播流拉取")
	@GetMapping("/pull")
	public ResponseEntity<Object> pull(@RequestBody SrsRtcDTO srsRtcDTO) {
		return srsService.pull(srsRtcDTO);
	}

}
