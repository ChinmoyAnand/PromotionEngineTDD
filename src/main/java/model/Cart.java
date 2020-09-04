package model;

import java.util.List;

public class Cart {
	
	List<Product> products;
	
	public Cart(List<Product> products) {
		super();
		this.products = products;
	}

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
