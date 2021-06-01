package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.dto.CategoryDto;
import alkemy.challenge.Challenge.Alkemy.model.CategoryModel;
import alkemy.challenge.Challenge.Alkemy.repository.ICategoryRepository;
import alkemy.challenge.Challenge.Alkemy.Converter.CategoryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryService {

    @Autowired
    @Qualifier("categoryRepository")
    private ICategoryRepository categoryRepository;

    @Autowired
    @Qualifier("categoryConverter")
    private CategoryConverter categoryConverter;


    public List<CategoryDto> getAll() {
        return categoryRepository.findAll();
    }


    public CategoryModel insertOrUpdate(CategoryModel categoryModel) {
        CategoryDto category = categoryRepository.save(categoryConverter.modelToEntity(categoryModel));
        return categoryConverter.entityToModel(category);
    }
}
