package abm.javafxtemplate.components;

import abm.javafxtemplate.ui.ViewNames;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.function.Consumer;

public class Modal {

    private Stage stage;
    private Parent root;

    public Modal(String title, ViewNames viewNames) {
        root = viewNames.load();
        stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
    }

    public void show() {
        stage.show();
    }

    public void hide() {
        stage.hide();
    }

    public void setOnClose(Consumer<WindowEvent> onCloseAction) {
        stage.setOnCloseRequest(onCloseAction::accept);
    }
}
