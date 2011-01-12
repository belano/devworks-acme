package org.acme.app;

import java.util.ArrayList;

public class CouponService{
	
	private static ArrayList<Customer> scheduledEmails = new ArrayList<Customer>();
	
	public static ArrayList getScheduledEmails(){
		return scheduledEmails;
	}
	
	public static void scheduleDiscountEmail(Customer cust){
		scheduledEmails.add(cust);
	}
	
}