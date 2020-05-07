package com.capgemini.drinksanddelight.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.drinksanddelight.entities.Distributordetails;
import com.capgemini.drinksanddelight.entities.ProductorderDetails;
import com.capgemini.drinksanddelight.exception.OrderIdNotFoundException;
import com.capgemini.drinksanddelight.service.DistributorDetailsService;
import com.capgemini.drinksanddelight.service.TrackOrderService;
import com.capgemini.drinksanddelight.service.UpdateTrackOrderService;
import com.capgemini.drinksanddelight.util.ExceptionConstants;





@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/")
public class DrinksAndDelightController {
	
	@Autowired
	DistributorDetailsService serviceObj;
	
	@Autowired
	TrackOrderService trackObj;
	
	
	@Autowired
	UpdateTrackOrderService updateObj;
	
	
	
	
	
	@GetMapping("/DistributorDetails")
    public ResponseEntity<List<Distributordetails>> getDistributorDetails() {
			List<Distributordetails> distributorDetailsList = serviceObj.reterive();
			return new ResponseEntity<List<Distributordetails>>(distributorDetailsList,HttpStatus.OK);
	}
	
	
	@PostMapping("/AddDistributorDetails/{distributorId}/{distributorName}/{distributorAddress}/{distributorPhn}")
	
	
	public ResponseEntity<String> addDistributorDetails(@PathVariable("distributorId") String id,@PathVariable("distributorName")String name,@PathVariable("distributorAddress") String address,@PathVariable("distributorPhn") String phn)
	{
		
		
		
		serviceObj.addDistributorDetails(id,name,address,phn);
		
		return new ResponseEntity<String>("Distributor Details Added",HttpStatus.OK);
		
		
		
	}
	
	
	
	@GetMapping("/trackOrder/{id}")
    public ResponseEntity<ProductorderDetails> trackOrder(@PathVariable("id") String id) throws OrderIdNotFoundException {
			ProductorderDetails productDetails= trackObj.trackOrder(id);
			
			if(productDetails==null)
			{
				throw new OrderIdNotFoundException(ExceptionConstants.ID_NOT_EXIST);
			}
			else
			{
			return new ResponseEntity<ProductorderDetails>(productDetails,HttpStatus.OK);
			}
	}
	
	
	
	@PutMapping("/update/{orderId}/{location}/{date}/{status}")
	
	public  boolean updateTrackOrder(@PathVariable("orderId") String id,@PathVariable("location")String location,@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable("status") String status) throws OrderIdNotFoundException
	{
		
		
		boolean check= updateObj.updateTrackOrder(id, location, date, status);
		
		if(check==false)
		{
			throw new OrderIdNotFoundException(ExceptionConstants.ID_NOT_EXIST);
			
		}
		else
		{
			return check;
		}
		
		
		
	}
	 
	
	
	

}
