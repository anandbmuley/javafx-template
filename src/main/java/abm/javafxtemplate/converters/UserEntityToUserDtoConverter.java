package abm.javafxtemplate.converters;

import abm.javafxtemplate.controllers.dtos.UserDto;
import abm.javafxtemplate.dao.entities.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserDtoConverter implements Converter<UserEntity, UserDto> {

    @Override
    public UserDto convert(UserEntity source) {
        return new UserDto(source.getId(), source.getName(), source.getEmail(), source.getMobileNo());
    }

}
