package com.example.main.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
@Table(name="student")
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GenericGenerator(
			name = "studentsSequenceGenerator",
			strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name ="sequence_name", value = "studentSequence"),
					@Parameter(name="initial_value", value ="1"),
					@Parameter(name="increment_size",value="1")
			}
	)
	
	
	@Id
	@GeneratedValue(generator = "studentsSequenceGenerator")
	@Column(name="id")
	private long id;
	
	@Column(name="fname")
	private String fname;

	@Column(name="lname")
	private String lname;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
}
