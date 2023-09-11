package com.example.songr.models;

import com.example.songr.models.Album;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int length;
    private int trackNumber;

    @ManyToOne
    private Album song; // Album is One ---- song is Many (song is the mappedby in Album Entity)

    public Song() {
    }

    public Song(String title, int length, int trackNumber, Album song) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.song = song;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Album getSong() {
        return song;
    }

    public void setSong(Album song) {
        this.song = song;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", length=" + length +
                ", trackNumber=" + trackNumber +
                ", song=" + song +
                '}';
    }
}