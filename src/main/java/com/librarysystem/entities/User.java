package com.librarysystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String userId;
	
	@Column
	private String userName;
	

	
	
}
