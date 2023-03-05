package abm.javafxtemplate.services;

import abm.javafxtemplate.dao.entities.UserEntity;
import abm.javafxtemplate.dao.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }


}
