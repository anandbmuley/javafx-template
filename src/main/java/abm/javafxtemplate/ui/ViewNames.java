package abm.javafxtemplate.ui;

import abm.javafxtemplate.SampleApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public enum ViewNames {

    APP("app.fxml"),
    ADD_USER("add-user.fxml");

    private final String filename;

    ViewNames(String filename) {
        this.filename = filename;
    }

    public Parent load() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(filename));
            fxmlLoader.setControllerFactory(SampleApp.applicationContext::getBean);
            return fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
