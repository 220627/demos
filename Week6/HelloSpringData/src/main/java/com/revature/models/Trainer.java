package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity //makes the class a DB table
@Table(name = "trainers") //names our DB table "trainers"
@Component //makes the class a Bean
public class Trainer {

	@Id //tells Spring Data that this field is meant to be the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //makes our PK serial 
	private int trainerId;
	
	//we don't actually need @Column unless we're adding some constraint
	
	@Column(unique = true)
	private String username;
	
	//we don't need @Column here if we don't want to add constraints!
	private String password;
	
	//boilerplate code--------------------------------------------------
	
	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trainer(int trainerId, String username, String password) {
		super();
		this.trainerId = trainerId;
		this.username = username;
		this.password = password;
	}

	public Trainer(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", username=" + username + ", password=" + password + "]";
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
