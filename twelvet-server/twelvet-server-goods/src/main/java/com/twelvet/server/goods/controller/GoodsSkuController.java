package com.twelvet.server.goods.controller;

import java.util.List;

import com.twelvet.api.goods.domain.GoodsSku;
import com.twelvet.framework.core.application.page.TableDataInfo;
import com.twelvet.server.goods.service.IGoodsSkuService;
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
 * 单品SKUController
 *
 * @author TwelveT
 * @WebSite twelvet.cn
 * @date 2023-07-16
 */
@Tag(description = "GoodsSkuController", name = "单品SKU")
@RestController
@RequestMapping("/sku")
public class GoodsSkuController extends TWTController {

	@Autowired
	private IGoodsSkuService goodsSkuService;

	/**
	 * 查询单品SKU列表
	 */
	@Operation(summary = "查询单品SKU列表")
	@PreAuthorize("@role.hasPermi('{permissionPrefix}:list')")
	@GetMapping("/list")
	public JsonResult<TableDataInfo> list(GoodsSku goodsSku) {
		PageUtils.startPage();
		List<GoodsSku> list = goodsSkuService.selectGoodsSkuList(goodsSku);
		return JsonResult.success(PageUtils.getDataTable(list));
	}

	/**
	 * 导出单品SKU列表
	 */
	@Operation(summary = "导出单品SKU列表")
	@PreAuthorize("@role.hasPermi('{permissionPrefix}:export')")
	@Log(service = "单品SKU", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	public void export(HttpServletResponse response, GoodsSku goodsSku) {
		List<GoodsSku> list = goodsSkuService.selectGoodsSkuList(goodsSku);
		ExcelUtils<GoodsSku> util = new ExcelUtils<GoodsSku>(GoodsSku.class);
		util.exportExcel(response, list, "单品SKU数据");
	}

	/**
	 * 获取单品SKU详细信息
	 */
	@Operation(summary = "获取单品SKU详细信息")
	@PreAuthorize("@role.hasPermi('{permissionPrefix}:query')")
	@GetMapping(value = "/{skuId}")
	public JsonResult<GoodsSku> getInfo(@PathVariable("skuId") Long skuId) {
		return JsonResult.success(goodsSkuService.selectGoodsSkuBySkuId(skuId));
	}

	/**
	 * 新增单品SKU
	 */
	@Operation(summary = "新增单品SKU")
	@PreAuthorize("@role.hasPermi('system:sku:add')")
	@Log(service = "单品SKU", businessType = BusinessType.INSERT)
	@PostMapping
	public JsonResult<String> add(@RequestBody GoodsSku goodsSku) {
		return json(goodsSkuService.insertGoodsSku(goodsSku));
	}

	/**
	 * 修改单品SKU
	 */
	@Operation(summary = "修改单品SKU")
	@PreAuthorize("@role.hasPermi('system:sku:edit')")
	@Log(service = "单品SKU", businessType = BusinessType.UPDATE)
	@PutMapping
	public JsonResult<String> edit(@RequestBody GoodsSku goodsSku) {
		return json(goodsSkuService.updateGoodsSku(goodsSku));
	}

	/**
	 * 删除单品SKU
	 */
	@Operation(summary = "删除单品SKU")
	@PreAuthorize("@role.hasPermi('system:sku:remove')")
	@Log(service = "单品SKU", businessType = BusinessType.DELETE)
	@DeleteMapping("/{skuIds}")
	public JsonResult<String> remove(@PathVariable Long[] skuIds) {
		return json(goodsSkuService.deleteGoodsSkuBySkuIds(skuIds));
	}

}
