package org.xmobots.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.xmobots.DTO.Aerodrome;
import org.xmobots.DTO.Runways;

import java.util.Properties;

public class HibernateUtils {
    private static final SessionFactory sessionFactory;
    static {
        try{
            Properties props = new Properties();
            props.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            props.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/xmobots_test");
            props.setProperty("hibernate.connection.username", "postgres");
            props.setProperty("hibernate.connection.password", "admin");
            props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            props.setProperty("hibernate.show_sql", "true");

            Configuration configuration = new Configuration();
            configuration.setProperties(props);
            configuration.setProperty("hibernate.hbm2ddl.auto", "create");
            configuration.addAnnotatedClass(Aerodrome.class);
            configuration.addAnnotatedClass(Runways.class);

            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e){
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
