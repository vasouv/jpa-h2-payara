package com.airhacks.startup;

import com.airhacks.entities.Album;
import com.airhacks.entities.Customer;
import com.airhacks.entities.OrderedAlbum;
import com.airhacks.services.AlbumService;
import com.airhacks.services.CustomerService;
import com.airhacks.services.StockService;
import com.airhacks.entities.Purchase;
import com.airhacks.services.PurchaseService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 *
 * @author vasouv
 */
@Startup
@Singleton
public class InitializerBean {
    
    @Inject
    private CustomerService customerService;
    
    @Inject
    private AlbumService albumService;
    
    @Inject
    private StockService stockService;
    
    @Inject
    private PurchaseService purchaseService;
    
    @PostConstruct
    public void init() {
        
        //Creating and persisting albums
        Album jomsviking = new Album("Jomsviking");
        Album firepower = new Album("Firepower");
        Album incorruptible = new Album("Incorruptible");
        
        albumService.create(jomsviking);
        albumService.create(firepower);
        albumService.create(incorruptible);
        
        //Creating and persisting customers
        Customer vasouv = new Customer("vasouv");
        Customer john = new Customer("john");
        
        customerService.create(vasouv);
        customerService.create(john);
        
        //Creating and persisting stock for albums
        stockService.create(jomsviking.getTitle(), 5);
        stockService.create(firepower.getTitle(), 7);
        stockService.create(incorruptible.getTitle(), 3);
        
        //Ordered albums for vasouv
        OrderedAlbum v1 = new OrderedAlbum(2, firepower);
        OrderedAlbum v2 = new OrderedAlbum(1, incorruptible);
        List<OrderedAlbum> forVasouv = new ArrayList<>();
        forVasouv.add(v1);
        forVasouv.add(v2);
        
        //Purchase for vasouv
        Purchase pVasouv = new Purchase(LocalDate.now(), vasouv, forVasouv);
        
        //Ordered albums for john
        OrderedAlbum j1 = new OrderedAlbum(2, firepower);
        OrderedAlbum j2 = new OrderedAlbum(3, jomsviking);
        OrderedAlbum j3 = new OrderedAlbum(5, incorruptible);
        List<OrderedAlbum> forJohn = new ArrayList<>();
        forJohn.add(j1);
        forJohn.add(j2);
        forJohn.add(j3);
        
        //Purchase for john
        Purchase pJohn = new Purchase(LocalDate.now(), john, forJohn);
        
        //Persists purchases
        purchaseService.create(pVasouv);
        purchaseService.create(pJohn);
        
        //New orderd albums for vasouv
        OrderedAlbum v3 = new OrderedAlbum(3, jomsviking);
        OrderedAlbum v4 = new OrderedAlbum(2, incorruptible);
        OrderedAlbum v5 = new OrderedAlbum(1, firepower);
        List<OrderedAlbum> forVasouvAgain = new ArrayList<>();
        forVasouvAgain.add(v3);
        forVasouvAgain.add(v4);
        forVasouvAgain.add(v5);
        
        //New purchase persistence
        Purchase newVasouv = new Purchase(LocalDate.now(), vasouv, forVasouvAgain);
        purchaseService.create(newVasouv);
        
    }
    

}
