package com.airhacks.services;

import com.airhacks.entities.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vasouv
 */
@Stateless
public class CustomerService {

    @PersistenceContext
    private EntityManager em;

    public void create(Customer customer) {
        em.persist(customer);
    }

    public List<Customer> findAll() {
        return em.createQuery("select c from Customer c").getResultList();
    }

    public Customer findByName(String name) {
        return (Customer) em.createQuery("select c from Customer c where c.name=:cname").setParameter("cname", name).getSingleResult();
    }

}
