module abm.javafxtemplate {
    requires javafx.controls;
    requires javafx.fxml;


    opens abm.javafxtemplate to javafx.fxml;
    exports abm.javafxtemplate;
}