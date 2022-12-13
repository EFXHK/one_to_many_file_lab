package com.example.OneToMany.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"user"})
    private List<Folder> folders;

    public User(String fullName) {
        this.fullName = fullName;
        this.folders = new ArrayList<>();
    }

    public User() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

//    public void addFolder(Folder folder) {
//        this.folders.add(folder);
//    }
}
