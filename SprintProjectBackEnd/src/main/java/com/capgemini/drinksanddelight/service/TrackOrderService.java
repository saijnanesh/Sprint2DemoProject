package com.capgemini.drinksanddelight.service;

import com.capgemini.drinksanddelight.entities.ProductorderDetails;
import com.capgemini.drinksanddelight.exception.OrderIdNotFoundException;

public interface TrackOrderService {
	
	
	
	public ProductorderDetails trackOrder(String id) throws OrderIdNotFoundException;
	
	
	
	
	

}
