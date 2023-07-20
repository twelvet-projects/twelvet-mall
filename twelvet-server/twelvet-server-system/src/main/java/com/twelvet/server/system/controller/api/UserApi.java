package com.twelvet.server.system.controller.api;

import java.util.List;

import com.twelvet.api.system.domain.User;
import com.twelvet.framework.core.application.page.TableDataInfo;
import com.twelvet.framework.core.domain.R;
import com.twelvet.framework.security.annotation.AuthIgnore;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import com.twelvet.framework.log.annotation.Log;
import com.twelvet.framework.log.enums.BusinessType;
import org.springframework.security.access.prepost.PreAuthorize;
import com.twelvet.server.system.service.IUserService;
import com.twelvet.framework.core.application.controller.TWTController;
import com.twelvet.framework.core.application.domain.JsonResult;
import com.twelvet.framework.utils.poi.ExcelUtils;
import com.twelvet.framework.jdbc.web.utils.PageUtils;

/**
 * 客户Controller
 *
 * @author TwelveT
 * @WebSite twelvet.cn
 * @Description: 客户信息
 */
@AuthIgnore
@Hidden
@Tag(description = "UserApi", name = "客户信息")
@RestController
@RequestMapping("/api/cusUser")
public class UserApi extends TWTController {

	@Autowired
	private IUserService userService;

	/**
	 * 获取客户详细信息
	 */
	@Operation(summary = "获取客户详细信息")
	@GetMapping(value = "/info/{username}")
	public R<User> getUserInfo(@PathVariable("username") String username) {
		return R.ok(userService.selectUserByUsername(username));
	}

}
