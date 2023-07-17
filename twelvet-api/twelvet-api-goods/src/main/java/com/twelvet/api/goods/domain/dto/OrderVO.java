package com.twelvet.api.goods.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 提交订单VO
 */
@Schema(description = "商品对象")
public class OrderVO implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Schema(description = "下单商品ID")
	private Long goodsId;

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	@Override
	public String toString() {
		return "OrderVO{" + "goodsId=" + goodsId + '}';
	}

}
