package com.example.server.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name ="doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name =  "name")
	private String name;
	@Column(name =  "age")
	private int age;
	@Column(name =  "gender")
	private String gender;
	@Column(name =  "specialization")
	private String specialization;
	@Column(name="count")
	private long count=0;
	
	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count +=1;
	}

	public Doctor() {
	}
	
	public Doctor(String name, int age, String gender, String specialization) {
		super();
		this.name = name;
		this.age = age;
		this.gender= gender;
		this.specialization = specialization;
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
}
