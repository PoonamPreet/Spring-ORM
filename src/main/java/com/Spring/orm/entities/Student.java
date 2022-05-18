package com.Spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student_Details")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="std_id")
	private int std_id;
	@Column(name="std_name")
	private String std_name;
	@Column(name="std_address")
	private String std_address;
	public Student(int std_id, String std_name, String std_address) {
		super();
		this.std_id = std_id;
		this.std_name = std_name;
		this.std_address = std_address;
	}
	public Student() {
		super();
	
	}
	public int getStd_id() {
		return std_id;
	}
	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}
	public String getStd_name() {
		return std_name;
	}
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public String getStd_address() {
		return std_address;
	}
	public void setStd_address(String std_address) {
		this.std_address = std_address;
	}	
}
