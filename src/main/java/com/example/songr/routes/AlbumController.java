package com.example.songr.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class AlbumController {
    private AlbumJpa albumJpa;

//    @Autowired  // this annotation will find the "AlbumJpa" class and inject it
//    AlbumJpa albumJpa; // the interfaced class with JPA repo


//    constructor injection
        public AlbumController(AlbumJpa albumJpa) {
        this.albumJpa = albumJpa;
    }

    // Creating Albums (POST)
    @PostMapping("/create-album")
    //is responsible for processing an HTTP POST request, likely coming from an HTML form, and saving data to a database using JPA. I
    public RedirectView createAlbum(String title, String artist, String imageUrl, int songCount, int length) {
        Album newAlbum = new Album(title, artist, imageUrl, length, songCount);  //This line creates a new Album object based on the data provided in the POST request.
        // It assumes that the data is coming from an HTML form submission. // this obj will be converted into a record in DB by help of JPA & ORM principle
        albumJpa.save(newAlbum);  // here JPA will take the conversion and save in DB as record
        return new RedirectView("/allAlbums"); // will redirect to another endpoint i choose

    }

    // Get All Albums (GET)
    @GetMapping("/allAlbums")
    public String getAlbums(Model model) {  // when using a Model means creating an HTML to follow
        List<Album> albums =  albumJpa.findAll();  // Retrieve a list of albums from the database using JPA
        model.addAttribute("albums", albums);    // Add the list of albums to the model, making it available to the HTML template
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
        return new RedirectView("/albums");
    }

    }

