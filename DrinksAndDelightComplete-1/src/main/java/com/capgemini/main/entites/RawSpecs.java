package com.capgemini.main.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity	
@Table(name = "Raw_Specs")
public class RawSpecs {

		@Id
		private int rmsId;
		private String name;
		private double pricePerUnit;
		private String description;
		private double quantityValue;
		private double quantityUnit;
	
		public  RawSpecs() {
			
		}
		
		

		
		
		public RawSpecs(int rmsId, String name, double pricePerUnit, String description, double quantityValue,
				double quantityUnit) {
			super();
			this.rmsId = rmsId;
			this.name = name;
			this.pricePerUnit = pricePerUnit;
			this.description = description;
			this.quantityValue = quantityValue;
			this.quantityUnit = quantityUnit;
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



		public int getRmsId() {
			return rmsId;
		}



		public void setRmsId(int rmsId) {
			this.rmsId = rmsId;
		}



		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getPricePerUnit() {
			return pricePerUnit;
		}
		public void setPricePerUnit(double pricePerUnit) {
			this.pricePerUnit = pricePerUnit;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		
		
		
		
		
		
	}
