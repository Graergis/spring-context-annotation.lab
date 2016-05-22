package org.shop;

import org.shop.api.SellerService;
import org.shop.data.Seller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The Seller Initializer util class.
 */
public class SellerInitializer {

    /** The seller service. */
    private final SellerService sellerService;
    
    /** The seller names. */
    private final Map<Long, String> sellerNames;

    public SellerInitializer(SellerService sellerService, Map<Long, String> sellerNames) {
        this.sellerService = sellerService;
        this.sellerNames = sellerNames;
    }

    /**
     * Inits the sellers.
     */
    public void initSellers() {
        List<Seller> sellers = new LinkedList<Seller>();
        
        for (Map.Entry<Long, String> entry : sellerNames.entrySet()) {
            Seller seller = new Seller();
            seller.setId(entry.getKey());
            seller.setName(entry.getValue());
            
            sellers.add(seller);
        }
        
        sellerService.importSellers(sellers);
    }
}
