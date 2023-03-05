module abm.javafxtemplate {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.data.jpa;
    requires spring.orm;
    requires spring.data.commons;
    requires spring.beans;
    requires spring.core;
    requires spring.jdbc;
    requires spring.context;
    requires java.sql;
    requires org.slf4j;
    requires org.hibernate.orm.core;
    requires spring.tx;
    requires jakarta.persistence;

    opens abm.javafxtemplate to javafx.fxml;
    opens abm.javafxtemplate.config to spring.core, spring.beans,spring.context;
    opens abm.javafxtemplate.dao.entities to org.hibernate.orm.core,spring.core;
    opens abm.javafxtemplate.services to spring.beans;
    exports abm.javafxtemplate;
}