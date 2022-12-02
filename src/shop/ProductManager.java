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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raczn
 */
public class ProductManager {

    private final String baseFilename;
    private ArrayList<Product> products;



    public class ProductManagerException extends Exception
    {
            public ProductManagerException(String errorMessage)
            {
                super(errorMessage);
            }
    }

    public ProductManager(String filename) {
        this.baseFilename = filename;
        //initalize the arraylist
        init();

    }

    private void init() {

        products = new ArrayList();

        BufferedReader readed;
        try {
            readed = new BufferedReader(new FileReader(baseFilename));

            //storeage lines as strings
            String contentLine;

            while ((contentLine = readed.readLine()) != null) {

                Product p= new Product(contentLine);
                products.add(p);


            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public ArrayList<String> getNames()
    {

        ArrayList<String> names = new ArrayList<>();
       for(Product p: products)
       {
          names.add(p.getName());
       }return names;
    }




    public Product getProductByName(String name) throws ProductManagerException
    {
         for(Product p: products)
        {
            if(p.getName().equals(name))
            {
                return p;
            }
        }throw new ProductManagerException("Product with this name does not exist in the store");
    }

    //for purchasing
    public void saveProducts() throws IOException
    {
     FileWriter output = new FileWriter(baseFilename);

                for(Product prod: products)
                {
                output.write(prod+System.getProperty("line.separator"));

                    }



            output.close();
            System.out.println("products.txt has been updated sucessfully");

    }

}
