package com.airhacks;

import com.airhacks.entities.Album;
import com.airhacks.entities.Customer;
import com.airhacks.entities.Purchase;
import com.airhacks.entities.Stock;
import com.airhacks.services.AlbumService;
import com.airhacks.services.CustomerService;
import com.airhacks.services.PurchaseService;
import com.airhacks.services.StockService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
@Produces(MediaType.APPLICATION_JSON)
public class PingResource {

    @Inject
    private CustomerService customerService;

    @Inject
    private AlbumService albumService;

    @Inject
    private StockService stockService;

    @Inject
    private PurchaseService purchaseService;

    @GET
    @Path("customers")
    public Response allCustomers() {
        List<Customer> customers = customerService.findAll();
        GenericEntity<List<Customer>> list = new GenericEntity<List<Customer>>(customers) {
        };
        return Response.ok(list).build();
    }

    @GET
    @Path("albums")
    public List<Album> allAlbums() {
        List<Album> albums = albumService.findAll();
        return albums;
    }

    @GET
    @Path("stock")
    public List<Stock> allStock() {
        List<Stock> stock = stockService.findAll();
        return stock;
    }

    @GET
    @Path("purchases")
    public List<Purchase> allPurchases() {
        List<Purchase> purchases = purchaseService.findAll();
        return purchases;
    }

    @GET
    @Path("purchases/1")
    public Purchase firstPurchase() {
        Purchase first = purchaseService.first();
        return first;
    }

    @GET
    @Path("purchases/vasouv")
    public List<Purchase> vasouv() {
        List<Purchase> vasouv = purchaseService.vasouv();
        return vasouv;
    }

}
