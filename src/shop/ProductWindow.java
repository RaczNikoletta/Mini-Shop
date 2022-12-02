/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raczn
 */
public class ProductWindow extends JFrame {

    private final Product product;
    private final String type;
    private final String productName;
    private final Basket basket;
    private final WishList wishList;
    private final ProductManager manager;
    private final DefaultListModel wishModel;
    private DefaultTableModel basketModel;
    private final javax.swing.JButton AddButton;
    private final javax.swing.JLabel AddToCartLabel;
    private javax.swing.JTextField AmountField;
    private final javax.swing.JLabel ProductNamelabel;
    private final javax.swing.JLabel pictureLabel;
    private final javax.swing.JButton wishListButton;
    private final javax.swing.JButton removeButton;
    private final javax.swing.JLabel Type;
    private final javax.swing.JLabel Price;
    private final JLabel inStock;

    public ProductWindow(String name, Basket _basket, ProductManager _manager, WishList _wishList, DefaultTableModel tmodel, JTable basketTable, JTextPane totalPrice,
            JList _wishlistList, DefaultListModel _wishModel, JLabel totalCostDispLab) throws ProductManager.ProductManagerException {
        super();
        productName = name;
        basket = _basket;
        manager = _manager;
        wishList = _wishList;
        wishModel = _wishModel;
        product = manager.getProductByName(productName);
        type = product.getType();

        ProductNamelabel = new javax.swing.JLabel();
        Type = new JLabel();
        Price = new JLabel();
        AmountField = new javax.swing.JTextField();
        AddToCartLabel = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        wishListButton = new javax.swing.JButton();
        pictureLabel = new javax.swing.JLabel();
        removeButton = new javax.swing.JButton();
        inStock = new JLabel();
    
   
   

        this.setTitle(productName);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ProductNamelabel.setText(productName);
        ProductNamelabel.setFont(new Font("Times new Roman", Font.BOLD, 20));

        AmountField.setText("1");

        Type.setText(product.getType());

        inStock.setText("In stock " + Integer.toString(product.getIn_stock()));

        Price.setText(Integer.toString(product.getPrice()) + " Ft");

        AddToCartLabel.setText("Add to cart");
        AddToCartLabel.setFont(new Font("Times new Roman", Font.BOLD, 16));

        AddButton.setText("Add");
        
        
        
    
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    AddButtonActionPerformed(evt);
                } catch (ProductManager.ProductManagerException | Basket.BasketException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (IOException ex) {
                    Logger.getLogger(ProductWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            private void AddButtonActionPerformed(ActionEvent evt) throws ProductManager.ProductManagerException, Basket.BasketException, IOException {
                int amount = Integer.parseInt(AmountField.getText());
                basket.addProductToBasket(product, amount);

                basketModel = new DefaultTableModel(
                        new Object[]{"Product Name", "Product Type", "Amount", "Price"}, 0
                );
                basket.getCart().entrySet().forEach((entry) -> {
                    basketModel.addRow(new Object[]{entry.getKey().getName(), entry.getKey().getType(), entry.getValue(), entry.getKey().getPrice()});
                });
                basketTable.setModel(basketModel);
                int price;
                price = basket.calculateTotal();
                totalPrice.setText(Integer.toString(price) + " Ft");
                totalCostDispLab.setText(Integer.toString(price) + " Ft");

            }
        });
    

        wishListButton.setText("Add to whislist");
        wishListButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    try {
                        wishListButtonActionPerformed(evt);
                    } catch (WishList.WishListException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                } catch (ProductManager.ProductManagerException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (Basket.BasketException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (IOException ex) {
                    Logger.getLogger(ProductWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            private void wishListButtonActionPerformed(ActionEvent evt) throws ProductManager.ProductManagerException, Basket.BasketException, IOException, WishList.WishListException {

                wishList.addProductToWishList(product);
                if (!wishModel.contains(productName)) {
                    wishModel.addElement(productName);
                    //after the inicializatition
                } else {
                    JOptionPane.showMessageDialog(null, "You already have this product in your wishlist!");
                }

            }
        });
        String image = "/shop/" + type + ".jpg";
        java.net.URL imgURL = getClass().getResource(image);
        if (imgURL != null) {
            pictureLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(image)));
        } else {
            System.err.println("couldn't find file" + image);
        }

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    removeButtonActionPerformed(evt);
                } catch (ProductManager.ProductManagerException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                } catch (Basket.BasketException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                } catch (IOException ex) {
                    Logger.getLogger(ProductWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(null, "The basket does not contain this product");
                }
            }

            private void removeButtonActionPerformed(ActionEvent evt) throws ProductManager.ProductManagerException, Basket.BasketException, IOException {
                int amount = Integer.parseInt(AmountField.getText());
                Product product = manager.getProductByName(productName);
                basket.deleteFromBasket(product, amount);

                basketModel = new DefaultTableModel(
                        new Object[]{"Product Name", "Product Type", "Amount", "Price"}, 0
                );
                for (Map.Entry<Product, Integer> entry : basket.getCart().entrySet()) {
                    basketModel.addRow(new Object[]{entry.getKey().getName(), entry.getKey().getType(), entry.getValue(), entry.getKey().getPrice()});
                }
                basketTable.setModel(basketModel);
                int price = basket.calculateTotal();
                totalPrice.setText(Integer.toString(price) + " Ft");
                totalCostDispLab.setText(Integer.toString(price) + " Ft");
            }

        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(ProductNamelabel)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(AddToCartLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(AmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(wishListButton))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(AddButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(removeButton))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(42, 42, 42)
                                                                .addComponent(inStock)))
                                                .addGap(125, 125, 125))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(pictureLabel)
                                                        .addComponent(Type)
                                                        .addComponent(Price))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ProductNamelabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Type)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Price)
                                .addGap(21, 21, 21)
                                .addComponent(pictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(AmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AddToCartLabel)
                                        .addComponent(AddButton)
                                        .addComponent(removeButton))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(wishListButton)
                                        .addComponent(inStock))
                                .addContainerGap())
        );

        pack();
        // </editor-fold>           

    }
}
