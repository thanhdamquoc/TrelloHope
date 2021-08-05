package com.codegym.trello.controller;

import com.codegym.trello.model.Workspaces;
import com.codegym.trello.service.workspaces.WorkspaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/workspaces")
public class WorkspaceController {
    @Autowired
    private WorkspaceServiceImpl workspacesService;

    @GetMapping("")
    public ResponseEntity<Iterable<Workspaces>> findAll() {
        return new ResponseEntity<>(workspacesService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/owner/{id}")
    public ResponseEntity<Iterable<Workspaces>> findAllByOwnerId(@PathVariable Long id) {
        Iterable<Workspaces> workspaces = workspacesService.findAllByOwnerId(id);
        if (workspaces == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(workspacesService.findAllByOwnerId(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Workspaces> save(@RequestBody Workspaces workspaces) {
        return new ResponseEntity<>(workspacesService.save(workspaces), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Workspaces>> findById(@PathVariable Long id){
        Optional<Workspaces> workspacesOptional = workspacesService.findById(id);
        if (!workspacesOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(workspacesOptional, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workspaces> updateById(@PathVariable Long id, @RequestBody Workspaces workspaces){
        Optional<Workspaces> workspacesOptional = workspacesService.findById(id);
        if (!workspacesOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        workspaces.setId(workspacesOptional.get().getId());
        workspacesService.save(workspaces);
        return new ResponseEntity<>(workspaces,HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Workspaces> deleteById(@PathVariable Long id){
        Optional<Workspaces> workspacesOptional = workspacesService.findById(id);
        if (!workspacesOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        workspacesService.deleteById(workspacesOptional.get().getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
