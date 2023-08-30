package com.twelvet.server.live.controller.api;

import com.twelvet.api.live.dto.SrsRtcDTO;
import com.twelvet.framework.security.annotation.AuthIgnore;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SRS HTTP鉴权回调
 *
 * @author twelvet
 */
@AuthIgnore
@Tag(description = "SrsApi", name = "SRS HTTP鉴权回调")
@RestController
@RequestMapping("/srs")
public class SrsApi {

	/**
	 * 直播推流回调
	 */
	@AuthIgnore
	@Operation(summary = "直播推流回调")
	@GetMapping("/on_publish")
	public void onPublish() {

	}

	/**
	 * 播放流回调
	 */
	@AuthIgnore
	@Operation(summary = "播放流回调")
	@GetMapping("/on_play")
	public void onPlay() {

	}

	/**
	 * 直播推流断开回调
	 */
	@AuthIgnore
	@Operation(summary = "直播推流断开回调")
	@GetMapping("/on_unpublish")
	public void onUnPublish() {

	}

}
