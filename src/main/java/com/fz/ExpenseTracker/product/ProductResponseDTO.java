package com.fz.ExpenseTracker.product;

import com.fz.ExpenseTracker.category.Category;

public class ProductResponseDTO {
	private int id;
	private String name;
	private Category categoryEntity;

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

	public Category getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(Category categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

}
