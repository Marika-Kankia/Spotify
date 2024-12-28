package com.example.controller;

import com.example.model.Playlist;
import com.example.model.User; // Correct import for your User class
import com.example.service.PlaylistService;
import com.example.service.UserService; // Assuming you have a service to manage User entities
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;
    private final UserService userService; // Inject UserService to get User by userId

    @Autowired
    public PlaylistController(PlaylistService playlistService, UserService userService) {
        this.playlistService = playlistService;
        this.userService = userService;
    }

    // Create or Update Playlist
    @PostMapping("/save")
    public ResponseEntity<Playlist> savePlaylist(@RequestBody Playlist playlist) {
        Playlist savedPlaylist = playlistService.savePlaylist(playlist);
        return new ResponseEntity<>(savedPlaylist, HttpStatus.CREATED);
    }

    // Get Playlist by ID
    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable Long id) {
        return playlistService.getPlaylistById(id)
                .map(playlist -> new ResponseEntity<>(playlist, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get All Playlists by User
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Playlist>> getPlaylistsByUser(@PathVariable Long userId) {
        // Fetch the actual User by userId
        User user = userService.getUserById(userId);  // Assuming UserService has getUserById method
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Get the playlists by the retrieved user
        List<Playlist> playlists = playlistService.getPlaylistsByUser(user);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    // Delete Playlist by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
