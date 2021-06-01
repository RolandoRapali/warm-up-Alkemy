package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.dto.PostDto;
import alkemy.challenge.Challenge.Alkemy.model.PostModel;
//import alkemy.challenge.Challenge.Alkemy.service.IPostService;
import alkemy.challenge.Challenge.Alkemy.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    @Qualifier("postService")
    private PostService postService;


    @GetMapping()
    public List<PostDto> listPostsByTitle(@RequestParam(name = "title", required = false) String title, @RequestParam(name = "category", required = false) String category) {
        List<PostDto> posts = null;
        if (title != null && category != null) {
            posts = postService.findByTitleAndCategory_CategoryOrderByCreatedAtDesc(title, category);
        } else if (title != null) {
            posts = postService.findByTitleOrderByCreatedAtDesc(title);
        } else if (category != null) {
            posts = postService.findByCategory_CategoryOrderByCreatedAtDesc(category);
        } else if (posts == null) {
            posts = postService.getAll();
        }
        return posts;
    }

    @GetMapping("/{id}")
    public PostDto bringId(@PathVariable("id") int id) {
        return postService.findById(id);
    }


    @PostMapping("")
    public PostModel newPost(@RequestBody PostModel postModel) {
        return postService.insertOrUpdate(postModel);
    }

    @PostMapping("/{id}")
    public PostModel editPost(@RequestBody PostModel postModel){
        return postService.insertOrUpdate(postModel);
    }


    @DeleteMapping("/{id}")
    public boolean deletePost(@PathVariable("id") int id) {
        return postService.remove(id);
    }


}
