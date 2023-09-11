package com.example.songr.controllers;

import com.example.songr.repository.AlbumJpa;
import com.example.songr.models.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class AlbumController {
    private AlbumJpa albumJpa;
        public AlbumController(AlbumJpa albumJpa) {
        this.albumJpa = albumJpa;
    }

//    @GetMapping("/albums")
//    public String artistAlbums(Model model) {
////        Album albumOne= new Album("I Love You Baby", "Frank Sinatra", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCzazdZbN0Cd7_15DYH98ugup9NTU5sYgdV51fF6-6Mg&s", 7, 145);
////        Album albumTwo = new Album("Fly me to the moon", "Frank Sinatra", "data:image/jpeg;base64,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", 5, 142);
//        Album albumThree = new Album("My Way", "Frank Sinatra", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCxaCK0-8U9_D753xkMR31ncIvKhhpe7ZRysODmLyuZw&s", 8, 120);
//        Album albumOne = new Album("My Way", "Frank Sinatra", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCxaCK0-8U9_D753xkMR31ncIvKhhpe7ZRysODmLyuZw&s", 8, 120);
//        Album[] albums = { albumOne, albumThree};
//        albumJpa.save(albumThree);
//        albumJpa.save(albumOne);
//        model.addAttribute("albums", albums);
//        return "album.html";
//    }


    @PostMapping("/create-album")
    public RedirectView createAlbum(String title, String artist, String imageUrl, int songCount, int length) {
        Album newAlbum = new Album(title, artist, imageUrl, length, songCount);
        albumJpa.save(newAlbum);
        return new RedirectView("/allAlbums");

    }


    // Get All Albums (GET)
    @GetMapping("/allAlbums")
    public String getAlbums(Model model) {
        List<Album> albums =  albumJpa.findAll();
        model.addAttribute("albums", albums);
        return "album.html";
    }

    @DeleteMapping("/albums/{id}")
    public RedirectView deleteAlbumById(@PathVariable Long id){
        albumJpa.deleteById(id);
        return new RedirectView("/allAlbums");
    }

    @PutMapping("/update/{id}")
    public RedirectView updateAlbum(@PathVariable Long id,@RequestParam String newTitle){
        Optional<Album> optionalAlbum = albumJpa.findById(id);
        Album albumToUpdate = optionalAlbum.get();
        albumToUpdate.setTitle(newTitle);
        albumJpa.save(albumToUpdate);
        return new RedirectView("/allAlbums");
    }

    }

