package com.example.model;

import jakarta.persistence.*;
import org.apache.catalina.Group;

import java.util.Set;

@Entity
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Playlist> playlists;

    @OneToMany(mappedBy = "user")
    private Set<Album> albums;

    public abstract boolean isInRole(Role role);

    public abstract void removeGroup(Group group);

    // Getters and Setters
}

