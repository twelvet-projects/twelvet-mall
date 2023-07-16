package com.twelvet.server.goods.service;

import com.twelvet.api.goods.domain.Goods;

import java.util.List;

/**
 * 商品Service接口
 *
 * @author TwelveT
 * @WebSite twelvet.cn
 * @date 2023-07-16
 */
public interface IGoodsService {

	/**
	 * 查询商品
	 * @param goodsId 商品主键
	 * @return 商品
	 */
	public Goods selectGoodsByGoodsId(Long goodsId);

	/**
	 * 查询商品列表
	 * @param goods 商品
	 * @return 商品集合
	 */
	public List<Goods> selectGoodsList(Goods goods);

	/**
	 * 新增商品
	 * @param goods 商品
	 * @return 结果
	 */
	public int insertGoods(Goods goods);

	/**
	 * 修改商品
	 * @param goods 商品
	 * @return 结果
	 */
	public int updateGoods(Goods goods);

	/**
	 * 批量删除商品
	 * @param goodsIds 需要删除的商品主键集合
	 * @return 结果
	 */
	public int deleteGoodsByGoodsIds(Long[] goodsIds);

	/**
	 * 删除商品信息
	 * @param goodsId 商品主键
	 * @return 结果
	 */
	public int deleteGoodsByGoodsId(Long goodsId);

}
