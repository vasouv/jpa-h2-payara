package com.airhacks.entities;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author vasouv
 */
@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate datePlaced;

    @ManyToOne
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchase", fetch = FetchType.EAGER)
    List<OrderedAlbum> orderedAlbums;

    public Purchase() {
    }

    public Purchase(LocalDate datePlaced, Customer customer, List<OrderedAlbum> orderedAlbums) {
        this.datePlaced = datePlaced;
        this.customer = customer;
        this.orderedAlbums = orderedAlbums;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(LocalDate datePlaced) {
        this.datePlaced = datePlaced;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderedAlbum> getOrderedAlbums() {
        return orderedAlbums;
    }

    public void setOrderedAlbums(List<OrderedAlbum> orderedAlbums) {
        this.orderedAlbums = orderedAlbums;
    }

    @Override
    public String toString() {
        return "Purchase{" + "id=" + id + ", datePlaced=" + datePlaced + ", customer=" + customer + ", orderedAlbums=" + orderedAlbums + '}';
    }

}
