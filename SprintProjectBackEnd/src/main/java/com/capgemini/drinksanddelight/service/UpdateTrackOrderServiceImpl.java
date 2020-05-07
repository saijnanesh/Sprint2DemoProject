package com.capgemini.drinksanddelight.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drinksanddelight.dao.DrinksAndDelightDao;
import com.capgemini.drinksanddelight.exception.OrderIdNotFoundException;
import com.capgemini.drinksanddelight.util.ExceptionConstants;
@Service
@Transactional
public class UpdateTrackOrderServiceImpl implements UpdateTrackOrderService {
	
	
	@Autowired
	DrinksAndDelightDao daoObj;
	

	@Override
	public boolean updateTrackOrder(String orderId, String Location, LocalDate date,String status) throws OrderIdNotFoundException {
		// TODO Auto-generated method stub
		boolean check= daoObj.updateTrackOrder(orderId, Location, date,status);
		
		if(check==false)
			throw new  OrderIdNotFoundException(ExceptionConstants .ID_NOT_EXIST);
		return check;
		
		
		
	}

}
