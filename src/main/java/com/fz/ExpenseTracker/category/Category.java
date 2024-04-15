package com.fz.ExpenseTracker.category;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fz.ExpenseTracker.expense.Expense;
import com.fz.ExpenseTracker.service.Services;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Services> services;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category", orphanRemoval = true)
	private List<Expense> expenses;

	
	public Category() {
		super();
	}

	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public List<Services> getServices() {
		return services;
	}

	public void setServices(List<Services> services) {
		this.services = services;
	}

//	public void addCategory(Expense expense) {
//		this.expenses.add(expense);
//		expense.getCategory().add(this);
//	}
	
	
	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", services=" + services + "]";
	}

}
