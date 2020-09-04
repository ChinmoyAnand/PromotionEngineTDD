package service;

import java.math.BigDecimal;
import java.util.List;

import model.Product;
import model.Promotion;

public class PromotionServiceImpl implements PromotionService {

	public BigDecimal calculatePromotion(List<Product> products, List<Promotion> promotions) {
		BigDecimal price = products.stream()
			.map(x -> x.getPrice())
			.reduce(BigDecimal.ZERO, BigDecimal::add);
		return price;
	}
	
	

}
