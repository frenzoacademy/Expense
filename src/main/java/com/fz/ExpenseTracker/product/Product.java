package com.fz.ExpenseTracker.product;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fz.ExpenseTracker.category.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
	@SequenceGenerator(name = "product_generator")
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

//	@JsonIgnore
	private int category;

	@ManyToOne(fetch = FetchType.EAGER)
//	@JsonIgnoreProperties({ "services", "expenses" })
	@JoinColumn(name = "category_id")
	private Category categoryEntity;

	public Product() {
		super();
	}

	public Category getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(Category categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	public void setCategory(int category) {
		this.category = category;
	}
	public int getCategory() {
		return category;
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", categoryEntity=" + categoryEntity
				+ "]";
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
