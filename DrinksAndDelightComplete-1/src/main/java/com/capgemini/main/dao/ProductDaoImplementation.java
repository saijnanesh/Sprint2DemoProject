package com.capgemini.main.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.main.entites.OrderDetails;
import com.capgemini.main.entites.RawSpecs;



@Transactional
@Repository
public class ProductDaoImplementation implements ProductDaoInterface{

	@PersistenceContext
	EntityManager entityManager;
	
	
	/*
	 * This method is used to add ProductEntity into the orderManagement Table.
	 * Method 	 : addProductOrderEntity
	 * Type 	 : Boolean
	 * parameters: ProductOrderEntity 
	 * Author 	 : Sai Jnanesh
	 * Date 	 : 20/04/2020
	 */
	@Override
	public boolean placeOrder(OrderDetails productEntity)
	{
		//Query get RawSpecs from Database
		String Qstr="SELECT product from RawSpecs product";
		TypedQuery<RawSpecs> query=entityManager.createQuery(Qstr,RawSpecs.class);
		boolean flag = true;
		int length = query.getResultList().size();
		//to view all the details in the result list
		for(int loop=0;loop<length;loop++)
		{
			//To check validation
			if( query.getResultList().get(loop).getName().contentEquals(productEntity.getName())
			&& productEntity.getQuantityUnit() <= query.getResultList().get(loop).getQuantityUnit()
			&& productEntity.getQuantityValue() <= query.getResultList().get(loop).getQuantityValue()
			){
				// to get RmsId of that particular product
				int rmsId = query.getResultList().get(loop).getRmsId();
				
				//to get details of that particular rmsId
				RawSpecs raw = entityManager.find(RawSpecs.class, rmsId);
				
				//BackEnd validation
				double updatedQuantityUnit =raw.getQuantityUnit() - productEntity.getQuantityUnit();
				double updatedQuantityValue = raw.getQuantityValue() - productEntity.getQuantityValue();
				
				//adding into Raw DB
				raw.setQuantityUnit(updatedQuantityUnit);
				raw.setQuantityValue(updatedQuantityValue);
				
				//Total Price
				double priceperUnit = raw.getPricePerUnit();
				productEntity.setPricePerUnit(priceperUnit);
				double price = productEntity.getQuantityUnit() * priceperUnit;
				productEntity.setTotalPrice(price);
		
				
				//adding date of order and delivery Status and location 
				LocalDate dateOfOrder = LocalDate.now();
				LocalDate dateOfDelivery = dateOfOrder.plusDays(14);
				productEntity.setDateOfOrder(dateOfOrder);
				productEntity.setDateOfDelivery(dateOfDelivery);
				String deliveryStatus = "Order being Reviewed ";
				productEntity.setDeliveryStatus(deliveryStatus);
				String location = "Visakhapatnam";
				productEntity.setLocation(location);
				
				entityManager.persist(productEntity);	
				flag=true;
				break;
			}
			else
			{
								flag = false;
			}
		}
		return flag;
	}
	
	/*
	 * This method is used to cancel order from the OrderDetails Table.
	 * Method 	 : cancelOrder
	 * Type 	 : Boolean
	 * parameters: orderId 
	 * Author 	 : Sai Jnanesh
	 * Date 	 : 20/04/2020
	 */

	@Override
	public boolean cancelOrder(int orderId) {
		
		{
			//to get order details of that orderId
			OrderDetails order = entityManager.find(OrderDetails.class, orderId);
			String name = order.getName();
			
			//Query to get the stock details of that particular product
			String Qstr = "SELECT stock from RawSpecs stock WHERE stock.name = :name";
			TypedQuery<RawSpecs> query=entityManager.createQuery(Qstr,RawSpecs.class);
			List<RawSpecs> list = query.setParameter("name", name).getResultList();
			
			//to get rmdId of that particular product 
			int id = list.get(0).getRmsId();
			RawSpecs raw = entityManager.find(RawSpecs.class, id);
			
			//Backend validation
			//list.get(0).getQuantityUnit();
			double updatedQuantityUnit = raw.getQuantityUnit() + order.getQuantityUnit();
			double updatedQuantityValue = raw.getQuantityValue() + order.getQuantityValue();
			raw.setQuantityUnit(updatedQuantityUnit);
			raw.setQuantityValue(updatedQuantityValue);
			entityManager.remove(order);
			return true;
		}
	}

