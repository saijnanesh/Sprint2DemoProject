package com.capgemini.main.controller;


import java.time.LocalDate;

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

import com.capgemini.main.Exception.InvalidIdException;
import com.capgemini.main.entites.StockDetails;
import com.capgemini.main.service.StockService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="*")

public class StockController {
	
	
	@Autowired
	StockService stockService;

	@PostMapping("/addStock")
	public ResponseEntity<String> addStock ( @RequestBody StockDetails stockEntity){
		
		System.out.println(stockEntity);
		stockService.addStock(stockEntity);
		
		return new ResponseEntity<String>("Details Entered", HttpStatus.OK);
	}
	
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody StockDetails details ){
		LocalDate date=LocalDate.of(2019, 02, 01);
		String result = null;
		
		StockDetails list = stockService.updateProduct(id,details);
		if(list.getManufactureDate().isBefore(LocalDate.now())) {
			if(list.getManufactureDate().isBefore(list.getExpiryDate())) {
				if(list.getManufactureDate().isAfter(date)) {
				result="dates Updated";
				return new ResponseEntity<String>(result,HttpStatus.OK);
				}
				else {
					
					result="manufacture date is before 2019-02-01";
					return new ResponseEntity<String>(result,HttpStatus.OK);
				}
			}
			else {
				
				result="manufacture Date is before expire date";
				return new ResponseEntity<String>(result,HttpStatus.OK);
			}
		}
		else {
			
			result="manufacture Date is After localDate";
			return new ResponseEntity<String>(result,HttpStatus.OK);
		}

		
	}
	
	
	@GetMapping("/getProductSpecs/{id}")
	public ResponseEntity<StockDetails> searchById(@PathVariable Long id) throws InvalidIdException
	{
		StockDetails list = stockService.getStockSpecs(id);
		if(list==null)
			throw new InvalidIdException(id + " " + " Id is not Valid");
		return new ResponseEntity<StockDetails>(list,HttpStatus.OK);
	}

	
	@GetMapping("/getAllProductSpecs")
    public ResponseEntity<List<StockDetails>> getProductList() {
			List<StockDetails> list = stockService.getAllProducts();
			
			return new ResponseEntity<List<StockDetails>>(list,HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/deleteItem/{id}") 
	public ResponseEntity<String> deleteItem(@PathVariable Long id)
	{
		String result=null;
		Boolean status = stockService.deleteItem(id);
		if(status== true) {
			 result = "Item deleted Successfully";
			 return new ResponseEntity<String>(result, HttpStatus.OK);
		}
		else {
			result = "Unsuccessfull";
			return new ResponseEntity<String>(result, HttpStatus.OK);
		}
	}
	
		

	
	
}
