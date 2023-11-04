package abm.javafxtemplate.config;

import abm.javafxtemplate.factories.DaoFactory;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories(basePackages = "abm.javafxtemplate.dao")
@ComponentScan("abm.javafxtemplate")
public class ApplicationConfig {

    @Bean
    public DataSource dataSource(AppProperties appProperties) {
        DriverManagerDataSource driverManagerDataSource = DaoFactory.getInstance();
        driverManagerDataSource.setUrl(appProperties.getDbUrl());
        driverManagerDataSource.setUsername(appProperties.getDbUser());
        driverManagerDataSource.setPassword(appProperties.getDbPassword());
        driverManagerDataSource.setDriverClassName(appProperties.getDbDriver());
        return driverManagerDataSource;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(AppProperties appProperties) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("abm.javafxtemplate.dao.entities");
        factory.setDataSource(dataSource(appProperties));
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

}

