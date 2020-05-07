package com.capgemini.main.entites;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Value;

@Entity
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	@SequenceGenerator(sequenceName = "order_seq", allocationSize = 1, name = "order_seq")
	private int orderId;
	private String name;
	private String distributorId;
	private double quantityValue;
	private double quantityUnit;
	private double pricePerUnit;
	private LocalDate dateOfOrder;
	private LocalDate dateOfDelivery;
	private String deliveryStatus;
	private double totalPrice;
	private String location;
	
	public OrderDetails()
	{
		
	}
	

		public OrderDetails(int orderId, String name, String distributorId, double quantityValue, double quantityUnit,
			double pricePerUnit, LocalDate dateOfOrder, LocalDate dateOfDelivery, double totalPrice, String location,
			String deliveryStatus) {
		super();
		this.orderId = orderId;
		this.name = name;
		this.distributorId = distributorId;
		this.quantityValue = quantityValue;
		this.quantityUnit = quantityUnit;
		this.pricePerUnit = pricePerUnit;
		this.dateOfOrder = dateOfOrder;
		this.dateOfDelivery = dateOfDelivery;
		this.totalPrice = totalPrice;
		this.location = location;
		this.deliveryStatus = deliveryStatus;
	}


		public String getDeliveryStatus() {
			return deliveryStatus;
		}


		public void setDeliveryStatus(String deliveryStatus) {
			this.deliveryStatus = deliveryStatus;
		}


		public LocalDate getDateOfOrder() {
			return dateOfOrder;
		}


		public void setDateOfOrder(LocalDate dateOfOrder) {
			this.dateOfOrder = dateOfOrder;
		}


		public LocalDate getDateOfDelivery() {
			return dateOfDelivery;
		}


		public void setDateOfDelivery(LocalDate dateOfDelivery) {
			this.dateOfDelivery = dateOfDelivery;
		}


		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}

	public double getQuantityValue() {
		return quantityValue;
	}

	public void setQuantityValue(double quantityValue) {
		this.quantityValue = quantityValue;
	}

	public double getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(double quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice ;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
