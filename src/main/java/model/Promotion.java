package model;

import java.math.BigDecimal;

/**
* @author chinmoy
* This is the Promotion class which holds the basic info about Promotion.
*
*/
public class Promotion {
	
	boolean active;
	PromotionName promoName;
	BigDecimal promoPrice;
	
	public Promotion() {}
	
	public Promotion(boolean active, PromotionName promoName, BigDecimal promoPrice) {
		super();
		this.active = active;
		this.promoName = promoName;
		this.promoPrice = promoPrice;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public PromotionName getPromoName() {
		return promoName;
	}

	public void setPromoName(PromotionName promoName) {
		this.promoName = promoName;
	}

	public BigDecimal getPromoPrice() {
		return promoPrice;
	}

	public void setPromoPrice(BigDecimal promoPrice) {
		this.promoPrice = promoPrice;
	}
	
}
