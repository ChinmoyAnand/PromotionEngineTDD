package service;

import java.math.BigDecimal;
import java.util.List;

import model.Cart;
import model.Promotion;

public interface PromotionService {
	
	BigDecimal calculateFinalCartPrice(Cart cart, List<Promotion> promotions);

}
