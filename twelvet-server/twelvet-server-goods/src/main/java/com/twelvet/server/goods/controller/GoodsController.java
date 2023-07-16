package com.twelvet.server.goods.controller;

import java.util.List;

import com.twelvet.api.goods.domain.Goods;
import com.twelvet.framework.core.application.page.TableDataInfo;
import com.twelvet.server.goods.service.IGoodsService;
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
import com.twelvet.framework.core.application.controller.TWTController;
import com.twelvet.framework.core.application.domain.JsonResult;
import com.twelvet.framework.utils.poi.ExcelUtils;
import com.twelvet.framework.jdbc.web.utils.PageUtils;

/**
 * 商品Controller
 *
 * @author TwelveT
 * @WebSite twelvet.cn
 * @date 2023-07-16
 */
@Tag(description = "GoodsController", name = "商品")
@RestController
@RequestMapping("/goods")
public class GoodsController extends TWTController {

	@Autowired
	private IGoodsService goodsService;

	/**
	 * 查询商品列表
	 */
	@Operation(summary = "查询商品列表")
	@PreAuthorize("@role.hasPermi('{permissionPrefix}:list')")
	@GetMapping("/list")
	public JsonResult<TableDataInfo> list(Goods goods) {
		PageUtils.startPage();
		List<Goods> list = goodsService.selectGoodsList(goods);
		return JsonResult.success(PageUtils.getDataTable(list));
	}

	/**
	 * 导出商品列表
	 */
	@Operation(summary = "导出商品列表")
	@PreAuthorize("@role.hasPermi('{permissionPrefix}:export')")
	@Log(service = "商品", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	public void export(HttpServletResponse response, Goods goods) {
		List<Goods> list = goodsService.selectGoodsList(goods);
		ExcelUtils<Goods> util = new ExcelUtils<Goods>(Goods.class);
		util.exportExcel(response, list, "商品数据");
	}

	/**
	 * 获取商品详细信息
	 */
	@Operation(summary = "获取商品详细信息")
	@PreAuthorize("@role.hasPermi('{permissionPrefix}:query')")
	@GetMapping(value = "/{goodsId}")
	public JsonResult<Goods> getInfo(@PathVariable("goodsId") Long goodsId) {
		return JsonResult.success(goodsService.selectGoodsByGoodsId(goodsId));
	}

	/**
	 * 新增商品
	 */
	@Operation(summary = "新增商品")
	@PreAuthorize("@role.hasPermi('system:goods:add')")
	@Log(service = "商品", businessType = BusinessType.INSERT)
	@PostMapping
	public JsonResult<String> add(@RequestBody Goods goods) {
		return json(goodsService.insertGoods(goods));
	}

	/**
	 * 修改商品
	 */
	@Operation(summary = "修改商品")
	@PreAuthorize("@role.hasPermi('system:goods:edit')")
	@Log(service = "商品", businessType = BusinessType.UPDATE)
	@PutMapping
	public JsonResult<String> edit(@RequestBody Goods goods) {
		return json(goodsService.updateGoods(goods));
	}

	/**
	 * 删除商品
	 */
	@Operation(summary = "删除商品")
	@PreAuthorize("@role.hasPermi('system:goods:remove')")
	@Log(service = "商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{goodsIds}")
	public JsonResult<String> remove(@PathVariable Long[] goodsIds) {
		return json(goodsService.deleteGoodsByGoodsIds(goodsIds));
	}

}
