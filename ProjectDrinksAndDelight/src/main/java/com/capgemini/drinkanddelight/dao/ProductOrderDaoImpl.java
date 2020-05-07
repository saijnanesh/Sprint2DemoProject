package com.capgemini.drinkanddelight.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.drinkanddelight.entity.Distributor;
import com.capgemini.drinkanddelight.entity.ProductOrder;


@Repository
@Transactional
public class ProductOrderDaoImpl implements ProductOrderDaoI{
	
	@PersistenceContext
	EntityManager entityManager;
	
	/*
	 * This method is used to add ProductEntity into the orderManagement Table.
	 * Method 	 : addProductOrderEntity
	 * Type 	 : Void
	 * parameters: ProductOrderEntity 
	 * Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	@Override
	public void addProductOrderEntity(ProductOrder productorderentity) {
		entityManager.persist(productorderentity);
	}
	
	/*
	 * This method is used to add ProductEntity into the orderManagement Table.
	 * Method 	 : getListOfProductOrderEntity()
	 * Type 	 : ProductOrderEntity
	 * parameters: -
	* Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	public List<ProductOrder> getListOfProductOrderEntity(){
		String Qstr="SELECT productorderentity from ProductOrder productorderentity";
		TypedQuery<ProductOrder> query=entityManager.createQuery(Qstr,ProductOrder.class);
		return query.getResultList();
	}
	
	public List<Distributor> getDistributors(){
		String Qstr="SELECT distributorentity from Distributor distributorentity";
		TypedQuery<Distributor> query=entityManager.createQuery(Qstr,Distributor.class);
		return query.getResultList();
	}
	
	

	/*
	 * This method is used to find the entity by the OrderId from the orderManagement Table.
	 * Method 	 : findByOrderId
	 * Type 	 : ProductOrderEntity(Class)
	 * parameters: OrderId
	 * Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	
	@Override
	public ProductOrder findByOrderId(String orderId) {		
		return entityManager.find(ProductOrder.class, orderId);
	}

	/*
	 * This method is used to delete the entity from the OrderManagement table.
	 * Method 	 : deleteProductOrderEntity
	 * Type 	 : Void
	 * parameters: ProductOrderEntity 
	 * Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	@Override
	public Boolean deleteProductOrderEntity(String orderId) {
		
		ProductOrder obj =entityManager.find(ProductOrder.class, orderId);
		if(obj !=null)
		{
			entityManager.remove(obj);
			return true;
		}
		else 
		return false;
	}
	
	/*
	 * This method is used to find the list of orders by one distributor by entering the supplierId and DeliveryStatus.
	 * Method 	 : deleteProductOrderEntity
	 * Type 	 : Void
	 * parameters: ProductOrderEntity 
	* Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	
	public List<ProductOrder> displayProductOrder(String distibutorId)
	{
		TypedQuery<ProductOrder> query = entityManager.createQuery( "SELECT p.deliveryStatus FROM ProductOrderEntity p WHERE p.distributorId =?1", ProductOrder.class);
		System.out.println("qwertyu");
		//query.setParameter("distributorId",distibutorId).getResultList();
		return query.setParameter(1, distibutorId).getResultList();
	}
	
	/*
	 * Hard Coding to find the delivery status by using the distributor Id
	 * Method 	 : displayOrder
	 * Type 	 : List<String> 
	 * parameters: id 
	* Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	public List<String> displayOrder(String id)
	{
		String Qstr="SELECT productorderentity from ProductOrder productorderentity";
		TypedQuery<ProductOrder> query=entityManager.createQuery(Qstr,ProductOrder.class);
		List<ProductOrder>result = query.getResultList();
		
		List<String> res = new ArrayList<String>();
		
		
		Iterator<ProductOrder> itr =result.iterator();
		 while(itr.hasNext()) 
		 {
	         ProductOrder element = itr.next();
	         if(element.getDistributorId().contentEquals(id))
	         {
	        	System.out.println("DistributorId ="+id+" " +"deliveryStatus="+element.getDeliveryStatus());
	        	res.add(element.getDistributorId()+" " + element.getOrderId()+" "+element.getDateOfOrder()+" "+element.getDateOfDelivery()+" "+element.getDeliveryStatus());
	        	//return element.getDeliveryStatus();
	         }
	      } 
		return res;	
	}
	
	/* Json Format
	 * This method is used to give the list of deliveryStatus and OrderId by using the distributorId
	 * Method 	 : displayOrder1
	 * Type 	 : List<ProductOrderEntity> 
	 * parameters: id 
	* Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	public List<ProductOrder> displayOrder1(String id)
	{
		String Qstr="SELECT productorderentity from ProductOrder productorderentity";
		TypedQuery<ProductOrder> query=entityManager.createQuery(Qstr,ProductOrder.class);
		List<ProductOrder>result = query.getResultList();

		List<ProductOrder> res = new ArrayList<ProductOrder>();
		
		Distributor de =  entityManager.find(Distributor.class, id);
		if(de != null) 
		{
			Iterator<ProductOrder> itr =result.iterator();
			while(itr.hasNext()) 
				{
				ProductOrder element = itr.next();
				if(element.getDistributorId().contentEquals(id))
					{
						//System.out.println("DistributorId ="+id+" " +"deliveryStatus="+element.getDeliveryStatus());
						res.add(element);
						//return element.getDeliveryStatus();
					}
				}
		}
		else
		{
			return null;
		}
		return res;	
	}
	
	
	
	/* Json Format
	 * This method is used to give the list of Product orders by using the distributorId and Status
	 * Method 	 : displayIdwithStatus
	 * Type 	 : List<ProductOrderEntity>
	 * parameters: distribuotrId,status 
	 * Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	@Override
	public List<ProductOrder>  displayIdwithStatus(String id, String status) {
		
		String delivStatus = status.toUpperCase();
		String Qstr="SELECT productorderentity from ProductOrder productorderentity";
		TypedQuery<ProductOrder> query=entityManager.createQuery(Qstr,ProductOrder.class);
		List<ProductOrder>result = query.getResultList();

		List<ProductOrder> res = new ArrayList<ProductOrder>();
		
		Distributor de =  entityManager.find(Distributor.class, id);
		if(de != null) 
		{
			Iterator<ProductOrder> itr =result.iterator();
			while(itr.hasNext()) 
				{
				ProductOrder element = itr.next();
				if(element.getDistributorId().contentEquals(id) && element.getDeliveryStatus().contentEquals(delivStatus))
					{
						//System.out.println("DistributorId ="+id+" " +"deliveryStatus="+element.getDeliveryStatus());
						res.add(element);
						//return element.getDeliveryStatus();
					}
				}
		}
		else
		{
			return null;
		}
		return res;	
	}
	
	/*
	 * This method is used to find the Distributor by the DistributorId from the orderManagement Table.
	 * Method 	 : findByOrderId
	 * Type 	 : ProductOrderEntity(Class)
	 * parameters: OrderId
	 * Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	
	@Override
	public Distributor getDistributorDetails(String distributorId) {
		Distributor distributor= entityManager.find(Distributor.class, distributorId);
		if(distributor != null)
			return distributor;
		else
			return null;
	}
}
