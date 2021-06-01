package alkemy.challenge.Challenge.Alkemy.Converter;

import alkemy.challenge.Challenge.Alkemy.dto.CategoryDto;
import alkemy.challenge.Challenge.Alkemy.model.CategoryModel;
import org.springframework.stereotype.Component;

@Component("categoryConverter")
public class CategoryConverter {

    public CategoryModel entityToModel(CategoryDto category){
        return new CategoryModel(category.getId(), category.getCategory());
    }

    public CategoryDto modelToEntity(CategoryModel categoryModel){
        return new CategoryDto(categoryModel.getCategory());
    }
}
