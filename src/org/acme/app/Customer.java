package org.acme.app;

import java.math.BigDecimal;

public class Customer{
	private ShoppingCart shoppingCart;
	private boolean goldLevel;
	
	public Customer(){}
	
	public void setGoldLevel(boolean value){
		this.goldLevel = value;
	}
	
	public void setShoppingCart(ShoppingCart cart){
		this.shoppingCart = cart;
	}
	
	public boolean getGoldLevel(){
		return this.goldLevel;
	}
	
	public ShoppingCart getShoppingCart(){
		return this.shoppingCart;
	}
	
	public void checkOut(){}
	
	public BigDecimal orderPrice(){
		if(!this.goldLevel){
			BigDecimal total = this.shoppingCart.getTotalPrice();
			if(total.compareTo(new BigDecimal("100.00")) >= 0 ){
				return this.shoppingCart.getTotalPrice().subtract(new BigDecimal("10.00"));
			}else{
				return total;
			}
		}else{
			return this.shoppingCart.getTotalPrice();
		}
	}
}