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
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raczn
 */
public class Basket {

    private HashMap<Product, Integer> cart;
    private final String baseFilename;
    int totalCost;

    public class BasketException extends Exception {

        public BasketException(String errorMessage) {
            super(errorMessage);
        }
    }

    Basket(String _baseFilename) throws IOException {
        this.cart = new HashMap<>();
        this.baseFilename = _baseFilename;
        totalCost = 0;
        init();
    }

    //load unpaid product from file
    private void init() throws IOException {

        cart = new HashMap<Product, Integer>();

        BufferedReader readed = null;
        try {
            readed = new BufferedReader(new FileReader(baseFilename));

            //storeage lines as strings
            String contentLine;

            while ((contentLine = readed.readLine()) != null) {
                String[] productArr = contentLine.split(",", 6);
                Product key = new Product();
                key.setName(productArr[0]);
                key.setPackaging(productArr[1]);
                key.setPrice(Integer.parseInt(productArr[2]));
                key.setType(productArr[3]);
                key.setIn_stock(Integer.parseInt(productArr[4]));
                Integer count = (Integer.parseInt(productArr[5]));
                if (cart.containsKey(key)) {
                    cart.put(key, cart.get(key) + count);
                } else {
                    cart.put(key, count);
                }

            }
            if (cart.isEmpty()) {

                System.out.println("Your cart is empty");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);

        }
        readed.close();

    }

    public HashMap<Product, Integer> getCart() {
        return cart;
    }

    public void addProductToBasket(Product product, int amount) throws BasketException, IOException {
        if (product == null) {
            throw new BasketException("You cannot add null object to the basket!");
        } else if (amount > product.getIn_stock()) {
            throw new BasketException("You cannot add more amount then the stock, there is only:"
                    + product.getIn_stock() + " amount in there.");

        } else if (!cart.containsKey(product)) {
            cart.put(product, 1);
        } else if (cart.containsKey(product)) {
            cart.put(product, cart.get(product) + amount);

        }

        saveBasket();
    }

    public int calculateTotal() {

        totalCost = 0;
        cart.forEach(
                (key, value)
                -> totalCost += key.getPrice() * value);

        return totalCost;
    }

    

    public void deleteFromBasket(Product product, int amount) throws BasketException, IOException {
        if (cart.get(product) > amount) {
            cart.replace(product, cart.get(product) - amount);

        } else if (cart.get(product) == amount) {
            cart.remove(product);
        } else {
            throw new BasketException("Cannot remove " + amount + " products there are/is just " + cart.get(product) + " of them");
        }
        System.out.println("Product is succesfully deleted from the basket");
        saveBasket();

    }

    private void saveBasket() throws IOException {

        FileWriter output = new FileWriter(baseFilename);

        Iterator cartIterator = cart.entrySet().iterator();
        while (cartIterator.hasNext()) {
            HashMap.Entry cartElement = (HashMap.Entry) cartIterator.next();
            int amounts = ((int) cartElement.getValue());
            output.write(cartElement.getKey() + "," + amounts + System.getProperty("line.separator"));

        }

        if (cart.isEmpty()) {
            System.out.println("Your cart is empty");
        }

        output.close();
        System.out.println("Basket.txt has been updated sucessfully");

    }

    public int sizeOfBasket() {
        int size = 0;
        Iterator cartIterator = cart.entrySet().iterator();
        while (cartIterator.hasNext()) {
            HashMap.Entry cartElement = (HashMap.Entry) cartIterator.next();
            size++;

        }
        System.out.println(size);
        return size;
    }

    public void deleteBasket() throws IOException {

        cart.clear();
        saveBasket();
    }

}
