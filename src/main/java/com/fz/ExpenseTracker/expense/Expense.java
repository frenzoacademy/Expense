package com.fz.ExpenseTracker.expense;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fz.ExpenseTracker.category.Category;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
public class Expense implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime date_time;
	private int amount;
	private String paid_account;
	private String reference;
	private String description;

	
    private int category; // Keep category as an int for JSON mapping

	@ManyToOne(fetch = FetchType.EAGER) // Lazy fetch to prevent unnecessary loading
    @JsonIgnoreProperties({"services", "expenses"})
	@JoinColumn(name = "category_id") 
	private Category categoryEntity;

	public Category getCategoryEntity() {
        Category category = new Category();
        category.setId(category.getId());
        return category;
    }
	
	
	
	public Expense() {
		super();
	}

	public Expense(int id, LocalDateTime date_time, int amount, String paid_account, String reference,
			String description) {
		super();
		this.id = id;
		this.date_time = date_time;
		this.amount = amount;
		this.paid_account = paid_account;
		this.reference = reference;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate_time() {
		return date_time;
	}

	public void setDate_time(LocalDateTime date_time) {
		this.date_time = date_time;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPaid_account() {
		return paid_account;
	}

	public void setPaid_account(String paid_account) {
		this.paid_account = paid_account;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}



	public void setCategoryEntity(Category categoryEntity) {
		this.categoryEntity = categoryEntity;
	}
	
//	public void addCategory(Category category) {
//		this.category.add(category);
//		category.getClass().add(this);
//	}

}
