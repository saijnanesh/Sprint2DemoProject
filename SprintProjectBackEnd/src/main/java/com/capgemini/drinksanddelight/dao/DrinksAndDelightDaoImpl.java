package com.capgemini.drinksanddelight.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import org.springframework.stereotype.Repository;

import com.capgemini.drinksanddelight.entities.Distributordetails;
import com.capgemini.drinksanddelight.entities.ProductorderDetails;



@Repository
public class DrinksAndDelightDaoImpl implements DrinksAndDelightDao{
	
	
	
	@PersistenceContext
	EntityManager entityManager;
	

	@Override
	public List<Distributordetails> reterive() {
		// TODO Auto-generated method stub
		String Qstr="SELECT distributordetails from Distributordetails distributordetails";
		TypedQuery<Distributordetails> query=entityManager.createQuery(Qstr,Distributordetails.class);
		return query.getResultList();
	}

	@Override
	public boolean updateTrackOrder(String orderId, String Location, LocalDate date,String status) {
		
		String stql="UPDATE ProductorderDetails p SET p.location=:ploc,p.expectedDeliveryDate=:pdate,p.deliveryStatus=:pstatus where p.orderId=:pid";
		
		 Query query = entityManager.createQuery(stql);
		 query.setParameter("pid", orderId);
		 query.setParameter("ploc", Location);
		 query.setParameter("pdate", date);
		 query.setParameter("pstatus",status );
		 int rows=query.executeUpdate();
		 
		// TODO Auto-generated method stub
		 if(rows==1)
		 {
			 return true;
		 }
		 else
		 {
		return false;
		 }
	}

	@Override
	public ProductorderDetails trackOrder(String id) {
		// TODO Auto-generated method stub
		ProductorderDetails productDetails=entityManager.find( ProductorderDetails.class,id);
		
		if(productDetails==null)
		{
			return null;
		}
		else
		{
		String jpql="select productdetails from ProductorderDetails productdetails where orderId=:oid";
		TypedQuery< ProductorderDetails> query =  entityManager.createQuery(jpql,  ProductorderDetails.class);
		query.setParameter("oid", id);
		return query.getSingleResult();
		}
	}

	@Override
	public boolean addDistributorDetails( String id,String name,String address, String phn) {
		// TODO Auto-generated method stub
		Distributordetails distributorDetails=new Distributordetails();
		distributorDetails.setDistributor_Id(id);
		distributorDetails.setDistributor_Name(name);
		distributorDetails.setDistributor_Address(address);
		distributorDetails.setDistributor_Phn(phn);
		entityManager.persist(distributorDetails);
	
		
	
		
		return true;
	}

}
