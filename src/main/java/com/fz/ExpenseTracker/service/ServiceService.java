package com.fz.ExpenseTracker.service;

import java.util.ArrayList;
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
	    Optional<Category> existingCategory =categoryRepository.findByName(service.getCategory().getName());
	    if(existingCategory.isPresent()) {
	    	Category category=existingCategory.get();
	    	service.setCategory(category);
	    }
	    return serviceRepository.save(service);
	}

		public List<ServiceDTO> getAllServices() {
	        List<Services> servicesList = serviceRepository.findAll();
	        List<ServiceDTO> serviceDTOList = new ArrayList<>();

	        for (Services service : servicesList) {
	            ServiceDTO serviceDTO = new ServiceDTO();
	            serviceDTO.setId(service.getId());
	            serviceDTO.setName(service.getName());
	            serviceDTO.setCategoryName(service.getCategory().getName()); 
	            serviceDTOList.add(serviceDTO);
	        }

	        return serviceDTOList;
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
