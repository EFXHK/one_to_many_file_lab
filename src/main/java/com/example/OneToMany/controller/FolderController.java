package com.example.OneToMany.controller;

import com.example.OneToMany.models.File;
import com.example.OneToMany.models.Folder;
import com.example.OneToMany.repository.FileRepository;
import com.example.OneToMany.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {
    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders() {
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/folders/{id}")
    public ResponseEntity<Optional<Folder>> getFolder(@PathVariable Long id) {
        return new ResponseEntity<>(folderRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> postFolder(@RequestBody Folder folder) {
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }
}
