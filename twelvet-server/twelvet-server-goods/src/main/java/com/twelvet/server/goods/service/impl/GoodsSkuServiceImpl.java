package com.twelvet.server.goods.service.impl;

import java.util.List;

import com.twelvet.api.goods.domain.GoodsSku;
import com.twelvet.server.goods.mapper.GoodsSkuMapper;
import com.twelvet.server.goods.service.IGoodsSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 单品SKUService业务层处理
 *
 * @author TwelveT
 * @WebSite twelvet.cn
 * @date 2023-07-16
 */
@Service
public class GoodsSkuServiceImpl implements IGoodsSkuService {

	@Autowired
	private GoodsSkuMapper goodsSkuMapper;

	/**
	 * 查询单品SKU
	 * @param skuId 单品SKU主键
	 * @return 单品SKU
	 */
	@Override
	public GoodsSku selectGoodsSkuBySkuId(Long skuId) {
		return goodsSkuMapper.selectGoodsSkuBySkuId(skuId);
	}

	/**
	 * 查询单品SKU列表
	 * @param goodsSku 单品SKU
	 * @return 单品SKU
	 */
	@Override
	public List<GoodsSku> selectGoodsSkuList(GoodsSku goodsSku) {
		return goodsSkuMapper.selectGoodsSkuList(goodsSku);
	}

	/**
	 * 新增单品SKU
	 * @param goodsSku 单品SKU
	 * @return 结果
	 */
	@Override
	public int insertGoodsSku(GoodsSku goodsSku) {
		return goodsSkuMapper.insertGoodsSku(goodsSku);
	}

	/**
	 * 修改单品SKU
	 * @param goodsSku 单品SKU
	 * @return 结果
	 */
	@Override
	public int updateGoodsSku(GoodsSku goodsSku) {
		return goodsSkuMapper.updateGoodsSku(goodsSku);
	}

	/**
	 * 批量删除单品SKU
	 * @param skuIds 需要删除的单品SKU主键
	 * @return 结果
	 */
	@Override
	public int deleteGoodsSkuBySkuIds(Long[] skuIds) {
		return goodsSkuMapper.deleteGoodsSkuBySkuIds(skuIds);
	}

	/**
	 * 删除单品SKU信息
	 * @param skuId 单品SKU主键
	 * @return 结果
	 */
	@Override
	public int deleteGoodsSkuBySkuId(Long skuId) {
		return goodsSkuMapper.deleteGoodsSkuBySkuId(skuId);
	}

}
