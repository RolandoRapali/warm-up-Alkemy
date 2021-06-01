package alkemy.challenge.Challenge.Alkemy.Converter;

import alkemy.challenge.Challenge.Alkemy.dto.UserDto;
import alkemy.challenge.Challenge.Alkemy.model.UserModel;

import org.springframework.stereotype.Component;

@Component("userConverter")
public class UserConverter {

    public UserModel entityToModel (UserDto user){
        return new UserModel(user.getId(), user.getEmail(), user.getPassword());
    }

    public UserDto modelToEntity (UserModel userModel){
        return new UserDto(userModel.getEmail(), userModel.getPassword());
    }

}
