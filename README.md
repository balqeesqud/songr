# Songr Application

This is a simple web application called "Songer" that allows users to view album information and create custom
hello messages.

## Prerequisites

- Java Development Kit (JDK) 17 or higher
- Gradle (for building the project)

## Dependencies

- Spring Boot DevTools
- Thymeleaf (for rendering HTML templates)
- Gradle (for project management)
- Spring MVC
- Database Relationships (@OneToMany and @ManyToOne Relationships) 

## Methods Used

### Create Album (POST)

To create a new album, we have implemented a `createAlbum` method in the `AlbumController` class. This method is
mapped to the `/create-album` endpoint and accepts the following parameters:

- `title`: The title of the album.
- `artist`: The artist of the album.
- `imageUrl`: The URL of the album's cover image.
- `songCount`: The number of songs in the album.
- `length`: The length of the album in seconds.

Here's an overview of how it works:
1. When a user submits the album creation form, this method is invoked.
2. It creates a new `Album` object with the provided data.
3. The `Album` object is saved to the database using JPA repository.

### Get All Albums (GET)

To retrieve a list of all albums, we have implemented a `getAlbums` method in the `AlbumController` class.
This method is mapped to the `/allAlbums` endpoint and accepts a `Model` object for rendering the data in a view.

Here's how it works:
1. When a user accesses the "All Albums" page, this method is called.
2. It fetches all albums from the database using the JPA repository.
3. The list of albums is added to the `Model` for rendering in the HTML view.

### Delete Album by ID (DELETE)

To delete an album by its ID, we have implemented a `deleteAlbumById` method in the `AlbumController` class.
This method is mapped to a `DELETE` request with a dynamic path variable for the `albumId` parameter.

Here's an overview of how it works:
1. When a user clicks the "Delete Album" button next to an album on the "All Albums" page, this method is triggered.
2. It deletes the album with the specified `albumId` from the database using the JPA repository.

These methods enable the basic CRUD (Create, Read, Update, Delete) operations for managing albums in our web
application.

### Update an album title

To update an album's title, we have implemented a `updateAlbum` method in the `AlbumController` class
This method is mapped to a `PUT` request with a dynamic path variable for the `albumId` parameter.

### @OneToMany and @ManyToOne Relationships

  -  @OneToMany(mappedBy = "song", cascade = CascadeType.ALL) in the Album class indicates a one-to-many relationship
     between Album and Song. Each album can have multiple songs, and the song field in the Song entity maps this
     relationship.

  -  @ManyToOne in the Song class indicates a many-to-one relationship between Song and Album. Each song belongs to
     single album, and the song field is the mapped side of the relationship. 

### Adding Songs to an Album

To add songs to an existing album, find the album you want to add songs to on the homepage and use the "Add a song to
this Album" form. Enter the song's title, track number, and length in seconds.

### Viewing Albums and Songs

You can view all albums and their details, including songs, on the homepage. Albums are listed along with their titles,
artists, lengths, song counts, and image URLs. Clicking on an album will expand it to show its songs.

## Run application

1. **Clone the Repository**

   ```bash
   git clone https://github.com/balqeesqud/songr.git

2. **Build the Project**
   ```bash
   cd Songer

3. **Build the project using Maven**
   ```bash
   mvn clean install

4. Start the Spring Boot Application
    ```bash
   mvn spring-boot:run


application will start on port 8080 by default. It can be accessed using web browser at http://localhost:8080.



