
import com.example.songr.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumJpa extends JpaRepository<Album,Long> {


}