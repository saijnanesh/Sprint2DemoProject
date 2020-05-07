package com.capgemini.main.dao;

import java.util.List;

import com.capgemini.main.entites.OrderDetails;
import com.capgemini.main.entites.RawSpecs;

public interface ProductDaoInterface {
	public boolean placeOrder(OrderDetails productEntity);
	public boolean cancelOrder(int orderId);
	public RawSpecs getProductSpecs(int rmsId);
	public OrderDetails findOrderById(int id);
	public List<RawSpecs> reterive();
	public List<OrderDetails> reteriveOrderList();
	public boolean updateOrder(OrderDetails productEntity);
	}
