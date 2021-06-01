package alkemy.challenge.Challenge.Alkemy.Converter;

import alkemy.challenge.Challenge.Alkemy.dto.CategoryDto;
import alkemy.challenge.Challenge.Alkemy.dto.PostDto;
import alkemy.challenge.Challenge.Alkemy.model.CategoryModel;
import alkemy.challenge.Challenge.Alkemy.model.PostModel;
import org.springframework.stereotype.Component;

@Component("postConverter")
public class PostConverter {

    public PostModel entityToModel(PostDto post) {
        return new PostModel(post.getId(), post.getTitle(), post.getImage(), new CategoryModel(post.getCategoryModel().getId() , post.getCategoryModel().getCategory()), post.getId(), post.getCreatedAt());
    }

    public PostDto modelToEntity(PostModel postModel) {
        return new PostDto(postModel.getTitle(), postModel.getContent(), postModel.getImage(), new CategoryDto(postModel.getCategoryModel().getCategory()), postModel.getId(), postModel.getCreatedAt());
    }
}
