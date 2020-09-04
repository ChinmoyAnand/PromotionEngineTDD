package service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class PromotionServiceTest {
	
	PromotionService service = new PromotionServiceImpl();
	
	@Test
	public void calculatePromotionTest() {
		assertEquals(new BigDecimal(100), service.calculatePromotion());
	}

}
