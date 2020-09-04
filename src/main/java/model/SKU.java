package model;

/**
 * @author c
 * This is the SKU ENUM class, we have the price as value
 *
 */
public enum SKU {
	
	A(50),B(30),C(20),D(15);
	
	private int value;

    private SKU(int value) {
       this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
