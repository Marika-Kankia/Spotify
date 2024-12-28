package com.example.controller;

import com.example.model.Album;
import com.example.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping
    public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
        Album createdAlbum = albumService.createAlbum(album);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAlbum);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbum(@PathVariable Long id) {
        Album album = albumService.getAlbum(id);
        return ResponseEntity.ok(album);
    }
}
