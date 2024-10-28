package abm.javafxtemplate.services;

import abm.javafxtemplate.controllers.dtos.UserDto;
import abm.javafxtemplate.dao.entities.UserEntity;
import abm.javafxtemplate.dao.repositories.UserRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ConversionService conversionService;

    public UserService(UserRepository userRepository, ConversionService conversionService) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
    }

    public UserDto save(UserEntity userEntity) {
        var savedEntity = userRepository.save(userEntity);
        return conversionService.convert(savedEntity, UserDto.class);
    }

    public List<UserDto> getAll() {
        var userEntitiesIterator = userRepository.findAll().iterator();
        var userDtos = new ArrayList<UserDto>();
        while (userEntitiesIterator.hasNext()) {
            var userDto = conversionService.convert(userEntitiesIterator.next(), UserDto.class);
            userDtos.add(userDto);
        }
        return userDtos;
    }
}
