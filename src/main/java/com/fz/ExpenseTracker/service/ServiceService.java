package com.fz.ExpenseTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fz.ExpenseTracker.category.Category;
import com.fz.ExpenseTracker.category.CategoryRepository;

@Service
public class ServiceService {
	@Autowired
	ServiceRepository serviceRepository;

	@Autowired
	CategoryRepository categoryRepository;

	public Services createService(Services service) {
	    Category existingCategory = categoryRepository.findByName(service.getCategory().getName());
	    if (existingCategory != null) {
	        service.setCategory(existingCategory);
	    }
	    return serviceRepository.save(service);
	}


	public List<Services> getAllServices() {
		return serviceRepository.findAll();
	}

	public Optional<Services> getServiceById(int id) {
		return serviceRepository.findById(id);
	}

	public Services updateService(int id, Services updatedService) throws ServiceNotFoundException {
		if (serviceRepository.existsById(id)) {
			updatedService.setId(id);
			return serviceRepository.save(updatedService);
		} else {
			throw new ServiceNotFoundException("The requested services is not available");
		}
	}

	public void deleteService(int id) {
		serviceRepository.deleteById(id);
	}

}
