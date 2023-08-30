package com.twelvet.server.live.service;

import com.twelvet.api.live.dto.SrsRtcDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author twelvet
 * @WebSite twelvet.cn
 * @Description: SRS服务
 */
public interface SrsService {

	ResponseEntity<Object> push(@RequestBody SrsRtcDTO srsRtcDTO);

	ResponseEntity<Object> pull(@RequestBody SrsRtcDTO srsRtcDTO);

}
