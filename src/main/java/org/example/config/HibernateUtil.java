package org.example.config;
import org.example.entity.Address;
import org.example.entity.Employees;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;


    public static SessionFactory getSessionFactory(){

        // // Проверяем, создана ли уже фабрика сессий
        if (sessionFactory == null){
            try {
                // Если фабрика сессий еще не создана, создаем ее из конфигурации hibernate.properties
                Configuration configuration = getConfiguration();
                configuration.addAnnotatedClass(Employees.class);
                configuration.addAnnotatedClass(Address.class);

                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Throwable e){
                // В случае ошибки при создании фабрики сессий, выводим сообщение об ошибке
                System.err.println("Initial SessionFactory creation failed!" + e);
                // И бросаем исключение, чтобы предотвратить продолжение выполнения программы
                throw new ExceptionInInitializerError(e);
            }
        }
        // Возвращаем фабрику сессий (либо существующую, либо только что созданную)
        return sessionFactory;
    }
    private static Configuration getConfiguration(){
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/mydb");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "123");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
//        configuration.setProperty("hibernate.show_sql", "true");
//        configuration.setProperty("hibernate.format_sql", "true");
        return configuration;
    }

}
