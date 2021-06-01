package alkemy.challenge.Challenge.Alkemy.repository;

import alkemy.challenge.Challenge.Alkemy.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<UserDto, Serializable> {

    public UserDto findById(int id);

    public UserDto findByEmail(String email);

}
