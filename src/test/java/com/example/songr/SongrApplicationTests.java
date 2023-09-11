package com.example.songr;

import com.example.songr.models.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests {


	// Constructer Testing
	@Test
	public void testConstructor() {
	Album album = new Album("My Way", "Frank Sinatra", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCxaCK0-8U9_D753xkMR31ncIvKhhpe7ZRysODmLyuZw&s", 8, 120);


	assertEquals("My Way", album.getTitle());
	assertEquals("Frank Sinatra", album.getArtist());
	assertEquals(8, album.getSongCount());
	assertEquals("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCxaCK0-8U9_D753xkMR31ncIvKhhpe7ZRysODmLyuZw&s", album.getImageUrl());
}


    // Getters & Setter testing
	@Test
	public void testGettersAndSetters() {
		Album album = new Album();

		album.setTitle("Hello");
		album.setArtist("Adele");
		album.setSongCount(12);
		album.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQs3pFq-3-QyNuZ_BXfPDBR67oJlkNiDXmChRLjYrS8FQ&s");

		// Verify that getters return the updated values
		assertEquals("Hello", album.getTitle());
		assertEquals("Adele", album.getArtist());
		assertEquals(12, album.getSongCount());
		assertEquals("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQs3pFq-3-QyNuZ_BXfPDBR67oJlkNiDXmChRLjYrS8FQ&s", album.getImageUrl());
	}
}
