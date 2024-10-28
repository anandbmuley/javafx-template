package abm.javafxtemplate.communication;

import abm.javafxtemplate.controllers.dtos.UserDto;

public class EventData {
    private UserDto userDto;

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
