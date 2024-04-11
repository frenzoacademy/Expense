package com.expenses.ExpenseTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {
	@Autowired
	ServiceRepository serviceRepository;

	public Services createService(Services service) {
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
