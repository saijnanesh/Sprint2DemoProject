package com.capgemini.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.main.entites.OrderDetails;
import com.capgemini.main.entites.RawSpecs;
import com.capgemini.main.exception.InvalidProductException;
import com.capgemini.main.service.ProductServiceInterface;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class productController {
	
	
	@Autowired
	ProductServiceInterface serviceObj;

	
	//To place an order
	@PostMapping("/placeorder")
	public ResponseEntity<String> addProductOrderEntity( @RequestBody OrderDetails productEntity)
	{
		String result = null;
		Boolean status =serviceObj.orderProduct(productEntity);
		if(status)
		{	
			result = "Order Placed";
			return new ResponseEntity<String>(result,HttpStatus.OK);
		}
		else
		{
			result = "Unsuccessfull";
			return new ResponseEntity<String>(result,HttpStatus.BAD_REQUEST);
			
		}
		

	}
	
	//to cancel an order
	@DeleteMapping("/cancelOrder/{id}") 
	public ResponseEntity<String> deleteOrder(@PathVariable int id)
	{
		String result=null;
		Boolean status = serviceObj.cancelProduct(id);
		if(status) {
			 result = "Order Cancelled Successfully";
		return new ResponseEntity<String>(result, HttpStatus.OK);

	}
		else {
			result = "Unsuccessfull";
		return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
	}
		}
	
	
	
	//to get order by id
	@GetMapping("/getProductbyId/{id}")
	public ResponseEntity<OrderDetails> getProductbyId(@PathVariable int id) 
	{
		OrderDetails list = serviceObj.findOrderById(id);
		return new ResponseEntity<OrderDetails>(list,HttpStatus.OK);
	}
	
	
	
	//to get specs by id
	@GetMapping("/getProductSpecs/{id}")
	public ResponseEntity<RawSpecs> getProductSpecsById(@PathVariable int id)  throws InvalidProductException
	{
	
		RawSpecs list = serviceObj.getProductSpecs(id);
		if(list==null)
			throw new InvalidProductException(id + " " + " Id is not Valid");
		return new ResponseEntity<RawSpecs>(list,HttpStatus.OK);
		}
	
	
	
	//to get all specs
	@GetMapping("/getAllProductSpecs")
    public ResponseEntity<List<RawSpecs>> getStockList() {
			List<RawSpecs> list = serviceObj.retrieve();
			return new ResponseEntity<List<RawSpecs>>(list,HttpStatus.OK);
	}
	
	
	// to get all orders
	@GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderDetails>> getProductOrderList() {
			List<OrderDetails> list = serviceObj.retrieveOrderList();
			return new ResponseEntity<List<OrderDetails>>(list,HttpStatus.OK);
	}
	
	//to update an order
	@PutMapping("/updateorder")
	public ResponseEntity<Object> updateorder( @RequestBody OrderDetails productEntity)
	{
		boolean status = serviceObj.updateProduct(productEntity);
		if(productEntity!=null)
		{
			if(status )
			{
				return new ResponseEntity<>("Product Updated Successfully",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>("Either Specified product doesnot belongs to you or some problem encountered  while updating",HttpStatus.NOT_FOUND);
			}
		}
		else
		{
			return new ResponseEntity<>("Provide Valid Entity",HttpStatus.BAD_REQUEST);
		}
	}
	
}
