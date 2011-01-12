package org.acme.app;

import java.math.BigDecimal;

public class Item{
	private BigDecimal price;
	
	public Item(String name, BigDecimal price){
		this.price = price;
	}
		
	public BigDecimal getPrice(){
		return this.price;
	}		
}