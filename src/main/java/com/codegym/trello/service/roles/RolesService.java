package com.codegym.trello.service.roles;

import com.codegym.trello.model.Roles;
import com.codegym.trello.repository.IRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class RolesService implements IRolesService {

    @Autowired
    private IRolesRepository rolesRepository;

    @Override
    public Iterable<Roles> findAll() {
        return rolesRepository.findAll();
    }

    @Override
    public Optional<Roles> findById(Long id) {
        return rolesRepository.findById(id);
    }

    @Override
    public Roles save(Roles roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public void deleteById(Long id) {
        rolesRepository.deleteById(id);
    }
}
