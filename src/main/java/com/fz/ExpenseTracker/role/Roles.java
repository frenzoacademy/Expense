package com.fz.ExpenseTracker.role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_generator")
	@SequenceGenerator(name = "roles_generator", sequenceName = "roles_seq", allocationSize = 1)
	private int id;
	
	//staff ,owner oe admin
	@Column(name="role")
	private String roles;
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(int id, String roles) {
		super();
		this.id = id;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	
}
