package com.niit.backend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="Student_Details")
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	@Column(name = "Name")
	public String name;
	
	@Column(name = "Email")
	public String email;
	
	@Column(name = "Contact")
	public String phone;
	

	@Column(name = "DoB")
	public String DOB ;
	
	@Column(name = "Course")
	public String course;
	

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Column(name = "Hobby")
	public String hobby;
	
	
	public Student()
	{
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int factId) {
		this.id = factId;
	}
	public String getName() {
		return name;
	}
	public void setName(String fname) {
		this.name = fname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
