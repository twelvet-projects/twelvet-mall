package com.twelvet.server.system.controller;

import cn.twelvet.excel.annotation.ResponseExcel;
import com.twelvet.api.system.domain.User;
import com.twelvet.framework.core.application.controller.TWTController;
import com.twelvet.framework.core.application.domain.JsonResult;
import com.twelvet.framework.core.application.page.TableDataInfo;
import com.twelvet.framework.jdbc.web.utils.PageUtils;
import com.twelvet.framework.log.annotation.Log;
import com.twelvet.framework.log.enums.BusinessType;
import com.twelvet.server.system.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 客户Controller
 *
 * @author TwelveT
 * @WebSite twelvet.cn
 * @date 2023-07-19
 */
@Tag(description = "UserController", name = "客户")
@RestController
@RequestMapping("/cusUser")
public class UserController extends TWTController {

	@Autowired
	private IUserService userService;

	/**
	 * 查询客户列表
	 */
	@Operation(summary = "查询客户列表")
	@PreAuthorize("@role.hasPermi('{permissionPrefix}:list')")
	@GetMapping("/list")
	public JsonResult<TableDataInfo> list(User user) {
		PageUtils.startPage();
		List<User> list = userService.selectUserList(user);
		return JsonResult.success(PageUtils.getDataTable(list));
	}

	/**
	 * 导出客户列表
	 * @return
	 */
	@ResponseExcel(name = "导出客户列表")
	@Operation(summary = "导出客户列表")
	@PreAuthorize("@role.hasPermi('{permissionPrefix}:export')")
	@Log(service = "客户", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	public List<User> export(User user) {
		return userService.selectUserList(user);
	}

	/**
	 * 获取客户详细信息
	 */
	@Operation(summary = "获取客户详细信息")
	@PreAuthorize("@role.hasPermi('{permissionPrefix}:query')")
	@GetMapping(value = "/{id}")
	public JsonResult<User> getInfo(@PathVariable("id") Long id) {
		return JsonResult.success(userService.selectUserById(id));
	}

	/**
	 * 新增客户
	 */
	@Operation(summary = "新增客户")
	@PreAuthorize("@role.hasPermi('system:user:add')")
	@Log(service = "客户", businessType = BusinessType.INSERT)
	@PostMapping
	public JsonResult<String> add(@RequestBody User user) {
		return json(userService.insertUser(user));
	}

	/**
	 * 修改客户
	 */
	@Operation(summary = "修改客户")
	@PreAuthorize("@role.hasPermi('system:user:edit')")
	@Log(service = "客户", businessType = BusinessType.UPDATE)
	@PutMapping
	public JsonResult<String> edit(@RequestBody User user) {
		return json(userService.updateUser(user));
	}

	/**
	 * 删除客户
	 */
	@Operation(summary = "删除客户")
	@PreAuthorize("@role.hasPermi('system:user:remove')")
	@Log(service = "客户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
	public JsonResult<String> remove(@PathVariable Long[] ids) {
		return json(userService.deleteUserByIds(ids));
	}

}
