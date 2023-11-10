package org.example.repositiry.impl;

import org.example.config.HibernateUtil;
import org.example.entity.Address;
import org.example.repositiry.BaseOperationRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AddressRepositoryImpl implements BaseOperationRepository<Address> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressRepositoryImpl.class);
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Address create(Address entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            if (entity != null){
                session.persist(entity);
                transaction.commit();
            } else
                LOGGER.warn("User save address");

        } catch (HibernateException e){
            LOGGER.error("Error while saving address: " + e);
            if (transaction != null && transaction.isActive())
                transaction.rollback();
        }
        return null;
    }

    @Override
    public List<Address> readAll() {
        try ( Session session = sessionFactory.openSession()){
            return session.createQuery("FROM Address", Address.class).list();
        }
    }

    @Override
    public Address readById(long id) {
        try (Session session = sessionFactory.openSession()) {
            if (checkById(session, id))
                return session.get(Address.class, id);
            else
                LOGGER.warn("Address id: " + id + "is not found");
            return null;
        }

    }

    @Override
    public Address update(long id, String position, double salary) {
        return null;
    }

    @Override
    public Address delete(long id) {
       Transaction transaction = null;
        try ( Session session = sessionFactory.openSession()){
            if (checkById(session, id)){
                transaction = session.beginTransaction();

                Address address = session.get(Address.class, id);
                session.remove(address);
                transaction.commit();
                return address;
            } else
                LOGGER.warn("Address id: " + id + "is not found");
        } catch (HibernateException e){
            LOGGER.error("Hibernate error during delete operation:" + e);
            if (transaction != null && transaction.isActive())
                transaction.rollback();
        }
        return null;
    }

    private boolean checkById(Session session, long addressId){
        String query = "SELECT COUNT(*) FROM Employees WHERE id = :addressId";
         Long count = session.createQuery(query, Long.class)
                 .setParameter("addressId", addressId)
                 .uniqueResult();
         return count > 0;

    }
}
