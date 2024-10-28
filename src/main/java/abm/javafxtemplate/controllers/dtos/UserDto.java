package abm.javafxtemplate.controllers.dtos;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class UserDto {

    private final SimpleLongProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty email;
    private final SimpleStringProperty mobileNo;

    public UserDto(Long id, String name, String email, String mobileNo) {
        this.id = new SimpleLongProperty(id);
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.mobileNo = new SimpleStringProperty(mobileNo);
    }

    public long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public String getMobileNo() {
        return mobileNo.get();
    }

    public SimpleStringProperty mobileNoProperty() {
        return mobileNo;
    }
}
