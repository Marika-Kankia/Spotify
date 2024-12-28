package com.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "playlist")
    private List<Song> songs;

    // Getters and Setters
}
