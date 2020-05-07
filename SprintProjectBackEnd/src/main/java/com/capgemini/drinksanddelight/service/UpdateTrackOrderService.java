package com.capgemini.drinksanddelight.service;

import java.time.LocalDate;

import com.capgemini.drinksanddelight.exception.OrderIdNotFoundException;


public interface UpdateTrackOrderService {
	
	

	
	
	
	public boolean updateTrackOrder(String orderId, String Location, LocalDate date,String status) throws OrderIdNotFoundException ;
	

}
