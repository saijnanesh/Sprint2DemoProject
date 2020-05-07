package com.capgemini.main.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.main.dao.ProductDaoInterface;
import com.capgemini.main.entites.OrderDetails;
import com.capgemini.main.entites.RawSpecs;


@Service
@Transactional
public class ProductServiceImplementation implements ProductServiceInterface{

	@Autowired
	ProductDaoInterface daoObj;
	
	List<String> rmsList = new ArrayList<String>();
	
	
	
	/*
	 * This method is used to add ProductEntity into the orderManagement Table.
	 * Method 	 : addProductOrderEntity
	 * Type 	 : Boolean
	 * parameters: ProductOrderEntity 
	 * Author 	 : Sai Jnanesh
	 * Date 	 : 20/04/2020
	 */
	@Override
	public boolean orderProduct(OrderDetails productEntity) {
		return daoObj.placeOrder(productEntity);
		
		
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
	public boolean cancelProduct(int orderId) {
		return daoObj.cancelOrder(orderId);
		
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
			return daoObj.getProductSpecs(rmsId);
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
		return daoObj.findOrderById(id);
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
	public List<RawSpecs> retrieve() {
		return daoObj.reterive();
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
	public List<OrderDetails> retrieveOrderList() {
		return daoObj.reteriveOrderList();
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
	public boolean updateProduct(OrderDetails productEntity) {
		return daoObj.updateOrder(productEntity);
	}




	
	
	

}
