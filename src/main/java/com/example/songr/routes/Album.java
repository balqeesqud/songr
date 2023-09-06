package com.example.songr.routes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // How the generated Id will be
    private Long id;
    private String title, artist, imageUrl;
    private int songCount;
    private int length;


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


