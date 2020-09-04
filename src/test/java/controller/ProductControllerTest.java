package controller;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import exception.ProductIsEmptyException;
import model.Cart;
import model.Product;
import model.SKU;

public class ProductControllerTest {
	ProductController controller = new ProductController();
	
	@Test
	public void addToCartOneProductTest() throws ProductIsEmptyException {
		Product productA = new Product(SKU.A,"Product A is added",BigDecimal.valueOf(50));
		List<Product> products = Arrays.asList(productA);
		Cart cart = controller.addProductToCart(products);
		List<Cart> carts = Arrays.asList(cart);
		assertEquals(1,carts.size());
	}
	
	@Test
	public void addToCart3ProductTest() throws ProductIsEmptyException {
		Product productA = new Product(SKU.A,"Product A is added",BigDecimal.valueOf(50));
		Product productB = new Product(SKU.B,"Product B is added",BigDecimal.valueOf(30));
		Product productC = new Product(SKU.C,"Product C is added",BigDecimal.valueOf(20));
		List<Product> products = Arrays.asList(productA,productB,productC);
		Cart cart = controller.addProductToCart(products);
		assertEquals(3,cart.getProducts().size());
	}

}
