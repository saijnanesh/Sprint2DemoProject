package com.capgemini.drinkanddelight.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.drinkanddelight.entity.Distributor;
import com.capgemini.drinkanddelight.entity.ProductOrder;
import com.capgemini.drinkanddelight.exception.DistributorNotFoundException;
import com.capgemini.drinkanddelight.exception.ProductOrderEntityNotFoundException;
import com.capgemini.drinkanddelight.service.ProductOrderEntityServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private ProductOrderEntityServiceInterface productorderentityserviceinterface;
	
	/*
	 * This is a PostMethod(Http) is used to add the entity in the database.
	 * Method 	 : addProductOrderEntity
	 * Type 	 : ResponseEntity<String>
	 * parameters: ProductOrderEntity(Class)
	 * Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	@PostMapping("/addProductOrderEntity")
	public ResponseEntity<String> addProductOrderEntity(@Valid @RequestBody ProductOrder productorderentity)
	{
		productorderentityserviceinterface.addProductOrderEntity(productorderentity);
		return new ResponseEntity<String>("productorderentity Added",HttpStatus.OK);
	}
	
	/*
	 * This is a GetMethod(Http) is used to get list of entities from the database.
	 * Method 	 : getListOfProductOrderEntity
	 * Type 	 : ResponseEntity
	 * parameters: -
	 * Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	@GetMapping("/getListOfProductOrderEntity")
    public ResponseEntity<List<ProductOrder>> getListOfProductOrderEntity() throws ProductOrderEntityNotFoundException
	{
			List<ProductOrder> list = productorderentityserviceinterface.getListOfProductOrderEntity();
			if(list == null)
				throw new ProductOrderEntityNotFoundException("Sry we not found any data in database");
			return new ResponseEntity<List<ProductOrder>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/getDistributors")
    public ResponseEntity<List<Distributor>> getDistributors() throws ProductOrderEntityNotFoundException
	{
			List<Distributor> list1 = productorderentityserviceinterface.getDistributors();
			if(list1 == null)
				throw new ProductOrderEntityNotFoundException("Sry we not found any data in database");
			return new ResponseEntity<List<Distributor>>(list1,HttpStatus.OK);
	}
	
	
	/*
	 * This is a DeleteMethod(Http) by "OrderId" is used to delete the entity from the database.
	 * Method 	 : deleteProductOrderEntity
	 * Type 	 : ResponseEntity
	 * parameters: orderId
	 * Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	@GetMapping("/deleteProductOrderEntity/{orderId}")
	public ResponseEntity<String> deleteProductOrderEntity(  @PathVariable("orderId") String orderId)  
	{
		String result=null;
		Boolean status = productorderentityserviceinterface.deleteProductOrderEntity(orderId);
		if(status== true)
			 result = "Order deleted Successfully";
		else
			result = "Unsuccess";
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	/*
	 * This is a GetMethod(Http) by "OrderId" is used to get the entity from the database.
	 * Method 	 : getProductbyId
	 * Type 	 : ResponseEntity
	 * parameters: orderId
	 * Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */	
	@GetMapping("/getProductbyId/{orderId}")
	public ResponseEntity<ProductOrder> getProductbyId( @PathVariable String orderId) throws ProductOrderEntityNotFoundException 
	{
		ProductOrder list = productorderentityserviceinterface.findByOrderId(orderId);
		if(list == null)
			throw new ProductOrderEntityNotFoundException(orderId+""+"Not Found in database");
		return new ResponseEntity<ProductOrder>(list,HttpStatus.OK);
	}
	
	/* Hard-Code
	 * This is a GetMethod(Http) by using "distributorId" is used to fetch the delivery status of particular distributorId.
	 * Method 	 : display
	 * Type 	 : ResponseEntity<List<String>>
	 * parameters: id 
	* Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */	
	@GetMapping("/display/{distributorId}")
	 public ResponseEntity<List<String>> display( @PathVariable String id)
	{
		List<String> list = productorderentityserviceinterface.displayOrder(id);
		return new ResponseEntity<List<String>>(list,HttpStatus.OK);
	}

	/* Json Format
	 * This is a GetMethod(Http) by using "distributorId" is used to fetch the delivery status of particular distributorId.
	 * Method 	 : display1
	 * Type 	 : ResponseEntity<List<ProductOrderEntity>>
	 * parameters: id 
	 * Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	
	@GetMapping("/displayDistributor/{distributorId}")
	public ResponseEntity<List<ProductOrder>> displayDistributor( @PathVariable String distributorId) throws DistributorNotFoundException 
	{
		List<ProductOrder> list = productorderentityserviceinterface.displayOrder1(distributorId);
		if(list == null)
			throw new DistributorNotFoundException(distributorId+" "+"distributorId Not Found In distributor Table");
		return new ResponseEntity<List<ProductOrder>>(list,HttpStatus.OK);
	}
	
	/* Json Format
	 * This is a GetMethod(Http) by using "distributorId" AND "deliveryStatus" it is used to fetch the product Entity.
	 * Method 	 : displayIdwithStatus
	 * Type 	 : ResponseEntity<List<ProductOrderEntity>>
	 * parameters: distribuotrId,status 
	 * Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	
	@GetMapping("/displayDistributor/{distributorId}/{status}")
	public ResponseEntity<List<ProductOrder>> displayIdwithStatus( @PathVariable String distributorId , @PathVariable String status) throws DistributorNotFoundException 
	{
		List<ProductOrder> list = productorderentityserviceinterface.displayIdwithStatus(distributorId, status);
		if(list==null)
			throw new DistributorNotFoundException(" Details Not Found in Database ");
		return new ResponseEntity<List<ProductOrder>>(list,HttpStatus.OK);
	}
	
	/* Json Format
	 * This is a GetMethod(Http) by using "distributorId" it is used to fetch the details of the particular DistributorId.
	 * Method 	 : displayIdwithStatus
	 * Type 	 : ResponseEntity<Distributor>
	 * parameters: distribuotrId
	 * Author 	 : Vemunuri Sai Kiran
	 * Date 	 : 26/04/2020
	 */
	
	@GetMapping("/getDistributorDetails/{distributorId}")
	public ResponseEntity<Distributor> getDistributorDetails( @PathVariable String distributorId) throws DistributorNotFoundException
	{
	Distributor list = productorderentityserviceinterface.getDistributorDetails(distributorId);
		if(list==null)
			throw new DistributorNotFoundException(" Details Not Found in Database ");
		return new ResponseEntity<Distributor>(list,HttpStatus.OK);
	}
}

