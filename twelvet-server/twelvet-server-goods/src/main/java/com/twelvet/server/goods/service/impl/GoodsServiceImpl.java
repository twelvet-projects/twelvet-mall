package com.twelvet.server.goods.service.impl;

import java.util.List;

import com.twelvet.api.goods.domain.Goods;
import com.twelvet.server.goods.mapper.GoodsMapper;
import com.twelvet.server.goods.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品Service业务层处理
 *
 * @author TwelveT
 * @WebSite twelvet.cn
 * @date 2023-07-16
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	/**
	 * 查询商品
	 * @param goodsId 商品主键
	 * @return 商品
	 */
	@Override
	public Goods selectGoodsByGoodsId(Long goodsId) {
		return goodsMapper.selectGoodsByGoodsId(goodsId);
	}

	/**
	 * 查询商品列表
	 * @param goods 商品
	 * @return 商品
	 */
	@Override
	public List<Goods> selectGoodsList(Goods goods) {
		return goodsMapper.selectGoodsList(goods);
	}

	/**
	 * 新增商品
	 * @param goods 商品
	 * @return 结果
	 */
	@Override
	public int insertGoods(Goods goods) {
		return goodsMapper.insertGoods(goods);
	}

	/**
	 * 修改商品
	 * @param goods 商品
	 * @return 结果
	 */
	@Override
	public int updateGoods(Goods goods) {
		return goodsMapper.updateGoods(goods);
	}

	/**
	 * 批量删除商品
	 * @param goodsIds 需要删除的商品主键
	 * @return 结果
	 */
	@Override
	public int deleteGoodsByGoodsIds(Long[] goodsIds) {
		return goodsMapper.deleteGoodsByGoodsIds(goodsIds);
	}

	/**
	 * 删除商品信息
	 * @param goodsId 商品主键
	 * @return 结果
	 */
	@Override
	public int deleteGoodsByGoodsId(Long goodsId) {
		return goodsMapper.deleteGoodsByGoodsId(goodsId);
	}

}
