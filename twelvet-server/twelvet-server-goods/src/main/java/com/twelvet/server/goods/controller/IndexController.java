package com.twelvet.server.goods.controller;

import com.twelvet.api.system.domain.SysDictData;
import com.twelvet.framework.core.application.controller.TWTController;
import com.twelvet.framework.core.application.domain.AjaxResult;
import com.twelvet.framework.core.application.domain.JsonResult;
import com.twelvet.framework.core.application.page.TableDataInfo;
import com.twelvet.framework.jdbc.web.utils.PageUtils;
import com.twelvet.framework.security.annotation.AuthIgnore;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 商品首頁
 */
@AuthIgnore(value = false)
@Tag(description = "IndexController", name = "商品首頁")
@RestController
@RequestMapping("/")
public class IndexController extends TWTController {

	/**
	 * 商品首頁
	 * @return JsonResult<TableDataInfo>
	 */
	@Operation(summary = "商品首頁")
	@GetMapping
	public AjaxResult index() {
		return AjaxResult.success();
	}

}
