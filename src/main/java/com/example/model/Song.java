package com.example.model;

import jakarta.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String artist;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;  // Reference to playlist

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;  // Reference to album

    // Constructors
    public Song() {
    }

    public Song(String title, String artist, String genre, Playlist playlist, Album album) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.playlist = playlist;
        this.album = album;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
