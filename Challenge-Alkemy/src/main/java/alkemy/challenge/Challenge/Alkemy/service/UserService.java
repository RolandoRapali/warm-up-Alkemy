package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.dto.UserDto;
import alkemy.challenge.Challenge.Alkemy.model.UserModel;
import alkemy.challenge.Challenge.Alkemy.repository.IUserRepository;
import alkemy.challenge.Challenge.Alkemy.Converter.UserConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService implements UserDetailsService {

    @Autowired
    @Qualifier("userRepository")
    private IUserRepository userRepository;

    @Autowired
    @Qualifier("userConverter")
    private UserConverter userConverter;


    public List<UserDto> getAll() {
        return userRepository.findAll();
    }


    public UserModel insertOrUpdate(UserModel userModel) {
        UserDto user = userRepository.save(userConverter.modelToEntity(userModel));
        return userConverter.entityToModel(user);
    }


    public boolean remove(int id) {
        try {
            userRepository.findById(id).setEnabled(false);
            return true;
        }catch (Exception e){
            System.out.println("The user doesn't exists" + e.getMessage());
            return false;
        }
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDto user = userRepository.findByEmail(email);
        User.UserBuilder builder = null;

        if(user != null){
            builder = User.withUsername(user.getEmail());
            builder.password(user.getPassword());
            builder.authorities(new SimpleGrantedAuthority("user"));
        }else{
            throw new UsernameNotFoundException("User not found");
        }
    return builder.build();
    }
}
