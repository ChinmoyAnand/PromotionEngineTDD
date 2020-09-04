package controller;

import java.math.BigDecimal;
import java.util.List;

import exception.ProductIsEmptyException;
import model.Cart;
import model.Product;
import model.Promotion;
import service.PromotionService;
import service.PromotionServiceImpl;

public class ProductController {
	
	Cart cart = new Cart();
	PromotionService service = new PromotionServiceImpl();
	
	public Cart addProductToCart(List<Product> product) throws ProductIsEmptyException{
		Cart cart = null;
		if(product!=null)
			cart =  new Cart(product);
		else
			throw new ProductIsEmptyException("Product Cannot be Empty");
		return cart;
	}
	
	public void finalCheckoutWithPromotion(List<Promotion> promos) {
		BigDecimal finalPrice = service.calculateFinalCartPrice(cart, promos);
		System.out.println("FINAL COST*** "+finalPrice);
	}

}
