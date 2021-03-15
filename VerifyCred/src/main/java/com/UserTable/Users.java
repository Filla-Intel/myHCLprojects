package com.UserTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	 @Id 
	 @Column(name="Id")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	 @Column(name="UserName")
	private String UserName;
	 @Column(name="Password")
	private String Password;
	 
	 public Users() {
		 
	 }
	 //sets up the database framework
	 public Users(String userName, String password) {
		 UserName = userName;
		 Password = password;
	 }

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

	public String getUserName() {
		return UserName;
	}
	
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String password) {
		Password = password;
	}
}
