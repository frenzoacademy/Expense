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

	public Services createService(ServiceDTO service) {
		Services s=new Services();
	    Optional<Category> existingCategory =categoryRepository.findById(service.getCategory());
	    if(existingCategory.isPresent()) {
	    	Category category=existingCategory.get();
	    	s.setCategory(category);
	    }
	    s.setName(service.getName());
	    return serviceRepository.save(s);
	}

		public List<Services> getAllServices() {
	        List<Services> servicesList = serviceRepository.findAll();
	        List<ServiceDTO> serviceDTOList = new ArrayList<>();

//	        for (Services service : servicesList) {
//	            ServiceDTO serviceDTO = new ServiceDTO();
//	            serviceDTO.setId(service.getId());
//	            serviceDTO.setName(service.getName());
//	            serviceDTO.setCategoryName(service.getCategory().getName()); 
//	            serviceDTOList.add(serviceDTO);
//	        }

	        return servicesList;
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
