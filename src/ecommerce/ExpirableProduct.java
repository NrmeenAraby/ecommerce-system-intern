package ecommerce;

import ecommerce.Product;

import java.time.LocalDate;

public class ExpirableProduct extends Product {
    LocalDate expiryDate;
    public ExpirableProduct(String name,double price,long quantity,LocalDate expiryDate){
        super( name,price,quantity);
        this.expiryDate=expiryDate;
    }

   public boolean isExpired(){

        return LocalDate.now().isAfter(expiryDate);
   }

}
