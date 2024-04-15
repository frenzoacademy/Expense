package com.fz.ExpenseTracker.category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public Optional<Category> getCategoryById(int id) {
		return categoryRepository.findById(id);
	}

	public Category updateCategory(int id, Category updatedCategory) throws CategoryNotFoundException {
		if (categoryRepository.existsById(id)) {
			updatedCategory.setId(id);
			return categoryRepository.save(updatedCategory);
		} else {
			throw new CategoryNotFoundException("Entered category is not available");
		}
	}

	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);
	}

}
