package com.alexberemart.nbaquickstats.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.alexberemart.nbaquickstats.repository",
        entityManagerFactoryRef = "entityManager",
        transactionManagerRef = "transactionManager"
)
public class nbaQuickStatsConfig {

    @Value("${quotecenterssff.hibernate.hbm2ddl.auto}")
    String hibernateHbm2ddlAuto;

    @Value("${quotecenterssff.hibernate.dialect}")
    String hibernateDialect;

    @Value("${quotecenterssff.datasource.driver}")
    String driver;

    @Value("${quotecenterssff.datasource.url}")
    String url;

    @Value("${quotecenterssff.datasource.db.username}")
    String user;

    @Value("${quotecenterssff.datasource.db.password}")
    String password;

    @Value("${server.port}")
    int port;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.alexberemart.nbaquickstats.model");

        HibernateJpaVendorAdapter cemeteryAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(cemeteryAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", true);
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager().getObject());
        return transactionManager;
    }
}