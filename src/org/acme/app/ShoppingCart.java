package org.acme.app;

import java.util.ArrayList;
import java.math.BigDecimal;

public class ShoppingCart{
	
	private ArrayList<Item> items;
	
	public ShoppingCart(){
		this.items = new ArrayList<Item>();
	}
	
	public void addItem(Item itm){
		this.items.add(itm);
	}
	
	public BigDecimal getTotalPrice(){
		BigDecimal total = new BigDecimal(0);
		for(Item item : this.items){
		  total = total.add(item.getPrice());
		}
		return total;
	}
}