package com.capgemini.drinkanddelight.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drinkanddelight.dao.ProductOrderDaoI;
import com.capgemini.drinkanddelight.entity.Distributor;
import com.capgemini.drinkanddelight.entity.ProductOrder;

@Service
@Transactional
public class ProductOrderEntityServiceImpl implements ProductOrderEntityServiceInterface {

	@Autowired 
	private ProductOrderDaoI productorderdaoi;


	/*
	 * This method is used to add ProductEntity into the orderManagement Table.
	 * Method 	 : addProductOrderEntity
	 * Type 	 : Void
	 * parameters: ProductOrderEntity 
	 * Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	@Override
	public ProductOrder addProductOrderEntity(ProductOrder productorderentity) {
		productorderdaoi.addProductOrderEntity(productorderentity);
		return productorderentity;
		
	}

	/*
	 * This method is used to add ProductEntity into the orderManagement Table.
	 * Method 	 : getListOfProductOrderEntity()
	 * Type 	 : ProductOrderEntity
	 * parameters: -
	 * Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	@Override
	public List<ProductOrder> getListOfProductOrderEntity() {
		System.out.println("qwertyu");
		return productorderdaoi.getListOfProductOrderEntity();
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
		return productorderdaoi.findByOrderId(orderId);
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
			
		return  productorderdaoi.deleteProductOrderEntity(orderId);
		
	}
	/*
	 * This method is used to find the list of orders by one distributor by entering the supplierId and DeliveryStatus.
	 * Method 	 : deleteProductOrderEntity
	 * Type 	 : Void
	 * parameters: ProductOrderEntity 
	 * Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	@Override
	public List<ProductOrder> displayProductOrder (String distibutorId)
	{
		return productorderdaoi.displayProductOrder(distibutorId);
	}

	/*
	 * Hard Coding to find the delivery status by using the distributor Id
	 * Method 	 : displayOrder
	 * Type 	 : List<String> 
	 * parameters: id 
	 * Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	@Override
	public List<String> displayOrder(String id) {
		return productorderdaoi.displayOrder(id);
	}

	/* Json Format
	 * This method is used to give the list of deliveryStatus and OrderId by using the distributorId
	 * Method 	 : displayOrder1
	 * Type 	 : List<ProductOrderEntity> 
	 * parameters: id 
	 * Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	@Override
	public List<ProductOrder> displayOrder1(String id) {
		
		return productorderdaoi.displayOrder1(id);
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
	public List<ProductOrder> displayIdwithStatus(String distribuotrId, String status) {
		return productorderdaoi.displayIdwithStatus(distribuotrId, status);
	}

	
	
	@Override
	public Distributor getDistributorDetails(String distributorId) {
		return productorderdaoi.getDistributorDetails(distributorId);
	}

	@Override
	public List<Distributor> getDistributors() {
		// TODO Auto-generated method stub
		return productorderdaoi.getDistributors();

	}
	
	
	
}

