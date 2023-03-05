package abm.javafxtemplate.factories;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public interface DaoFactory {

    static DriverManagerDataSource getInstance() {
        return new DriverManagerDataSource();
    }

}
