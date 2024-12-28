package com.example.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String artist;
    private int releaseYear;

    @OneToMany(mappedBy = "album")
    private Set<Song> songs;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Object getTitle() {
        return title;
    }

    public Object getArtist() {
        return artist;
    }

    // Getters and Setters
}