	/*
	 * This method is used to getProductSpecs from the RawSpecs Table.
	 * Method 	 : getProductSpecs
	 * Type 	 : RawSpecs
	 * parameters: rmsId 
	 * Author 	 : Sai Jnanesh
	 * Date 	 : 20/04/2020
	 */
	@Override
	public RawSpecs getProductSpecs(int rmsId) {
		 RawSpecs ref = entityManager.find(RawSpecs.class,rmsId);
		 if(ref!=null)
		 {
			 return ref; 
		 }
		 return null;
		 
	}

	/*
	 * This method is used to findOrderById  from the OrderDetails Table.
	 * Method 	 : findOrderById
	 * Type 	 : OrderDetails
	 * parameters: id 
	 * Author 	 : Sai Jnanesh
	 * Date 	 : 20/04/2020
	 */
	@Override
	public OrderDetails findOrderById(int id) {
		return entityManager.find(OrderDetails.class, id);
	}
	
	
	/*
	 * This method is used to reterive  from the RawSpecs Table.
	 * Method 	 : reterive
	 * Type 	 : List<RawSpecs>
	 * parameters:  
	 * Author 	 : Sai Jnanesh
	 * Date 	 : 20/04/2020
	 */
	@Override
	public List<RawSpecs> reterive() {
		String Qstr="SELECT product from RawSpecs product";
		TypedQuery<RawSpecs> query=entityManager.createQuery(Qstr,RawSpecs.class);
		return query.getResultList();
		}

	
	
	/*
	 * This method is used to reteriveOrderList  from the OrderDetails Table.
	 * Method 	 : reteriveOrderList
	 * Type 	 : List<OrderDetails>
	 * parameters:  
	 * Author 	 : Sai Jnanesh
	 * Date 	 : 20/04/2020
	 */
	@Override
	public List<OrderDetails> reteriveOrderList() {
		String Qstr="SELECT order from OrderDetails order";
		TypedQuery<OrderDetails> query=entityManager.createQuery(Qstr,OrderDetails.class);
		return query.getResultList();
	}
	

	/*
	 * This method is used to updateOrder  from the OrderDetails Table.
	 * Method 	 : updateOrder
	 * Type 	 : boolean
	 * parameters:productEntity
	 * Author 	 : Sai Jnanesh
	 * Date 	 : 20/04/2020
	 */
	@Override
	public boolean updateOrder(OrderDetails productEntity) {
		{
			OrderDetails orderObj = entityManager.find(OrderDetails.class, productEntity.getOrderId());
			String name = orderObj.getName();
			boolean flag =false;
			
			String Qstr = "SELECT stock from RawSpecs stock WHERE stock.name = :name";
			TypedQuery<RawSpecs> query=entityManager.createQuery(Qstr,RawSpecs.class);
			List<RawSpecs> list = query.setParameter("name", name).getResultList();
			
			if(list.get(0).getName().contentEquals(productEntity.getName())
					&& productEntity.getQuantityUnit() <= list.get(0).getQuantityUnit()
					&& productEntity.getQuantityValue() <= list.get(0).getQuantityValue())
			{
			orderObj.setName(productEntity.getName());
			orderObj.setDistributorId(productEntity.getDistributorId());
			orderObj.setQuantityValue(productEntity.getQuantityValue());
			orderObj.setQuantityUnit(productEntity.getQuantityUnit());

			double priceperUnit = list.get(0).getPricePerUnit();
			productEntity.setPricePerUnit(priceperUnit);
			double price = productEntity.getQuantityUnit() * priceperUnit;
			orderObj.setTotalPrice(price);
			
			//adding date or order and delivery
			LocalDate dateOfOrder = LocalDate.now();
			LocalDate dateOfDelivery = dateOfOrder.plusDays(14);
			orderObj.setDateOfOrder(dateOfOrder);
			orderObj.setDateOfDelivery(dateOfDelivery);
			orderObj.setTotalPrice(price);
			String location = "Visakhapatnam";
			orderObj.setLocation(location);
			flag = true;
			}
			else
			{
				flag = false;
			}
			return flag;
			
		}
	}
	
	
	
}
