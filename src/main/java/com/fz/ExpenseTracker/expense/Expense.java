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
	private String paid_account;
	private String reference;
	private String description;
	private String vendorName;
	private String vendorGst;
	
	private int service;
	private int account_type;
	private int account_details;
	private int category;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "services", "expenses" })
	@JoinColumn(name = "category_id")
	private Category categoryEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties("expenses")
	@JoinColumn(name = "service_id")
	private Services serviceEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id")
	private Account account;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_type_id")
	private Account_Type accountTypeEntity;

	public Category getCategoryEntity() {
		return categoryEntity;
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

	public int getService() {
		return service;
	}

	public void setService(int service) {
		this.service = service;
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

	public int getAccount_type() {
		return account_type;
	}

	public void setAccount_type(int account_type) {
		this.account_type = account_type;
	}

	public int getAccount_details() {
		return account_details;
	}

	public void setAccount_details(int account_details) {
		this.account_details = account_details;
	}

//	public void addCategory(Category category) {
//		this.category.add(category);
//		category.getClass().add(this);
//	}

}
