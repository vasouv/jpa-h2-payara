package com.airhacks.services;

import com.airhacks.entities.Album;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vasouv
 */
@Stateless
public class AlbumService {

    @PersistenceContext
    private EntityManager em;

    public void create(Album album) {
        em.persist(album);
    }

    public Album findByID(Long id) {
        return em.find(Album.class, id);
    }

    public Album findByTitle(String title) {
        return (Album) em.createQuery("select a from Album a where a.title=:title").setParameter("title", title).getSingleResult();
    }

    public List<Album> findAll() {
        return em.createQuery("select a from Album a").getResultList();
    }

}
