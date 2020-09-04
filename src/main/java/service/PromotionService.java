package service;

import java.math.BigDecimal;
import java.util.List;

import model.Product;

public interface PromotionService {
	
	BigDecimal calculatePromotion(List<Product> products);

}
