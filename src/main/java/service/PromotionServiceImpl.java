package service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Cart;
import model.Product;
import model.Promotion;
import model.PromotionName;
import model.SKU;

public class PromotionServiceImpl implements PromotionService {
	
	BigDecimal finalPrice = new BigDecimal(0);

	public BigDecimal calculateFinalCartPrice(Cart cart, List<Promotion> promotions) {
		List<Product> products = cart.getProducts();
		//Map to hold SKuID as Key and Quantity as Value(A,5)
		Map<SKU, Long> skuMap = products.stream()
			     .collect(Collectors.groupingBy(Product::getSkuId, 
			         Collectors.counting()));
		//Iterate the cart products and apply promotion
		if(promotions != null && promotions.size() != 0) {
			for(Promotion p : promotions) {
				if(p.getPromoName().equals(PromotionName.THREEA)) {
					int quantityA = skuMap.get(SKU.A).intValue();
					int times = quantityA/3;
					if(quantityA >= 3) {
						finalPrice = finalPrice.add(BigDecimal.valueOf(PromotionName.THREEA.getValue()).multiply(BigDecimal.valueOf(times)));
					}
					skuMap.put(SKU.A, new Long(quantityA - times*3));
				}
				if(p.getPromoName().equals(PromotionName.TWOB)) {
					int quantityB = skuMap.get(SKU.B).intValue();
					int times = quantityB/2;
					if(quantityB >= 2) {
						finalPrice = finalPrice.add(BigDecimal.valueOf(PromotionName.TWOB.getValue()).multiply(BigDecimal.valueOf(times)));
					}
					skuMap.put(SKU.B, new Long(quantityB - times*2));
				}
				if(p.getPromoName().equals(PromotionName.CD)) {
					if(skuMap.get(SKU.C) != null && skuMap.get(SKU.D) != null) {
						int quantityC = skuMap.get(SKU.C).intValue();
						int quantityD = skuMap.get(SKU.D).intValue();
						if(quantityC >= 1 && quantityD >=1) 
							finalPrice = finalPrice.add(BigDecimal.valueOf(PromotionName.CD.getValue()));
						skuMap.put(SKU.C, new Long(quantityC - 1));
						skuMap.put(SKU.D, new Long(quantityD - 1));
					}
				}
			}
			calculateCartPriceWithoutPromotion(skuMap);
		}
		else {
			calculateCartPriceWithoutPromotion(skuMap);
		}
		return finalPrice;
	}
	
	private void calculateCartPriceWithoutPromotion(Map<SKU, Long> skuMap) {
		for (Map.Entry<SKU,Long> entry : skuMap.entrySet())  {
            if(entry.getKey().equals(SKU.A)) {
            	finalPrice = finalPrice.add(BigDecimal.valueOf(SKU.A.getValue()).multiply(BigDecimal.valueOf(entry.getValue())));
            }
            if(entry.getKey().equals(SKU.B)) {
            	finalPrice = finalPrice.add(BigDecimal.valueOf(SKU.B.getValue()).multiply(BigDecimal.valueOf(entry.getValue())));
            }
            if(entry.getKey().equals(SKU.C)) {
            	finalPrice = finalPrice.add(BigDecimal.valueOf(SKU.C.getValue()).multiply(BigDecimal.valueOf(entry.getValue())));
            }
            if(entry.getKey().equals(SKU.D)) {
            	finalPrice = finalPrice.add(BigDecimal.valueOf(SKU.D.getValue()).multiply(BigDecimal.valueOf(entry.getValue())));
            }
        }
	}
}
