package com.fz.ExpenseTracker.expense;

import java.time.LocalDateTime;

public class ExpenseDto {

	private int id;
	private LocalDateTime dateTime;
	private int amount;
	private String paidAccount;
	private String reference;
	private String description;
	private int category;

	
	public ExpenseDto() {
		super();
	}

	public ExpenseDto(Expense expense) {
	        this.id = expense.getId();
	        this.dateTime = expense.getDate_time();
	        this.amount = expense.getAmount();
	        this.paidAccount = expense.getPaid_account();
	        this.reference = expense.getReference();
	        this.description = expense.getDescription();
//	        if (expense.getCategory() != null) {
//	            this.categoryId = expense.getCategory().getId();
//	        }
	    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPaidAccount() {
		return paidAccount;
	}

	public void setPaidAccount(String paidAccount) {
		this.paidAccount = paidAccount;
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
}
