package abm.javafxtemplate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:app-${spring.profiles.active:windows}.properties")
public class AppProperties {

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.user}")
    private String dbUser;

    @Value("${db.password}")
    private String dbPassword;

    @Value("${db.driver}")
    private String dbDriver;

    @Value("${spring.profiles.active:windows}")
    private String activeProfile;

    public String getDbUrl() {
        if (activeProfile.equals("windows")) {
            String workingDirectory = System.getProperty("user.dir");
            return dbUrl.replace("<BASE_PATH>", workingDirectory);
        }
        return dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    @Override
    public String toString() {
        return "AppProperties{" + "dbUrl='" + dbUrl + '\'' + ", dbUser='" + dbUser + '\'' + ", dbPassword='" + dbPassword + '\'' + ", dbDriver='" + dbDriver + '\'' + '}';
    }
}
