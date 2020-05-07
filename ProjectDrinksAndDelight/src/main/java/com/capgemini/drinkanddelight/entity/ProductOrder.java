package com.capgemini.drinkanddelight.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class ProductOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Size(min=2,max=10,message="OrderId should be atleast 2 digits")
	private String orderId;
	private String name;
	
	@Size(min=2,max=10,message="distributorId should be atleast 2 digits")
	private String distributorId;
	private double quantityValue;
	private double quantityUnit;
	private Date dateOfOrder;
	private Date dateOfDelivery;
	private double price_per_unit;
	private double totalPrice;
	private String deliveryStatus;
	private String warehouseId;
	
	/*
	 * No args constructor for ProductEntity
	 * All Args constructor for ProductEntity
	 * 
	 * 
	 * 
	 */
	public ProductOrder() {}
	public ProductOrder(String orderId, String name, String distributorId, double quantityValue, double quantityUnit,
			Date dateOfOrder, Date dateOfDelivery, double price_per_unit, double totalPrice, String deliveryStatus,
			String warehouseId) {
		this.orderId = orderId;
		this.name = name;
		this.distributorId = distributorId;
		this.quantityValue = quantityValue;
		this.quantityUnit = quantityUnit;
		this.dateOfOrder = dateOfOrder;
		this.dateOfDelivery = dateOfDelivery;
		this.price_per_unit = price_per_unit;
		this.totalPrice = totalPrice;
		this.deliveryStatus = deliveryStatus;
		this.warehouseId = warehouseId;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	public Date getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public Date getDateOfDelivery() {
		return dateOfDelivery;
	}
	public void setDateOfDelivery(Date dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}
	public double getPrice_per_unit() {
		return price_per_unit;
	}
	public void setPrice_per_unit(double price_per_unit) {
		this.price_per_unit = price_per_unit;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	
	@Override
	public String toString() {
		return "ProductOrderEntity [orderId=" + orderId + ", name=" + name + ", distributorId=" + distributorId
				+ ", quantityValue=" + quantityValue + ", quantityUnit=" + quantityUnit + ", dateOfOrder=" + dateOfOrder
				+ ", dateOfDelivery=" + dateOfDelivery + ", price_per_unit=" + price_per_unit + ", totalPrice="
				+ totalPrice + ", deliveryStatus=" + deliveryStatus + ", warehouseId=" + warehouseId + "]";
	}
	

}
