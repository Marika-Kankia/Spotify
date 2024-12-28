package com.example.service;

import com.example.model.Album;

public interface AlbumService {
    Album createAlbum(Album album);
    Album getAlbum(Long id);
}
