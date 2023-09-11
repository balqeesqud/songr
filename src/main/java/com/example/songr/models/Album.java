package com.example.songr.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title, artist;

    @Lob
    @Column(length = Integer.MAX_VALUE)   // Integer.MAX_VALUE to handle very long strings
    private String  imageUrl;
    private int songCount;
    private int length;

    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL) // mappedBy(the object of Album class "song") attribute specifies the field in the Song
    private List<Song> songs;                                     // entity that maps this relationship ( the album field in the Song entity)



        public Album() {
        }

        public Album(String title, String artist, String imageUrl, int songCount, int length) {
            this.title = title;
            this.artist = artist;
            this.imageUrl = imageUrl;
            this.songCount = songCount;
            this.length = length;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getArtist() {
            return artist;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getSongCount() {
            return songCount;
        }

        public void setSongCount(int songCount) {
            this.songCount = songCount;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Long getId() {
        return id;
    }

    @Override
        public String toString() {
            return "Album{" +
                    "title='" + title + '\'' +
                    ", artist='" + artist + '\'' +
                    ", imageUrl='" + imageUrl + '\'' +
                    ", songCount=" + songCount +
                    ", length=" + length +
                    '}';
        }
    }


