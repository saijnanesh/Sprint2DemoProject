package com.capgemini.drinkanddelight.service;

import java.util.List;

import com.capgemini.drinkanddelight.entity.Distributor;
import com.capgemini.drinkanddelight.entity.ProductOrder;

public interface ProductOrderEntityServiceInterface {
	
	public ProductOrder addProductOrderEntity(ProductOrder productorderentity);
	public List<ProductOrder> getListOfProductOrderEntity();
	public List<Distributor> getDistributors();

	public ProductOrder findByOrderId(String orderId);
	public Boolean deleteProductOrderEntity(String orderId) ;
	public List<ProductOrder> displayProductOrder (String distibutorId);
	
	
	public List<String> displayOrder(String id);
	public List<ProductOrder> displayOrder1(String id);
	
	public List<ProductOrder> displayIdwithStatus(String id, String status); 
	
	public Distributor getDistributorDetails(String distributorId);
}
