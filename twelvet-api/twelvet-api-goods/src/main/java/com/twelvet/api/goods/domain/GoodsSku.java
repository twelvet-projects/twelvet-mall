package com.twelvet.api.goods.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.twelvet.framework.utils.annotation.excel.Excel;
import com.twelvet.framework.core.application.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 单品SKU对象 goods_sku
 *
 * @author TwelveT
 * @WebSite twelvet.cn
 * @date 2023-07-16
 */
@Schema(description = "单品SKU对象")
public class GoodsSku extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** 单品ID */
	@Schema(description = "单品ID")
	private Long skuId;

	/** 商品ID */
	@Schema(description = "商品ID")
	@Excel(name = "商品ID")
	private Long goodsId;

	/** 原价 */
	@Schema(description = "原价")
	@Excel(name = "原价")
	private BigDecimal originalPrice;

	/** 价格 */
	@Schema(description = "价格")
	@Excel(name = "价格")
	private BigDecimal price;

	/** 商品在付款减库存的状态下，该sku上未付款的订单数量 */
	@Schema(description = "商品在付款减库存的状态下，该sku上未付款的订单数量")
	@Excel(name = "商品在付款减库存的状态下，该sku上未付款的订单数量")
	private Long stocks;

	/** 实际库存 */
	@Schema(description = "实际库存")
	@Excel(name = "实际库存")
	private Long actualStocks;

	/** sku图片 */
	@Schema(description = "sku图片")
	@Excel(name = "sku图片")
	private String pic;

	/** sku名称 */
	@Schema(description = "sku名称")
	@Excel(name = "sku名称")
	private String skuName;

	/** 商品名称 */
	@Schema(description = "商品名称")
	@Excel(name = "商品名称")
	private String goodsName;

	/** 0 正常 1 已被删除 */
	@Schema(description = "0 正常 1 已被删除")
	@Excel(name = "0 正常 1 已被删除")
	private Integer isDelete;

	/** 创建时间 */
	@Schema(description = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
	private Date createdTime;

	/** 更新时间 */
	@Schema(description = "更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
	private Date updatedTime;

	/** 版本号 */
	@Schema(description = "版本号")
	@Excel(name = "版本号")
	private Long version;

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setStocks(Long stocks) {
		this.stocks = stocks;
	}

	public Long getStocks() {
		return stocks;
	}

	public void setActualStocks(Long actualStocks) {
		this.actualStocks = actualStocks;
	}

	public Long getActualStocks() {
		return actualStocks;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPic() {
		return pic;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getVersion() {
		return version;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("skuId", getSkuId())
			.append("goodsId", getGoodsId())
			.append("originalPrice", getOriginalPrice())
			.append("price", getPrice())
			.append("stocks", getStocks())
			.append("actualStocks", getActualStocks())
			.append("pic", getPic())
			.append("skuName", getSkuName())
			.append("goodsName", getGoodsName())
			.append("isDelete", getIsDelete())
			.append("createdTime", getCreatedTime())
			.append("updatedTime", getUpdatedTime())
			.append("version", getVersion())
			.toString();
	}

}
