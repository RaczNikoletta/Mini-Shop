/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raczn
 */
public class WishList {

    private ArrayList<Product> wishList;
    private final String baseFilename;

    public class WishListException extends Exception {

        public WishListException(String errorMessage) {
            super(errorMessage);
        }

    }

    WishList(String _baseFilename) throws IOException {

        this.baseFilename = _baseFilename;
        wishList = new ArrayList<>();
        Product p= null;
        init();
    }

    private void init() throws IOException {
       
        BufferedReader readed=null;
        try {
            readed = new BufferedReader(new FileReader(baseFilename));

            //storeage lines as strings
            String contentLine;
            boolean exists = false;
            while ((contentLine = readed.readLine()) != null) {
                Product p = new Product(contentLine);
                //contains is not usable 
                {
                    for (Product prod : wishList) {
                        if (prod.getName().equals(p.getName())) {
                            exists = true;
                        }
                    }
                    if (exists == true) {
                        exists = false;
                    } else {
                        wishList.add(p);
                    }

                }

            }

            if (wishList.isEmpty()) {

                System.out.println("Your whislist is empty");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);

        }
        saveWishList();

    }

    private void saveWishList() throws IOException {

        FileWriter output = new FileWriter(baseFilename);
        if (!wishList.isEmpty()) {
            for (Product prod : wishList) {
                output.write(prod + System.getProperty("line.separator"));

            }
        } else {
            System.out.println("Your wishlist is empty");
        }

        output.close();
        System.out.println("wishlist.txt has been updated sucessfully");

    }

    public void addProductToWishList(Product product) throws Basket.BasketException, IOException, WishListException {
        if (product == null) {
            throw new WishListException("You cannot add null object to the basket!");
        } else if (!wishList.contains(product)) {
            wishList.add(product);
        } else if (wishList.contains(product)) {
            throw new WishListException("You already have this product in your wishlist!");

        }

        saveWishList();
    }

    public void deleteFromWishList(String productName) throws WishListException, IOException {

        // with iterator to avoid concurrentModificationException
        for (Iterator<Product> iterator = wishList.iterator(); iterator.hasNext();) {
            Product prod = iterator.next();
            if (prod.getName() == productName) {
                iterator.remove();
            }
        }
        saveWishList();
        System.out.println("The product is succesfully deleted from the wishlist");

    }

    public ArrayList<String> getWishNames() throws WishListException {

        ArrayList<String> names = new ArrayList<>();
        for (Product prod : wishList) {
            names.add(prod.getName());

        }
        return names;
    }

}
