package com.capgemini.main.entites;

import java.time.LocalDate;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
	
@Table(name = "Details_Stock")

@DynamicInsert
@DynamicUpdate
public class StockDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_seq")
	@SequenceGenerator(sequenceName = "stock_seq", allocationSize = 1, name = "stock_seq")


  
	private Long stockId;
	private String name;
	private String supplierId;
	

	private double quantityValue;
	private double quantityUnit;
	private double pricePerUnit;
	private String warehouseId;
	private LocalDate manufactureDate;
	private LocalDate expiryDate;
	private String qualityCheck;
	
	


	public StockDetails() {
		
	}


	public StockDetails(Long stockId, String name, String supplierId, double quantityValue, double quantityUnit,
			double pricePerUnit, String warehouseId, LocalDate manufactureDate, LocalDate expiryDate,
			String qualityCheck) {
		super();
		this.stockId = stockId;
		this.name = name;
		this.supplierId = supplierId;
		this.quantityValue = quantityValue;
		this.quantityUnit = quantityUnit;
		this.pricePerUnit = pricePerUnit;
		this.warehouseId = warehouseId;
		this.manufactureDate = manufactureDate;
		this.expiryDate = expiryDate;
		this.qualityCheck = qualityCheck;
	}


	public Long getStockId() {
		return stockId;
	}


	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
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


	public String getWarehouseId() {
		return warehouseId;
	}


	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}


	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	@JsonFormat(pattern="yyyy-MM-dd")
	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	
	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	@JsonFormat(pattern="yyyy-MM-dd")
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}


	public String getQualityCheck() {
		return qualityCheck;
	}


	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}



	@Override
	public String toString() {
		return "StockDetails [stockId=" + stockId + ", name=" + name + ", supplierId=" + supplierId + ", quantityValue="
				+ quantityValue + ", quantityUnit=" + quantityUnit + ", pricePerUnit=" + pricePerUnit + ", warehouseId="
				+ warehouseId + ", manufactureDate=" + manufactureDate + ", expiryDate=" + expiryDate
				+ ", qualityCheck=" + qualityCheck + "]";
	}
	
	
	
}
