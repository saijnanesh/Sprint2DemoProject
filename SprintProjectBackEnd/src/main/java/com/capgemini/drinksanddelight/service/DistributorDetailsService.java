package com.capgemini.drinksanddelight.service;

import java.util.List;

import com.capgemini.drinksanddelight.entities.Distributordetails;

public interface DistributorDetailsService {
	
	
	
	public List<Distributordetails> reterive();
	
	
	public boolean addDistributorDetails(String id,String name,String address, String phn);
	
	
	
	

}
