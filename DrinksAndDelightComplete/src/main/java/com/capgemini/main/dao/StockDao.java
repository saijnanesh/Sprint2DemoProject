package com.capgemini.main.dao;


import java.util.List;



import com.capgemini.main.entites.StockDetails;

public interface StockDao {
	
	public StockDetails getStockSpecs(Long stockId);
	
	public List<StockDetails> reterive();

	

	public StockDetails updateProduct(Long stockId, StockDetails details);

	public boolean deleteItem(Long stockId);

	public boolean addStockDao(StockDetails stockEntity);

	

}
