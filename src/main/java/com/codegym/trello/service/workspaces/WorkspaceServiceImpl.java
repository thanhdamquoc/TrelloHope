package com.codegym.trello.service.workspaces;

import com.codegym.trello.model.Workspaces;
import com.codegym.trello.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {
    @Autowired
    private WorkspaceRepository workspacesRepository;
    @Override
    public Iterable<Workspaces> findAll() {
        return workspacesRepository.findAll();
    }

    @Override
    public Optional<Workspaces> findById(Long id) {
        return workspacesRepository.findById(id);
    }

    @Override
    public Workspaces save(Workspaces workspaces) {
        return workspacesRepository.save(workspaces);
    }

    @Override
    public void deleteById(Long id) {
        workspacesRepository.deleteById(id);
    }

    @Override
    public Iterable<Workspaces> findAllByOwnerId(Long id) {
        return workspacesRepository.findAllByOwnerId(id);
    }


}
