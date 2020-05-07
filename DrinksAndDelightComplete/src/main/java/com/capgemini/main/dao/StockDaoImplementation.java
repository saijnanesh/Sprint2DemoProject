package com.capgemini.main.dao;



import java.util.List;


import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import com.capgemini.main.entites.StockDetails;




@Repository
public class StockDaoImplementation implements StockDao{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public StockDetails getStockSpecs(Long stockId) {
		return entityManager.find(StockDetails.class,stockId);
	}

	
	
	@Override
	public List<StockDetails> reterive() {
		String Qstr=" from StockDetails";
		TypedQuery<StockDetails> query=entityManager.createQuery(Qstr,StockDetails.class);
		System.out.println("dao impl");
		return query.getResultList();
		}



	@Override
	public StockDetails updateProduct(Long stockId, StockDetails details) {
	
	StockDetails details1=entityManager.find(StockDetails.class, stockId);
			
	if(stockId==details1.getStockId()) {
			details1.setManufactureDate(details.getManufactureDate());
			
			details1.setExpiryDate(details.getExpiryDate());
	}

		return details1;
		
	}
	
	@Override
	public boolean deleteItem(Long stockId) {
		StockDetails details1=entityManager.find(StockDetails.class, stockId);
		
		if(stockId==details1.getStockId()) {
		
			entityManager.remove(entityManager.find(StockDetails.class, stockId));
			return true;
		}
		else {
			return false;
		}
	

	}



	@Override
	public boolean addStockDao(StockDetails stockEntity) {
		entityManager.persist(stockEntity);
		return true;
	}

	

}
