package com.twelvet.server.live.controller;

import com.twelvet.api.live.dto.SrsRtcDTO;
import com.twelvet.framework.security.annotation.AuthIgnore;
import com.twelvet.server.live.service.SrsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * SRS服务操作
 *
 * @author twelvet
 */
@Tag(description = "SrsController", name = "SRS服务操作")
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
	@Operation(summary = "直播推流")
	@PostMapping("/push")
	public ResponseEntity<Object> push(@RequestBody SrsRtcDTO srsRtcDTO) {
		return srsService.push(srsRtcDTO);
	}

	/**
	 * WebRTC直播流拉取(其它格式可以直接读取流地址)
	 * @param srsRtcDTO SrsRtcDTO
	 * @return String
	 */
	@Operation(summary = "直播流拉取")
	@PostMapping("/pull")
	public ResponseEntity<Object> pull(@RequestBody SrsRtcDTO srsRtcDTO) {
		return srsService.pull(srsRtcDTO);
	}

}
