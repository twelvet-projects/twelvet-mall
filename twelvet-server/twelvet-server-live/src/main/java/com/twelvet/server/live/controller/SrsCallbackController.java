package com.twelvet.server.live.controller;

import com.twelvet.framework.security.annotation.AuthIgnore;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SRS HTTP鉴权回调
 *
 * @author twelvet
 */
@AuthIgnore(value = false)
@Tag(description = "SrsCallbackController", name = "SRS HTTP鉴权回调")
@RestController
@RequestMapping("/srs_callback")
public class SrsCallbackController {

	/**
	 * 直播推流回调
	 * @return
	 */
	@Operation(summary = "直播推流回调")
	@PostMapping("/on_publish")
	public int onPublish() {
		System.out.println("接受信息");
		return 500;
	}

	/**
	 * 播放流回调
	 */
	@Operation(summary = "播放流回调")
	@PostMapping("/on_play")
	public int onPlay() {
		return 500;
	}

	/**
	 * 直播推流断开回调
	 */
	@Operation(summary = "直播推流断开回调")
	@PostMapping("/on_unpublish")
	public int onUnPublish() {
		return 500;
	}

}
