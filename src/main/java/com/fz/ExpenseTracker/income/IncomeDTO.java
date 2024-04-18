package com.fz.ExpenseTracker.income;

import java.time.LocalDateTime;

public class IncomeDTO {
	private int id;
	private LocalDateTime date_time;
	private int amount;
	private String reference;
	private String description;
	
	private int service;
	private int paid_account;
	private int account_type;
	private int category;
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
	public int getService() {
		return service;
	}
	public void setService(int service) {
		this.service = service;
	}
	public int getPaid_account() {
		return paid_account;
	}
	public void setPaid_account(int paid_account) {
		this.paid_account = paid_account;
	}
	public int getAccount_type() {
		return account_type;
	}
	public void setAccount_type(int account_type) {
		this.account_type = account_type;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
}
