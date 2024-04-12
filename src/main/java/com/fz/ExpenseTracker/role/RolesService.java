package com.fz.ExpenseTracker.role;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RolesService {

    @Autowired
    private RolesRepository RolesRepository;

    public Roles createRoles(Roles Roles) {
        return RolesRepository.save(Roles);
    }

    public List<Roles> getAllRoless() {
        return (List<Roles>) RolesRepository.findAll();
    }

    public Roles getRolesById(int id) {
        Optional<Roles> RolesOptional = RolesRepository.findById(id);
        return RolesOptional.orElseThrow(() -> new RoleNotFoundException("Roles not found with id: " + id));
    }

    public Roles updateRoles(int id, Roles RolesDetails) {
        Roles Roles = getRolesById(id);
        Roles.setRoles(RolesDetails.getRoles());
        // You can update other properties of the Roles as needed

        return RolesRepository.save(Roles);
    }

    public void deleteRoles(int id) {
        Roles Roles = getRolesById(id);
        RolesRepository.delete(Roles);
    }
}
