package com.codegym.trello.service.memberworkspace;

import com.codegym.trello.model.MemberWorkspace;
import com.codegym.trello.model.Workspace;
import com.codegym.trello.repository.MemberWorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberWorkspaceImpl implements MemberWorkspaceService{
    @Autowired
    private MemberWorkspaceRepository memberWorkspaceRepository;
    @Override
    public Iterable<MemberWorkspace> findAll() {
        return memberWorkspaceRepository.findAll();
    }

    @Override
    public Optional<MemberWorkspace> findById(Long id) {
        return memberWorkspaceRepository.findById(id);
    }

    @Override
    public MemberWorkspace save(MemberWorkspace memberWorkspace) {
        return memberWorkspaceRepository.save(memberWorkspace);
    }

    @Override
    public void deleteById(Long id) {
        memberWorkspaceRepository.deleteById(id);
    }

    @Override
    public Iterable<MemberWorkspace> findByKeyword(String keyword, Long workspaceId) {
        return memberWorkspaceRepository.findByKeyword('%' + keyword + '%', workspaceId);
    }
}
