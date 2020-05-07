package com.capgemini.drinksanddelight.dao;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.drinksanddelight.entities.Distributordetails;
import com.capgemini.drinksanddelight.entities.ProductorderDetails;




public interface DrinksAndDelightDao {
	
	
	
	public List<Distributordetails> reterive();
	
	public boolean updateTrackOrder(String orderId,String Location,LocalDate date,String status);
	
	
	public ProductorderDetails trackOrder(String id);
	
	
	public boolean addDistributorDetails(String id,String name,String address, String phn);
	
	
	
	
	

}
