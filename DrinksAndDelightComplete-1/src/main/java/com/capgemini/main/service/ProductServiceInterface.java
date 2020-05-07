package com.capgemini.main.service;

import java.util.List;

import com.capgemini.main.entites.OrderDetails;
import com.capgemini.main.entites.RawSpecs;

public interface ProductServiceInterface {
	
	public boolean orderProduct(OrderDetails productEntity);
	public boolean cancelProduct(int orderId);
	public RawSpecs getProductSpecs(int rmsId);
	public OrderDetails findOrderById(int id);
	public List<RawSpecs> retrieve();
	public List<OrderDetails> retrieveOrderList();
	public boolean updateProduct(OrderDetails productEntity);
}
