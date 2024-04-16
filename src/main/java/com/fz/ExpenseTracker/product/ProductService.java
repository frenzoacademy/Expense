package com.fz.ExpenseTracker.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fz.ExpenseTracker.category.Category;
import com.fz.ExpenseTracker.category.CategoryNotFoundException;
import com.fz.ExpenseTracker.category.CategoryRepository;

@Service
public class ProductService {

	@Autowired
	ProdductRepository productrepository;

	@Autowired
	CategoryRepository categoryrepository;

	public Product addProduct(Product product) throws CategoryNotFoundException {
		if (product.getCategory() != null) {
			Optional<Category> optionalCategory = Optional.ofNullable(categoryrepository.findByName(product.getCategory().getName()));
			if (optionalCategory.isPresent()) {
				Category category = optionalCategory.get();
				product.setCategory(category);
			} else {
				throw new CategoryNotFoundException("Category with ID " + product.getCategory().getId() + " not found");
			}
		}
		productrepository.save(product);
		return product;
	}

	public List<Product> getProducts() {
		List<Product> pro = (List<Product>) productrepository.findAll();
		return pro;
	}

	public Product getProductById(int id) {
		Optional<Product> product = productrepository.findById(id);
		if (product.isPresent()) {
			Product pro = product.get();
			return pro;
		} else {
			throw new ProductNotFoundException("Given data is  not found");
		}
	}

	public Product updateProduct(int id, Product product) {
		Optional<Product> prod = productrepository.findById(id);
		if (prod.isPresent()) {
			Product pro = prod.get();
			if (product.getName() != null) {
				pro.setName(product.getName());
			}
			if (product.getCategory() != null) {
				pro.setCategory(product.getCategory());
			}
			return productrepository.save(pro);
		} else {
			throw new ProductNotFoundException("Given data is not found");
		}
	}

	public void deleteProduct(int id) {
		Optional<Product> pro = productrepository.findById(id);
		if (pro.isPresent()) {
			productrepository.deleteById(id);
		}
	}

}
