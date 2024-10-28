package abm.javafxtemplate.controllers;

import abm.javafxtemplate.communication.AppEvents;
import abm.javafxtemplate.communication.EventData;
import abm.javafxtemplate.components.Modal;
import abm.javafxtemplate.controllers.dtos.UserDto;
import abm.javafxtemplate.services.UserService;
import abm.javafxtemplate.ui.ViewNames;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class UsersController implements Initializable {

    private final UserService userService;
    public TableView<UserDto> usersTable;
    public TableColumn<UserDto, String> nameCol;
    public TableColumn<UserDto, String> emailCol;
    public TableColumn<UserDto, String> mobileCol;
    private Modal addUserModal;
    private ObservableList<UserDto> users;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addUserModal = new Modal("Add User", ViewNames.ADD_USER);

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        mobileCol.setCellValueFactory(new PropertyValueFactory<>("mobileNo"));

        var usersFromDB = userService.getAll();
        users = FXCollections.observableArrayList(usersFromDB);
        usersTable.setItems(users);

        AppEvents.USER_ADDED.addListener(this::addToTable);
    }

    private void addToTable(EventData eventData) {
        users.add(eventData.getUserDto());
    }

    public void showAddUserModal(ActionEvent actionEvent) {
        addUserModal.show();
    }

}
