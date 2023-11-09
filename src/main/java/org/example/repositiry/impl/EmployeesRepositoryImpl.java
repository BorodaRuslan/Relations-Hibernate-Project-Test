package org.example.repositiry.impl;

import org.example.config.HibernateUtil;
import org.example.entity.Employees;
import org.example.repositiry.BaseOperationRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class EmployeesRepositoryImpl implements BaseOperationRepository<Employees> {

    // ToDo -> You need to user Logger!
    @Override
    public Employees create(Employees employees) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            if (employees != null){
                session.persist(employees);
                transaction.commit();
                return employees;
            }
        } catch (Exception e){
            System.out.println("Error while saving employees: " + e);
        }
        return null;
    }

    @Override
    public List<Employees> readAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            String query = "FROM Employees";
            List<Employees> employeesList = session.createQuery(query, Employees.class).list();
            transaction.commit();
            return employeesList;
        }
    }

    @Override
    public Employees readById(long id) {
        return new Employees();
    }

    @Override
    public Employees update(long id) {
        return new Employees();
    }

    @Override
    public Employees delete(long id) {
        return new Employees();
    }
}
