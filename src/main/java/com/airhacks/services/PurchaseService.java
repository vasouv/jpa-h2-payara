package com.airhacks.services;

import com.airhacks.entities.Customer;
import com.airhacks.entities.OrderedAlbum;
import com.airhacks.entities.Purchase;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vasouv
 */
@Stateless
public class PurchaseService {

    @PersistenceContext
    private EntityManager em;

    public void create(Purchase toPlace) {
        em.persist(toPlace);
    }

    public List<Purchase> findAll() {
        return em.createQuery("select p from Purchase p").getResultList();
    }

    public Purchase first() {
        return em.find(Purchase.class, 1L);
    }

    public List<Purchase> vasouv() {
        return em.createQuery("select p from Purchase p where p.customer.name=:cname").setParameter("cname", "vasouv").getResultList();
    }

}
