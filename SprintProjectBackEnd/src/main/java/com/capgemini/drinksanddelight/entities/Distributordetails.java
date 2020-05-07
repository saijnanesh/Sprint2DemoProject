package com.capgemini.drinksanddelight.entities;

import javax.persistence.Entity;

import javax.persistence.Id;



@Entity

public class Distributordetails {
	
	
	@Id
	
	private String Distributor_Id;
	
	private String Distributor_Name;
	
	private String Distributor_Address;
	
	
	private String Distributor_Phn;

	
	
	public Distributordetails()
	{
		
		
		
		
	}
	
	

	public Distributordetails(String distributor_Id, String distributor_Name, String distributor_Address,
			String distributor_Phn) {
		super();
		Distributor_Id = distributor_Id;
		Distributor_Name = distributor_Name;
		Distributor_Address = distributor_Address;
		Distributor_Phn = distributor_Phn;
	}


	public String getDistributor_Id() {
		return Distributor_Id;
	}


	public void setDistributor_Id(String distributor_Id) {
		Distributor_Id = distributor_Id;
	}


	public String getDistributor_Name() {
		return Distributor_Name;
	}


	public void setDistributor_Name(String distributor_Name) {
		Distributor_Name = distributor_Name;
	}


	public String getDistributor_Address() {
		return Distributor_Address;
	}


	public void setDistributor_Address(String distributor_Address) {
		Distributor_Address = distributor_Address;
	}


	public String getDistributor_Phn() {
		return Distributor_Phn;
	}


	public void setDistributor_Phn(String distributor_Phn) {
		Distributor_Phn = distributor_Phn;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
