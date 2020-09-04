package service;

import java.math.BigDecimal;
import java.util.List;

import model.Product;
import model.Promotion;

public interface PromotionService {
	
	BigDecimal calculatePromotion(List<Product> products, List<Promotion> promotions);

}
