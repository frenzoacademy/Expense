package com.fz.ExpenseTracker.product;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fz.ExpenseTracker.category.Category;
import com.fz.ExpenseTracker.category.CategoryRepository;
import com.fz.ExpenseTracker.expense.Expense;

import com.fz.ExpenseTracker.expense.Expense;


@Service
public class ProductService {

	@Autowired
    private ProductRepository productRepository;
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

	public Product addProduct(Product product) throws CategoryNotFoundException {
		if (product.getCategory() != null) {
			Optional<Category> optionalCategory = Optional.ofNullable(categoryRepository.findByName(product.getCategory().getName()));
			if (optionalCategory.isPresent()) {
				Category category = optionalCategory.get();
				product.setCategory(category);
			} else {
				throw new CategoryNotFoundException("Category with ID " + product.getCategory().getId() + " not found");
			}
		}
		productRepository.save(product);
		return product;
	}

      
    
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        List<ProductResponseDTO> listOfProducts = new ArrayList<>();
        for (Product product : products) {
            ProductResponseDTO dto = new ProductResponseDTO();
            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setCategoryEntity(product.getCategoryEntity());
            listOfProducts.add(dto);
        }
        return listOfProducts;
    }


    public ProductResponseDTO getProductById(int id) throws ProductNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("The entered id: " + id + " is not present"));
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setCategoryEntity(product.getCategoryEntity());
        return dto;
    }

    public void createProduct(Product productRequest) {
    	System.out.println(productRequest+"----");
        Category category = categoryRepository.findById(productRequest.getCategory())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setCategoryEntity(category);
        productRepository.save(product);
    }

    public Product updateProduct(int id, Product updatedProduct) throws ProductNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("The entered id: " + id + " is not present"));

        Field[] fields = Product.class.getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (field.getName().equals("id")) {
                    continue;
                }
                Object updatedValue = field.get(updatedProduct);
                if (updatedValue != null) {
                    field.set(product, updatedValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return productRepository.save(product);
    }

    public boolean deleteProduct(int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
