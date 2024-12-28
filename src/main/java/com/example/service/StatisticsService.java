package com.example.service;

import com.example.model.MusicStatistics;
import com.example.repository.MusicStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private final MusicStatisticsRepository musicStatisticsRepository;

    @Autowired
    public StatisticsService(MusicStatisticsRepository musicStatisticsRepository) {
        this.musicStatisticsRepository = musicStatisticsRepository;
    }

    // Increment plays for a given song
    public void incrementPlayCount(Long songId) {
        MusicStatistics statistics = musicStatisticsRepository.findBySongId(songId);

        if (statistics != null) {
            statistics.incrementPlays();
            musicStatisticsRepository.save(statistics);  // Save updated statistics
        } else {
            // Handle case where no statistics found for songId (perhaps create a new record)
            throw new IllegalArgumentException("No statistics found for the song with ID: " + songId);
        }
    }

    // Other methods for querying statistics can go here
}
