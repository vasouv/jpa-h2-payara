package com.airhacks.services;

import com.airhacks.entities.Album;
import com.airhacks.entities.Stock;
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
public class StockService {

    @Inject
    private AlbumService albumService;

    @PersistenceContext
    private EntityManager em;

    public void create(String albumTitle, int stock) {
        Album found = albumService.findByTitle(albumTitle);
        Stock forFound = new Stock(stock, found);
        em.persist(forFound);
    }

    public void create(Long albumID, int stock) {
        Album found = albumService.findByID(albumID);
        Stock forFound = new Stock(stock, found);
        em.persist(forFound);
    }

    public List<Stock> findAll() {
        return em.createQuery("select s from Stock s").getResultList();
    }

}
