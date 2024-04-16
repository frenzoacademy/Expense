package com.fz.ExpenseTracker.Account_Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Account_Type {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_category_generator")
	@SequenceGenerator(name = "account_category_generator")
	@Column(name = "id")
	private int id;
	private String name;

	public Account_Type(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Account_Type() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
