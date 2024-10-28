package abm.javafxtemplate;

import abm.javafxtemplate.factories.SpringContextLoader;
import abm.javafxtemplate.ui.ViewNames;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class SampleApp extends Application {

    public static AnnotationConfigApplicationContext applicationContext;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception {
        super.init();
        applicationContext = SpringContextLoader.getInstance();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent parent = ViewNames.APP.load();
        Scene scene = new Scene(parent, 1024, 768);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}