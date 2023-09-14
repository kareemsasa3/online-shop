package com.online.shop.service;

import com.online.shop.entity.Role;
import com.online.shop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(Role role) {
        // implement validation or business logic if needed
        return roleRepository.save(role);
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found"));
    }

    public Role updateRole(Role role) {
        // implement validation or business logic if needed
        return roleRepository.save(role);
    }

    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }

    // other methods as needed
}
