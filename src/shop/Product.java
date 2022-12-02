/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

/**
 *
 * @author raczn
 */
public class Product {

    private String name, packaging, type;
    private int price,in_stock;
    
    
    //setters for basket class
    public void setName(String name) {
        this.name = name;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setIn_stock(int in_stock) {
        this.in_stock = in_stock;
    }

    public Product(String product) {
        String[] productArr = product.split(",",5);
        this.name = productArr[0];
        this.packaging = productArr[1];
        this.price = Integer.parseInt(productArr[2]);
        this.type = productArr[3];
        this.in_stock = Integer.parseInt(productArr[4]);

    }

    public Product() {

        name = "";
        packaging = "";
        price = 0;
        type = "";
        in_stock = 0;
    }

    public String getName() {
        return name;
    }

    public String getPackaging() {
        return packaging;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public Integer getIn_stock() {
        return in_stock;
    }


    
    public String toString() {
        //because of the ouput for the  costumer we don't write the stock
        return name + "," + packaging + "," + price + "," + type+ ","+ in_stock;
    }
    
   
    
    public void updateIn_Stock(int amount)
    {
        this.in_stock-=amount;
        
    }


}
