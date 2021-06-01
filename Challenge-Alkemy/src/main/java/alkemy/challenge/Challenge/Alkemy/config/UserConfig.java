package alkemy.challenge.Challenge.Alkemy.config;

import alkemy.challenge.Challenge.Alkemy.dto.CategoryDto;
import alkemy.challenge.Challenge.Alkemy.dto.PostDto;
import alkemy.challenge.Challenge.Alkemy.dto.UserDto;
import alkemy.challenge.Challenge.Alkemy.repository.ICategoryRepository;
import alkemy.challenge.Challenge.Alkemy.repository.IPostRepository;
import alkemy.challenge.Challenge.Alkemy.repository.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(IPostRepository postRepository, IUserRepository userRepository, ICategoryRepository categoryRepository) {
        return args -> {
            UserDto rolando = new UserDto("rolando@ra.com","asd");
            UserDto pablo = new UserDto("pablo@ra.com","ds");
            UserDto pedro = new UserDto("pedro@ra.com","fsa");
            userRepository.saveAll(List.of(rolando, pablo, pedro));

            CategoryDto food = new CategoryDto("food");
            CategoryDto dogs = new CategoryDto("dogs");
            CategoryDto cats = new CategoryDto("cats");
            categoryRepository.saveAll(List.of(food,dogs,cats));


            PostDto entry1 = new PostDto("entry1", "smh about food", "", food,1, LocalDate.of(2019,6,8));
            PostDto entry2 = new PostDto("entry2", "cats", "", dogs,1,  LocalDate.of(2021,8,8));
            PostDto entry3 = new PostDto("entry3", "dogs", "", cats,1,  LocalDate.of(2021,2,8));
            postRepository.saveAll(List.of(entry1, entry2, entry3));

        };
    }

}
