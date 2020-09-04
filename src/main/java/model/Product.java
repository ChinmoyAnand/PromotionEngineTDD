package model;

import java.math.BigDecimal;

/**
 * @author chinmoy
 * This is the Product class which holds the basic info about Product.
 * BigDecimal is used for Price
 *
 */
public class Product {
	
	String skuId;
	String desc;
	BigDecimal price;
	
	public Product(String skuId, String desc, BigDecimal price) {
		super();
		this.skuId = skuId;
		this.desc = desc;
		this.price = price;
	}
	
	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	

}
