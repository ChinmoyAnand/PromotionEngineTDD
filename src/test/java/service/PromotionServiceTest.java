package service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import model.Product;
import model.Promotion;
import model.PromotionName;
import model.SKU;

public class PromotionServiceTest {
	
	PromotionService service = new PromotionServiceImpl();
	
	@Test
	public void calculatePromotionTest() {
		Product productA = new Product(SKU.A,"A product",new BigDecimal(50));
		Product productB = new Product(SKU.B,"Product B is added",BigDecimal.valueOf(30));
		Product productC = new Product(SKU.C,"Product C is added",BigDecimal.valueOf(20));
		List<Promotion> promotions = Arrays.asList(new Promotion(true,PromotionName.THREEA,BigDecimal.valueOf(130)));
		assertEquals(new BigDecimal(100), service.calculatePromotion(Arrays.asList(productA,productB,productC),promotions));
	}

}
