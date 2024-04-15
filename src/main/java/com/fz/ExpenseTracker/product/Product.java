package com.fz.ExpenseTracker.product;

import com.fz.ExpenseTracker.category.Category;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
	@SequenceGenerator(name = "product_generator")
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category")
	private Category category;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
/*
 * Product - id - name - category
 * 
 * Service - id - name - category
 * 
 * Category - id - name
 * 
 * Bill
 * 
 * 
 * Company - id - name - legal name - type - email - phone_number - address -
 * Currency
 * 
 * 
 * Expense - Timestamp - Category - Amount - Paid_Account - Reference -
 * Description
 * 
 * User_Account: - user - account
 * 
 * Account - id - Category - UPI_ID - AccountNumber - Amount
 * 
 * 
 * Account_Category - id - Name
 * 
 * Bill
 * 
 * Income
 * 
 * Accounting - id - first_month - accounting_method
 * 
 * Currency
 */
