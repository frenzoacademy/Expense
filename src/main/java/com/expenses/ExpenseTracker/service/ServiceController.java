package com.expenses.ExpenseTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class ServiceController {
	@Autowired
	ServiceService services;

	@PostMapping
	public ResponseEntity<Services> createService(@RequestBody Services service) {
		Services createdService = services.createService(service);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdService);
	}

	@GetMapping
	public ResponseEntity<List<Services>> getAllServices() {
		List<Services> serviceList = services.getAllServices();
		return ResponseEntity.ok(serviceList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Services> getServiceById(@PathVariable int id) {
		Optional<Services> service = services.getServiceById(id);
		return service.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Services> updateService(@PathVariable int id, @RequestBody Services updatedService) throws ServiceNotFoundException {
		Services service = services.updateService(id, updatedService);
		if (service != null) {
			return ResponseEntity.ok(service);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteService(@PathVariable int id) {
		services.deleteService(id);
		return ResponseEntity.noContent().build();
	}
}
