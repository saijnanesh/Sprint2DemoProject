package com.capgemini.main.service;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.capgemini.main.entites.StockDetails;
@CrossOrigin("*")
public interface StockService {
	
	
	public StockDetails getStockSpecs(Long stockId);

	
	public List<StockDetails> getAllProducts();


	public StockDetails updateProduct(Long stockId, StockDetails details);
	
	public boolean deleteItem(Long stockId);
	
	public void addStock(StockDetails stockEntity);
	
}

