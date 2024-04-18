package com.fz.ExpenseTracker.account;

import com.fz.ExpenseTracker.Account_Type.Account_Type;
import com.fz.ExpenseTracker.category.Category;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String upi_id;
	private String account_number;
	private int amount;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountType_id")
    private Account_Type accountEntity;
	
	public Account() {
		super();
	}
	public Account(int id, String upi_id, String account_number, int amount) {
		super();
		this.id = id;
		this.upi_id = upi_id;
		this.account_number = account_number;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUpi_id() {
		return upi_id;
	}
	public void setUpi_id(String upi_id) {
		this.upi_id = upi_id;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account_Type getAccountEntity() {
		return accountEntity;
	}
	public void setAccountEntity(Account_Type accountEntity) {
		this.accountEntity = accountEntity;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", upi_id=" + upi_id + ", account_number=" + account_number
				+ ", amount=" + amount  + "]";
	}
	
	
	
	
}
