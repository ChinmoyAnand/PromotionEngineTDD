package service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import model.Cart;
import model.Product;
import model.Promotion;
import model.PromotionName;
import model.SKU;

public class PromotionServiceTest {
	
	PromotionService service = new PromotionServiceImpl();
	Product productA = new Product(SKU.A,"A product",new BigDecimal(50));
	Product productB = new Product(SKU.B,"Product B is added",BigDecimal.valueOf(30));
	Product productC = new Product(SKU.C,"Product C is added",BigDecimal.valueOf(20));
	
	@Test
	public void calculatePromotionWithPromotionAppliedTest() {
		List<Promotion> promotions = Arrays.asList(new Promotion(true,PromotionName.THREEA,BigDecimal.valueOf(130)));
		List<Product> products = Arrays.asList(productA,productB,productC);
		Cart cart = new Cart(products);
		assertEquals(new BigDecimal(100), service.calculateFinalCartPrice(cart,promotions));
	}
	
	@Test
	public void calculateFinalPriceAfterSatisfyPromotionTest() {
		List<Product> products = Arrays.asList(productA,productA,productA,productA,productA,productB,productB,productB,productB,productB,productC);
		Cart cart = new Cart(products);
		List<Promotion> promotions = Arrays.asList(new Promotion(true,PromotionName.THREEA,BigDecimal.valueOf(130)),
				new Promotion(true,PromotionName.TWOB,BigDecimal.valueOf(45)),new Promotion(true,PromotionName.CD,BigDecimal.valueOf(30)));
		assertEquals(BigDecimal.valueOf(370), service.calculateFinalCartPrice(cart, promotions));
	}
	
	@Test
	public void calculateFinalPriceWithoutPromotionTest() {
		List<Product> products = Arrays.asList(productA,productB,productC);
		Cart cart = new Cart(products);
		assertEquals(BigDecimal.valueOf(100), service.calculateFinalCartPrice(cart, null));
	}

}
