package abm.javafxtemplate.controllers;

import abm.javafxtemplate.communication.AppEvents;
import abm.javafxtemplate.communication.EventData;
import abm.javafxtemplate.dao.entities.UserEntity;
import abm.javafxtemplate.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class AddUserController implements Initializable {

    private final UserService userService;
    public Label successMessage;
    public Label errorMessage;
    public TextField name;
    public TextField email;
    public TextField mobileNo;

    public AddUserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hideMessages();
    }

    private void hideMessages() {
        successMessage.setVisible(false);
        errorMessage.setVisible(false);
    }

    public void handleOnSave(ActionEvent actionEvent) {
        try {
            UserEntity userEntity = new UserEntity(name.getText(), email.getText(), mobileNo.getText());
            var savedDto = userService.save(userEntity);
            EventData eventData = new EventData();
            eventData.setUserDto(savedDto);
            AppEvents.USER_ADDED.dispatch(eventData);
            showSuccessMessage();
        } catch (Exception e) {
            showError();
        }
    }

    private void showSuccessMessage() {
        successMessage.setVisible(true);
    }

    private void showError() {
        errorMessage.setVisible(true);
    }


}
