package abm.javafxtemplate;

import abm.javafxtemplate.dao.entities.UserEntity;
import abm.javafxtemplate.services.UserService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public TextField name;
    public Label successMessage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showSuccessMessage(false);
    }

    private void showSuccessMessage(boolean isVisible) {
        successMessage.setManaged(isVisible);
        successMessage.setVisible(isVisible);
    }

    @FXML
    protected void handleOnSave() {
        showSuccessMessage(false);
        var userEntity = new UserEntity(name.getText());
        SampleApp.applicationContext.getBean(UserService.class).save(userEntity);
        name.clear();
        showSuccessMessage(true);
    }
}