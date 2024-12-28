package com.example.repository;

import com.example.model.MusicStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicStatisticsRepository extends JpaRepository<MusicStatistics, Long> {
    MusicStatistics findBySongId(Long songId);  // Custom query method
}
