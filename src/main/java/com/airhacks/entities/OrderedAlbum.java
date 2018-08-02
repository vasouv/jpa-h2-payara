package com.airhacks.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author vasouv
 */
@Entity
public class OrderedAlbum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne
    private Album album;

    @ManyToOne
    private Purchase purchase;

    public OrderedAlbum() {
    }

    public OrderedAlbum(int quantity, Album album, Purchase purchase) {
        this.quantity = quantity;
        this.album = album;
        this.purchase = purchase;
    }
    
    public OrderedAlbum(int quantity, Album album) {
        this.quantity = quantity;
        this.album = album;
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public String toString() {
        return "OrderedAlbum{" + "id=" + id + ", quantity=" + quantity + ", album=" + album + ", purchase=" + purchase + '}';
    }

}
