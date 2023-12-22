package com.lkm.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="departments")
public class Department {
      private String dName;
      
      @Id
      //@GeneratedValue(strategy=GenerationType.AUTO)
      private int dId;
      private int noOfSeatsAvailable;
      private int noOfSeatsBooked;
      
      @NotBlank(message="HOD Name not entered")
      private String dHOD;
      

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Department(String dName, int dId, int noOfSeatsAvailable, int noOfSeatsBooked, String dHOD) {
		super();
		this.dName = dName;
		this.dId = dId;
		this.noOfSeatsAvailable = noOfSeatsAvailable;
		this.noOfSeatsBooked = noOfSeatsBooked;
		this.dHOD = dHOD;
	}
	
	@Override
	public String toString() {
		return "Department [dName=" + dName + ", dId=" + dId + ", noOfSeatsAvailable=" + noOfSeatsAvailable
				+ ", noOfSeatsBooked=" + noOfSeatsBooked + ", dHOD=" + dHOD + "]";
	}
	
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public int getNoOfSeatsAvailable() {
		return noOfSeatsAvailable;
	}
	public void setNoOfSeatsAvailable(int noOfSeatsAvailable) {
		this.noOfSeatsAvailable = noOfSeatsAvailable;
	}
	public int getNoOfSeatsBooked() {
		return noOfSeatsBooked;
	}
	public void setNoOfSeatsBooked(int noOfSeatsBooked) {
		this.noOfSeatsBooked = noOfSeatsBooked;
	}
	public String getdHOD() {
		return dHOD;
	}
	public void setdHOD(String dHOD) {
		this.dHOD = dHOD;
	}
      
}
