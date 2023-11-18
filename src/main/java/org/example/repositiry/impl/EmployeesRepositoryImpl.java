package org.example.repositiry.impl;

import org.example.config.HibernateUtil;
import org.example.entity.Employees;
import org.example.repositiry.BaseOperationRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


public class EmployeesRepositoryImpl implements BaseOperationRepository<Employees> {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeesRepositoryImpl.class);
     private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Override
    public Employees create(Employees employees) {
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            if (employees != null){
                session.persist(employees);
                transaction.commit();
                return employees;
            }
        } catch (HibernateException e){
            LOGGER.error("Error while saving employees: " + e);
        }
        return null;
    }

    @Override
    public List<Employees> readAll() {
        try (Session session = sessionFactory.openSession()){
            return session.createQuery("FROM Employees", Employees.class).list();
        }
    }

    @Override
    public Employees readById(long id) {
        try (Session session = sessionFactory.openSession()){
            if (checkById(session, id))
                return session.get(Employees.class, id);
        }
        return null;
    }

    @Override
    public Employees update(long id, String position, double salary) {

        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            try {
                transaction = session.beginTransaction();
                if (checkById(session, id)) {
                    Employees employees = session.get(Employees.class, id);
                    employees.setPosition(position);
                    employees.setSalary(salary);
                    session.merge(employees);
                    transaction.commit();
                } else {
                    LOGGER.warn("Employee with id:" + id + " not found");
                }

            } catch (HibernateException e) {
                LOGGER.error("Error during update operation" + e);
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
            }

            return null;
        }
    }

    @Override
    public Employees delete(long id) {
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            try {
                if (checkById(session, id)){
                    Employees employees = session.get(Employees.class, id);
                    session.remove(employees);
                    transaction.commit();
                    return employees;
                } else {
                    LOGGER.warn("Employees id: " + id + " is not found");
                    // Если сотрудник не найден, откатываем транзакцию
                    transaction.rollback();
                }
            } catch (HibernateException e){
                LOGGER.error("Hibernate error during delete operation: " + e);
                // В случае ошибки откатываем транзакцию
                transaction.rollback();
            }
        }
        return null;
    }

    // This method checks if the entity is in the database
    private boolean checkById(Session session, Long employeesId){
            String query = "SELECT COUNT(*) FROM Employees WHERE id = :employeesId";
            Long count = session.createQuery(query, Long.class)
                    .setParameter("employeesId", employeesId)
                    .uniqueResult();
            return count > 0;
    }

    // This method makes sorting by name!
    public List<Employees> sortByName(){
        try (Session session = sessionFactory.openSession()){
           String query = "FROM Employees ORDER BY firstName";
            return session.createQuery(query, Employees.class).list();
        } catch (HibernateException e){
            LOGGER.error("Hibernate error sorting by name: " + e);
        }
        return Collections.emptyList();
    }

    // This method makes sorting by salary!
    public List<Employees> sortBySalary(){
        try (Session session = sessionFactory.openSession()){
            String query = " FROM Employees ORDER BY salary";
            return session.createQuery(query, Employees.class).list();
        } catch (HibernateException e){
            LOGGER.error("Hibernate error sorting by salary: " + e);
        }
        return Collections.emptyList();
    }

}


