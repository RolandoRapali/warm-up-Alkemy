package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.dto.PostDto;
import alkemy.challenge.Challenge.Alkemy.model.PostModel;
import alkemy.challenge.Challenge.Alkemy.repository.IPostRepository;
import alkemy.challenge.Challenge.Alkemy.Converter.PostConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("postService")
public class PostService {

    @Autowired
    @Qualifier("postRepository")
    private IPostRepository postRepository;

    @Autowired
    @Qualifier("postConverter")
    private PostConverter postConverter;


    public List<PostDto> getAll() {
        return postRepository.findAll();
    }


    public List<PostDto> findByTitleAndCategory_CategoryOrderByCreatedAtDesc(String title, String category) {
        return postRepository.findByTitleAndCategory_CategoryOrderByCreatedAtDesc(title, category);
    }


    public PostDto findById(int id) {
        return postRepository.findById(id);
    }


    public List<PostDto> findByTitleOrderByCreatedAtDesc(String title) {
        return postRepository.findByTitleOrderByCreatedAtDesc(title);
    }


    public List<PostDto> findByCategory_CategoryOrderByCreatedAtDesc(String category) {
        return postRepository.findByCategory_CategoryOrderByCreatedAtDesc(category);
    }


    public PostModel insertOrUpdate(PostModel postModel) {
        PostDto post = postRepository.save(postConverter.modelToEntity(postModel));
        return postConverter.entityToModel(post);
    }


    public boolean remove(int id) {
        try {
            PostDto post = postRepository.findById(id);
            post.setEnabled(false);
            postRepository.save(post);
            return true;
        } catch (Exception e) {
            System.out.println("Sorry but it was an error " + e.getMessage());
            return false;
        }
    }

}
