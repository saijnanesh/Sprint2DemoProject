package com.capgemini.main.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capgemini.main.dao.StockDao;

import com.capgemini.main.entites.StockDetails;


@Service
@Transactional

public class StockServiceImplementation implements StockService{

	@Autowired
	StockDao stockDao;
	
	

	@Override
	public boolean deleteItem(Long stockId) {
		return stockDao.deleteItem(stockId);
		
	}

	@Override
	public StockDetails getStockSpecs(Long stockId) {
		return stockDao.getStockSpecs(stockId);
	}
	
	

	
	@Override
	public List<StockDetails> getAllProducts() {
		
		return stockDao.reterive();
	}




	@Override
	public StockDetails updateProduct(Long stockId, StockDetails details) {
		
		return stockDao.updateProduct(stockId, details);
	}

	@Override
	public void addStock(StockDetails stockEntity) {
		boolean check = stockDao.addStockDao(stockEntity);
		if(check==true)
		{
			System.out.println("Stock Added");
		}
		else
		{
			System.out.println("Stock not added");
		}
		
	}



	
	
	

}
