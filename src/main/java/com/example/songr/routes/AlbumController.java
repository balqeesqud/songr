package com.example.songr.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {

    @Autowired  // this annotation will find the "AlbumJpa" class and inject it
    AlbumJpa albumJpa; // the interfaced class with JPA repo


    // Creating Albums (POST)
    @PostMapping("/create-album") // it will follow the html file created for album class in order to see how to render the data
    public RedirectView createAlbum(String title, String artist, String imageUrl, int songCount, int length){
        Album newAlbum=new Album(title,artist,imageUrl,length,songCount);   // this obj will be converted into a record in DB by help of JPA & ORM principle
        albumJpa.save(newAlbum);  // here JPA will take the conversion and save in DB as record
        return new RedirectView("/allAlbums"); // will redirect to another endpoint i choose

    }

    // Get All Albums (GET)
    @GetMapping("/allAlbums")
    public String getAlbums(Model model){  // when using a Model means creating an HTML to follow
        List<Album> albums=albumJpa.findAll();
        model.addAttribute("albums",albums);
        return "album.html";
    }

    @DeleteMapping("/delete/")
    public RedirectView deleteAlbumById(@PathVariable Long albumId){
        albumJpa.deleteById(albumId);
        return new RedirectView("/allAlbums");
    }


}
