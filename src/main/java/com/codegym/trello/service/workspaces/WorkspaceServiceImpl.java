package com.codegym.trello.service.workspaces;

import com.codegym.trello.model.Workspace;
import com.codegym.trello.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {
    @Autowired
    private WorkspaceRepository workspacesRepository;
    @Override
    public Iterable<Workspace> findAll() {
        return workspacesRepository.findAll();
    }

    @Override
    public Optional<Workspace> findById(Long id) {
        return workspacesRepository.findById(id);
    }

    @Override
    public Workspace save(Workspace workspaces) {
        return workspacesRepository.save(workspaces);
    }

    @Override
    public void deleteById(Long id) {
        workspacesRepository.deleteById(id);
    }

    @Override
    public Iterable<Workspace> findAllByOwnerId(Long id) {
        return workspacesRepository.findAllByOwnerId(id);
    }

    @Override
    public Boolean isBoardInWorkspace(Long boardId) {
        Integer isInWorkspace = workspacesRepository.isBoardInWorkspace(boardId);
        if (isInWorkspace != 0) {
            return true;
        }
        return false;
    }

}
