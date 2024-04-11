package com.expenses.ExpenseTracker.expense;

import java.time.LocalDateTime;

import com.expenses.ExpenseTracker.category.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime date_time;
	private int amount;
	private String paid_account;
	private String reference;
	private String description;
	@OneToOne
	private Category category;
	
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
