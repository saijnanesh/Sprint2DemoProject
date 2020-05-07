package com.capgemini.drinkanddelight.dao;

import java.util.List;

import com.capgemini.drinkanddelight.entity.Distributor;
import com.capgemini.drinkanddelight.entity.ProductOrder;

public interface ProductOrderDaoI {
	
	public void addProductOrderEntity(ProductOrder productorderentity);
	public List<ProductOrder> getListOfProductOrderEntity();
	public List<Distributor> getDistributors();
	public ProductOrder findByOrderId(String orderId);
	public Boolean deleteProductOrderEntity(String orderId);
	
	public List<ProductOrder> displayProductOrder(String distibutorId);
	/*
	 * HardCoding 
	 */
	public List<String> displayOrder(String id);
	
	/*
	 * Json Format 
	 */
	public List<ProductOrder> displayOrder1(String id);
	
	/*
	 * distributor Id and the deliveryStatus 
	 */
	public List<ProductOrder>  displayIdwithStatus(String id,String status);
	
	
	public Distributor getDistributorDetails(String distributorId);
}
