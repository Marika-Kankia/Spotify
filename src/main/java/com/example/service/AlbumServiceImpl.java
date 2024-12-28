package com.example.service;

import com.example.model.Album;
import com.example.repository.AlbumRepository;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public Album createAlbum(Album album) {
        if (album.getTitle() == null || album.getArtist() == null) {
            throw new IllegalArgumentException("Album title and artist are required");
        }
        return albumRepository.save(album);
    }

    @Override
    public Album getAlbum(Long id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album not found: " + id));
    }
}
