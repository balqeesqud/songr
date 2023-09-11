package com.example.songr.controllers;

import com.example.songr.exceptions.AlbumNotFoundException;
import com.example.songr.repository.AlbumJpa;
import com.example.songr.repository.SongJpa;
import com.example.songr.models.Album;
import com.example.songr.models.Song;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {
    private AlbumJpa albumJpa;
    private SongJpa songJpa;

    public SongController(AlbumJpa albumJpa, SongJpa songJpa) {
        this.albumJpa = albumJpa;
        this.songJpa = songJpa;
    }

    @PostMapping("/add-song")
    public RedirectView addSong( String title, int length, int trackNumber, Long albumId) {
        Album album = albumJpa
                .findById(albumId)
                .orElseThrow(() -> new AlbumNotFoundException("Could not find an Album for this song in the database!"));

        Song song = new Song(title, length, trackNumber, album);
        songJpa.save(song);

        return new RedirectView("/allAlbums");
    }


}
