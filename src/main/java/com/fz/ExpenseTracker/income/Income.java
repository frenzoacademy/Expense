package com.fz.ExpenseTracker.income;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fz.ExpenseTracker.Account_Type.Account_Type;
import com.fz.ExpenseTracker.account.Account;
import com.fz.ExpenseTracker.category.Category;
import com.fz.ExpenseTracker.service.Services;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime date_time;
	private int amount;
	private String reference;
	private String description;
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

	public Income() {
		super();
	}

	public Income(int id, LocalDateTime date_time, int amount, String reference, String description,
			Category categoryEntity, Services serviceEntity, Account account, Account_Type accountTypeEntity) {
		super();
		this.id = id;
		this.date_time = date_time;
		this.amount = amount;
		this.reference = reference;
		this.description = description;
		this.categoryEntity = categoryEntity;
		this.serviceEntity = serviceEntity;
		this.account = account;
		this.accountTypeEntity = accountTypeEntity;
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

	public Category getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(Category categoryEntity) {
		this.categoryEntity = categoryEntity;
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

	@Override
	public String toString() {
		return "Income [id=" + id + ", date_time=" + date_time + ", amount=" + amount + ", reference=" + reference
				+ ", description=" + description + ", categoryEntity=" + categoryEntity + ", serviceEntity="
				+ serviceEntity + ", account=" + account + ", accountTypeEntity=" + accountTypeEntity + "]";
	}

}
