package com.example.songr.repository;

import com.example.songr.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongJpa extends JpaRepository<Song, Long> {

}
