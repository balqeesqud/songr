package com.example.songr;

import com.example.songr.models.Album;
import org.apache.catalina.util.URLEncoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@SpringBootTest
@AutoConfigureMockMvc
class SongrApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void testHelloWorld() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Hello, World!"));
	}

	@Test
	public void testCapitalize() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/capitalize/testInput"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.model().attribute("result", "TESTINPUT"));
	}

	@Test
	public void testInvalidCapitalize() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/capitalize/"))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void testHome() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}


	@Test
	public void testAddSong() throws Exception {
		mockMvc.perform(
	                     post("/add-song") //first create an album then test adding a song to this album
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.param("title", "balqees")
						.param("length", "180")
						.param("trackNumber",  "5")
						.param("albumId",  "1")
				)

				.andExpect(redirectedUrl("/allAlbums")) // we take the redirected url from the /add-song and in the app.properties we put update since we run the test , it removes the old one and create new one son we change it into update.
				.andExpect(MockMvcResultMatchers.status().isFound());

	}





















	// Constructer Testing
//	@Test
//	public void testConstructor() {
//	Album album = new Album("My Way", "Frank Sinatra", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCxaCK0-8U9_D753xkMR31ncIvKhhpe7ZRysODmLyuZw&s", 8, 120);
//
//
//	assertEquals("My Way", album.getTitle());
//	assertEquals("Frank Sinatra", album.getArtist());
//	assertEquals(8, album.getSongCount());
//	assertEquals("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCxaCK0-8U9_D753xkMR31ncIvKhhpe7ZRysODmLyuZw&s", album.getImageUrl());
//}
//
//
//    // Getters & Setter testing
//	@Test
//	public void testGettersAndSetters() {
//		Album album = new Album();
//
//		album.setTitle("Hello");
//		album.setArtist("Adele");
//		album.setSongCount(12);
//		album.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQs3pFq-3-QyNuZ_BXfPDBR67oJlkNiDXmChRLjYrS8FQ&s");
//
//		// Verify that getters return the updated values
//		assertEquals("Hello", album.getTitle());
//		assertEquals("Adele", album.getArtist());
//		assertEquals(12, album.getSongCount());
//		assertEquals("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQs3pFq-3-QyNuZ_BXfPDBR67oJlkNiDXmChRLjYrS8FQ&s", album.getImageUrl());
//	}
}
