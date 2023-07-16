package com.twelvet.server.goods.service;

import com.twelvet.api.goods.domain.GoodsSku;

import java.util.List;

/**
 * 单品SKUService接口
 *
 * @author TwelveT
 * @WebSite twelvet.cn
 * @date 2023-07-16
 */
public interface IGoodsSkuService {

	/**
	 * 查询单品SKU
	 * @param skuId 单品SKU主键
	 * @return 单品SKU
	 */
	public GoodsSku selectGoodsSkuBySkuId(Long skuId);

	/**
	 * 查询单品SKU列表
	 * @param goodsSku 单品SKU
	 * @return 单品SKU集合
	 */
	public List<GoodsSku> selectGoodsSkuList(GoodsSku goodsSku);

	/**
	 * 新增单品SKU
	 * @param goodsSku 单品SKU
	 * @return 结果
	 */
	public int insertGoodsSku(GoodsSku goodsSku);

	/**
	 * 修改单品SKU
	 * @param goodsSku 单品SKU
	 * @return 结果
	 */
	public int updateGoodsSku(GoodsSku goodsSku);

	/**
	 * 批量删除单品SKU
	 * @param skuIds 需要删除的单品SKU主键集合
	 * @return 结果
	 */
	public int deleteGoodsSkuBySkuIds(Long[] skuIds);

	/**
	 * 删除单品SKU信息
	 * @param skuId 单品SKU主键
	 * @return 结果
	 */
	public int deleteGoodsSkuBySkuId(Long skuId);

}
