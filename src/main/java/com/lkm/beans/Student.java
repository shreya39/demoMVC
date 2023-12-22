package com.lkm.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Table(name="students")
public class Student {

	@Column(name="sName")
	@NotBlank(message="Student Name is mandatory")
	private String sName;
	 
	@Id 
	private int sId;
	 
     @NotEmpty
     @Size(min=2, max=3)
	 private String sDept;
	 
	 @NotBlank(message="It is necessary to provide address")
	 private String address;
	 
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String sName, int sId, String sDept, String address) {
		super();
		this.sName = sName;
		this.sId = sId;
		this.sDept = sDept;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [sName=" + sName + ", sId=" + sId + ", sDept=" + sDept + ", address=" + address + "]";
	}
	
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsDept() {
		return sDept;
	}
	public void setsDept(String sDept) {
		this.sDept = sDept;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	 
	 
}
