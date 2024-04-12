package com.fz.ExpenseTracker.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

	@Autowired
	ProdductRepository productrepository;

	public Product addProduct(Product product) {
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
		Optional<Product> prod = productrepository.findById(product.getId());
		if (prod.isPresent()) {
			Product pro = prod.get();
			if (product.getName() != null) {
				pro.setName(product.getName());
			}
			if(product.getCategory() !=null) {
				pro.setCategory(product.getCategory());
			}
		}
		return null;
	}
	
	public void deleteProduct(int id) {

	}

}
