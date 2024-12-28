package com.example.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class MusicStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;  // Reference to the song

    private int listenCount;  // How many times the song has been played

    private Date lastPlayedDate;  // The last date the song was played

    // Constructors
    public MusicStatistics() {
    }

    public MusicStatistics(Song song, int listenCount, Date lastPlayedDate) {
        this.song = song;
        this.listenCount = listenCount;
        this.lastPlayedDate = lastPlayedDate;
    }

    // Increment the listen count
    public void incrementPlays() {
        this.listenCount++;
        this.lastPlayedDate = new Date();  // Set current date as the last played date
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public int getListenCount() {
        return listenCount;
    }

    public void setListenCount(int listenCount) {
        this.listenCount = listenCount;
    }

    public Date getLastPlayedDate() {
        return lastPlayedDate;
    }

    public void setLastPlayedDate(Date lastPlayedDate) {
        this.lastPlayedDate = lastPlayedDate;
    }
}
