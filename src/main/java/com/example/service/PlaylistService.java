package com.example.service;

import com.example.model.Playlist;
import com.example.model.User;  // Import the correct User class from your project
import com.example.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    // Create or Update Playlist
    public Playlist savePlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    // Get Playlist by ID
    public Optional<Playlist> getPlaylistById(Long id) {
        return playlistRepository.findById(id);
    }

    // Get All Playlists by User
    public List<Playlist> getPlaylistsByUser(User user) {
        return playlistRepository.findByUser(user); // Use the correct User class here
    }

    // Delete Playlist
    public void deletePlaylist(Long id) {
        playlistRepository.deleteById(id);
    }

    // Get All Playlists
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }
}
