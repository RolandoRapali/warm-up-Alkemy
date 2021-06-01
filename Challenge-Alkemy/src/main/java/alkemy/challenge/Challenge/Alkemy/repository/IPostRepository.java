package alkemy.challenge.Challenge.Alkemy.repository;

import alkemy.challenge.Challenge.Alkemy.dto.CategoryDto;
import alkemy.challenge.Challenge.Alkemy.dto.PostDto;
import alkemy.challenge.Challenge.Alkemy.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository("postRepository")
public interface IPostRepository extends JpaRepository<PostDto, Serializable> {

    public List<PostDto> findByCategory_CategoryOrderByCreatedAtDesc(String category);

    public List<PostDto> findByTitleAndCategory_CategoryOrderByCreatedAtDesc(String title, String category);

    public List<PostDto> findByTitleOrderByCreatedAtDesc(String title);

    public PostDto findById(int id);

}
