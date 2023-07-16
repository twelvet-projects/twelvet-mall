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
 * 商品对象 goods
 *
 * @author TwelveT
 * @WebSite twelvet.cn
 * @date 2023-07-16
 */
@Schema(description = "商品对象")
public class Goods extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** $column.columnComment */
	@Schema(description = "$column.columnComment")
	private Long goodsId;

	/** 商品名称 */
	@Schema(description = "商品名称")
	@Excel(name = "商品名称")
	private String goodsName;

	/** 店铺id */
	@Schema(description = "店铺id")
	@Excel(name = "店铺id")
	private Long shopId;

	/** 原价 */
	@Schema(description = "原价")
	@Excel(name = "原价")
	private BigDecimal originalPrice;

	/** 现价 */
	@Schema(description = "现价")
	@Excel(name = "现价")
	private BigDecimal price;

	/** 简要描述,卖点等 */
	@Schema(description = "简要描述,卖点等")
	@Excel(name = "简要描述,卖点等")
	private String brief;

	/** 详细描述 */
	@Schema(description = "详细描述")
	@Excel(name = "详细描述")
	private String content;

	/** 商品主图 */
	@Schema(description = "商品主图")
	@Excel(name = "商品主图")
	private String pic;

	/** 商品图片，以,分割 */
	@Schema(description = "商品图片，以,分割")
	@Excel(name = "商品图片，以,分割")
	private String imgs;

	/** 1:下架,-1:表示删除,0:表示正常状态 */
	@Schema(description = "1:下架,-1:表示删除,0:表示正常状态")
	@Excel(name = "1:下架,-1:表示删除,0:表示正常状态")
	private Integer status;

	/** 商品分类 */
	@Schema(description = "商品分类")
	@Excel(name = "商品分类")
	private Long categoryId;

	/** 销量 */
	@Schema(description = "销量")
	@Excel(name = "销量")
	private Long soldNum;

	/** 总库存 */
	@Schema(description = "总库存")
	@Excel(name = "总库存")
	private Long totalStocks;

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

	/** 版本 乐观锁 */
	@Schema(description = "版本 乐观锁")
	@Excel(name = "版本 乐观锁")
	private Long version;

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return shopId;
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

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getBrief() {
		return brief;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPic() {
		return pic;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	public String getImgs() {
		return imgs;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setSoldNum(Long soldNum) {
		this.soldNum = soldNum;
	}

	public Long getSoldNum() {
		return soldNum;
	}

	public void setTotalStocks(Long totalStocks) {
		this.totalStocks = totalStocks;
	}

	public Long getTotalStocks() {
		return totalStocks;
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
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("goodsId", getGoodsId())
			.append("goodsName", getGoodsName())
			.append("shopId", getShopId())
			.append("originalPrice", getOriginalPrice())
			.append("price", getPrice())
			.append("brief", getBrief())
			.append("content", getContent())
			.append("pic", getPic())
			.append("imgs", getImgs())
			.append("status", getStatus())
			.append("categoryId", getCategoryId())
			.append("soldNum", getSoldNum())
			.append("totalStocks", getTotalStocks())
			.append("createdTime", getCreatedTime())
			.append("updatedTime", getUpdatedTime())
			.append("version", getVersion())
			.toString();
	}

}
