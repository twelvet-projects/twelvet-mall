package com.twelvet.server.goods.controller.client;

import com.twelvet.api.goods.domain.Goods;
import com.twelvet.framework.core.application.controller.TWTController;
import com.twelvet.framework.core.application.domain.JsonResult;
import com.twelvet.framework.core.application.page.TableDataInfo;
import com.twelvet.framework.jdbc.web.utils.PageUtils;
import com.twelvet.framework.security.annotation.AuthIgnore;
import com.twelvet.server.goods.service.IGoodsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品Controller
 *
 * @author TwelveT
 * @WebSite twelvet.cn
 * @date 2023-07-16
 */
@AuthIgnore(value = false)
@Tag(description = "GoodsClientController", name = "商品服务")
@RestController
@RequestMapping("/client/goods")
public class GoodsClientController extends TWTController {

	@Autowired
	private IGoodsService goodsService;

	/**
	 * 查询商品列表
	 */
	@Operation(summary = "查询商品列表")
	@GetMapping("/list")
	public JsonResult<TableDataInfo> list(Goods goods) {
		PageUtils.startPage();
		List<Goods> list = goodsService.selectGoodsList(goods);
		return JsonResult.success(PageUtils.getDataTable(list));
	}

	/**
	 * 获取商品详细信息
	 */
	@Operation(summary = "获取商品详细信息")
	@GetMapping(value = "/{goodsId}")
	public JsonResult<Goods> getInfo(@PathVariable("goodsId") Long goodsId) {
		return JsonResult.success(goodsService.selectGoodsByGoodsId(goodsId));
	}

}
