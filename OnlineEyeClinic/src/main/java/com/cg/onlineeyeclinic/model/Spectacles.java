package com.cg.onlineeyeclinic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Spectacle")
public class Spectacles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
		
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="spectaclesId")
	
		private Integer spectaclesId;
		@Column(name="spectaclesModel")
		@NotNull(message = "Model name should be compulsory")
		@Size(min=5,max=10)
		private String spectaclesModel;
		@Column(name="spectaclesDescription")
		@NotNull(message = "Description should be compulsory")
		@Size(min=5,max=10)
		private String spectaclesDescription;
		@Column(name="spectaclesCost")
		@Min(1000)
		private Double spectaclesCost;
		
		public Spectacles() {
			
		}
		
		public Spectacles(Integer spectaclesId, String spectaclesModel, String spectaclesDescription,
				Double spectaclesCost) {
			super();
			this.spectaclesId = spectaclesId;
			this.spectaclesModel = spectaclesModel;
			this.spectaclesDescription = spectaclesDescription;
			this.spectaclesCost = spectaclesCost;
		}
		public Integer getSpectaclesId() {
			return spectaclesId;
		}
		public void setSpectaclesId(Integer spectaclesId) {
			this.spectaclesId = spectaclesId;
		}
		public String getSpectaclesModel() {
			return spectaclesModel;
		}
		public void setSpectaclesModel(String spectaclesModel) {
			this.spectaclesModel = spectaclesModel;
		}
		public String getSpectaclesDescription() {
			return spectaclesDescription;
		}
		public void setSpectaclesDescription(String spectaclesDescription) {
			this.spectaclesDescription = spectaclesDescription;
		}
		public Double getSpectaclesCost() {
			return spectaclesCost;
		}
		public void setSpectaclesCost(Double spectaclesCost) {
			this.spectaclesCost = spectaclesCost;
		}
		@Override
		public String toString() {
			return "Spectacles [spectaclesId=" + spectaclesId + ", spectaclesModel=" + spectaclesModel
					+ ", spectaclesDescription=" + spectaclesDescription + ", spectaclesCost=" + spectaclesCost + "]";
		}
	

}
