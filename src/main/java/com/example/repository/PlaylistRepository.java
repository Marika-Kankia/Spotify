package com.example.repository;

import com.example.model.Playlist;
import com.example.model.User;  // Correct import for your User class
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;  // Correct import for List

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    List<Playlist> findByUser(User user);  // Corrected method signature
}
