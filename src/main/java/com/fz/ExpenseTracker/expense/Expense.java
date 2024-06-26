package com.fz.ExpenseTracker.expense;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fz.ExpenseTracker.Account_Type.Account_Type;
import com.fz.ExpenseTracker.account.Account;
import com.fz.ExpenseTracker.category.Category;
import com.fz.ExpenseTracker.service.Services;

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
public class Expense implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime date_time;
	private int amount;
	private String reference;
	private String description;
	private String vendorName;
	private String vendorGst;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private Category categoryEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "service_id")
	private Services serviceEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id")
	private Account account;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_type_id")
	@JsonIgnore
	private Account_Type accountTypeEntity;

	public Category getCategoryEntity() {
		return categoryEntity;
	}

	public Expense() {
		super();
	}

	public Expense(int id, LocalDateTime date_time, int amount, String reference,
			String description) {
		super();
		this.id = id;
		this.date_time = date_time;
		this.amount = amount;
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

	public void setCategoryEntity(Category categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorGst() {
		return vendorGst;
	}

	public void setVendorGst(String vendorGst) {
		this.vendorGst = vendorGst;
	}

	public Services getServiceEntity() {
		return serviceEntity;
	}

	public void setServiceEntity(Services serviceEntity) {
		this.serviceEntity = serviceEntity;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Account_Type getAccountTypeEntity() {
		return accountTypeEntity;
	}

	public void setAccountTypeEntity(Account_Type accountTypeEntity) {
		this.accountTypeEntity = accountTypeEntity;
	}

//	public void addCategory(Category category) {
//		this.category.add(category);
//		category.getClass().add(this);
//	}

}
