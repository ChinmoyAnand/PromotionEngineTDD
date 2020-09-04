package service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Test;

import model.Product;

public class PromotionServiceTest {
	
	PromotionService service = new PromotionServiceImpl();
	
	@Test
	public void calculatePromotionTest() {
		Product productA = new Product("A","A product",new BigDecimal(50));
		assertEquals(new BigDecimal(50), service.calculatePromotion(Arrays.asList(productA)));
	}

}
