package service;

import java.math.BigDecimal;
import java.util.List;

import model.Cart;
import model.Product;
import model.Promotion;
import model.PromotionName;
import model.SKU;

public interface PromotionService {
	
	public BigDecimal calculateFinalCartPrice(Cart cart, List<Promotion> promotions);
	
	public Promotion createPromotion(PromotionName promoName, SKU sku, int percent);

}
