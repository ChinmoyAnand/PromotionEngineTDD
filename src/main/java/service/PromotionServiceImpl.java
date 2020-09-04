package service;

import java.math.BigDecimal;
import java.util.List;

import model.Cart;
import model.Product;
import model.Promotion;

public class PromotionServiceImpl implements PromotionService {

	public BigDecimal calculateFinalCartPrice(Cart cart, List<Promotion> promotions) {
		BigDecimal price = cart.getProducts().stream()
			.map(x -> x.getPrice())
			.reduce(BigDecimal.ZERO, BigDecimal::add);
		return price;
	}
	
	

}
