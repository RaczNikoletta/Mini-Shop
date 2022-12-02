/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raczn
 */
public class ShopGui extends javax.swing.JFrame {

    private final ProductManager manager;
    private final Basket basket;
    private final WishList wishList;
    private DefaultListModel listModel;
    private DefaultTableModel tModel;
    private DefaultListModel wishModel;

    /**
     * Creates new form ShopGui
     */
    public class ShopException extends Exception {

        public ShopException(String errorMessage) {
            super(errorMessage);
        }

    }

    public ShopGui() throws IOException, WishList.WishListException {
        manager = new ProductManager("products.txt");
        basket = new Basket("basket.txt");
        wishList = new WishList("wishlist.txt");
        fillProductList();
        fillTable();
        fillWishList();
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the
     * Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        mainTabbedPane = new javax.swing.JTabbedPane();
        searchPanel = new javax.swing.JPanel();
        SearchTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        productList = new JList<>(listModel);
        WhisListPanel = new javax.swing.JPanel();
        whisListLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        wishlistList = new JList<>(wishModel);
        removeFromWishlistButton = new javax.swing.JButton();
        BasketPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BasketTable = new javax.swing.JTable(tModel);
        TotalPriceLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        totalPricePane = new javax.swing.JTextPane();
        PurchasePanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        adressTextField = new javax.swing.JTextField();
        telephoneTextField = new javax.swing.JTextField();
        cardNumberTextField = new javax.swing.JTextField();
        adressLabel = new javax.swing.JLabel();
        telephoneLabel = new javax.swing.JLabel();
        cardNumberLabel = new javax.swing.JLabel();
        purchaseButton = new javax.swing.JButton();
        totalCostLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalCostDispLab = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Shop");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        searchPanel.setForeground(new java.awt.Color(0, 153, 255));

        SearchTextField.setText("Name of product...");
        SearchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SearchTextFieldKeyTyped(evt);
            }
        });

        productList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productList);

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SearchTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Product List", searchPanel);

        whisListLabel.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        whisListLabel.setText("Your Wishlist");

        wishlistList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wishlistListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(wishlistList);

        removeFromWishlistButton.setText("Remove");
        removeFromWishlistButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeFromWishlistButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout WhisListPanelLayout = new javax.swing.GroupLayout(WhisListPanel);
        WhisListPanel.setLayout(WhisListPanelLayout);
        WhisListPanelLayout.setHorizontalGroup(
            WhisListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WhisListPanelLayout.createSequentialGroup()
                .addGroup(WhisListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WhisListPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(WhisListPanelLayout.createSequentialGroup()
                        .addGroup(WhisListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(WhisListPanelLayout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(whisListLabel))
                            .addGroup(WhisListPanelLayout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addComponent(removeFromWishlistButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 171, Short.MAX_VALUE)))
                .addContainerGap())
        );
        WhisListPanelLayout.setVerticalGroup(
            WhisListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WhisListPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(whisListLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeFromWishlistButton)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Whislist", WhisListPanel);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Your Basket");

        jScrollPane2.setViewportView(BasketTable);

        TotalPriceLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        TotalPriceLabel.setText("Total price:");

        jScrollPane4.setViewportView(totalPricePane);

        javax.swing.GroupLayout BasketPanelLayout = new javax.swing.GroupLayout(BasketPanel);
        BasketPanel.setLayout(BasketPanelLayout);
        BasketPanelLayout.setHorizontalGroup(
            BasketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BasketPanelLayout.createSequentialGroup()
                .addGroup(BasketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BasketPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
                    .addGroup(BasketPanelLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(BasketPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TotalPriceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        BasketPanelLayout.setVerticalGroup(
            BasketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BasketPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BasketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalPriceLabel))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Basket", BasketPanel);

        PurchasePanel.setForeground(new java.awt.Color(51, 153, 255));

        nameLabel.setText("Name:");

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        adressTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adressTextFieldActionPerformed(evt);
            }
        });

        telephoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telephoneTextFieldActionPerformed(evt);
            }
        });

        cardNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardNumberTextFieldActionPerformed(evt);
            }
        });

        adressLabel.setText("Adrress:");

        telephoneLabel.setText("Telephone:");

        cardNumberLabel.setText("Cardnumber:");

        purchaseButton.setText("Purchase");
        purchaseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                purchaseButtonMouseClicked(evt);
            }
        });
        purchaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseButtonActionPerformed(evt);
            }
        });

        totalCostLabel.setText("Total Cost:");

        totalCostDispLab.setText(Integer.toString(basket.calculateTotal())+" Ft");

        javax.swing.GroupLayout PurchasePanelLayout = new javax.swing.GroupLayout(PurchasePanel);
        PurchasePanel.setLayout(PurchasePanelLayout);
        PurchasePanelLayout.setHorizontalGroup(
            PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PurchasePanelLayout.createSequentialGroup()
                .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PurchasePanelLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(purchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PurchasePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(PurchasePanelLayout.createSequentialGroup()
                                .addComponent(totalCostLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalCostDispLab))
                            .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PurchasePanelLayout.createSequentialGroup()
                                    .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(telephoneLabel)
                                        .addComponent(adressLabel)
                                        .addComponent(nameLabel))
                                    .addGap(23, 23, 23)
                                    .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(adressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(telephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(PurchasePanelLayout.createSequentialGroup()
                                    .addComponent(cardNumberLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cardNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        PurchasePanelLayout.setVerticalGroup(
            PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PurchasePanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PurchasePanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PurchasePanelLayout.createSequentialGroup()
                        .addComponent(adressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PurchasePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(adressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalCostLabel)
                    .addComponent(jLabel2)
                    .addComponent(totalCostDispLab))
                .addGap(33, 33, 33)
                .addComponent(purchaseButton)
                .addGap(45, 45, 45))
        );

        mainTabbedPane.addTab("Purchase items", PurchasePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTextFieldKeyTyped
        String text = SearchTextField.getText();
        //remove becaouse we just want to see the current product names
        //relying on the typed keys
        listModel.removeAllElements();
        for (String name : manager.getNames()) {
            //just contains somewhere
            if (name.contains(text)) {
                listModel.addElement(name);

            }
            productList = new javax.swing.JList<>(listModel);
        }

    }//GEN-LAST:event_SearchTextFieldKeyTyped

    private void productListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productListMouseClicked

        if (evt.getClickCount() == 2) {
            try {
                //get the value from the Jlist using it's index
                String productname = (String) productList.getModel().getElementAt(productList.locationToIndex(evt.getPoint()));

                ProductWindow frame = new ProductWindow(productname, basket, manager, wishList, tModel, BasketTable,
                        totalPricePane, wishlistList, wishModel, totalCostDispLab);

                frame.setVisible(true);
                //refreshing the basket

            } catch (ProductManager.ProductManagerException ex) {
                Logger.getLogger(ShopGui.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_productListMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        int corfirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program? Your basket will be deleted.",
                "Exit Program Message Box", JOptionPane.YES_NO_OPTION);
        if (corfirmed == JOptionPane.YES_OPTION) {
            PrintWriter writer = null;
            try {
                writer = new PrintWriter("basket.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ShopGui.class.getName()).log(Level.SEVERE, null, ex);
            }
            writer.print("");
            writer.close();
            dispose();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void wishlistListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wishlistListMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_wishlistListMouseClicked

    private void removeFromWishlistButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeFromWishlistButtonMouseClicked
        String productName = wishlistList.getSelectedValue();

        wishModel.removeElement(productName);

        try {
            this.wishList.deleteFromWishList(productName);
        } catch (WishList.WishListException | IOException ex) {
            Logger.getLogger(ShopGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_removeFromWishlistButtonMouseClicked

    private void cardNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardNumberTextFieldActionPerformed

    private void telephoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telephoneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telephoneTextFieldActionPerformed

    private void adressTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adressTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adressTextFieldActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void purchaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseButtonActionPerformed

    private void purchaseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseButtonMouseClicked
        String costumerName = null;
        String costumerAddress = null;
        String costumerTelephone = null;
        String costumerCard = null;
        HashMap<Product, Integer> cart = new HashMap<>();
        String attributes = "";

        try {

            cart = basket.getCart();
            if (cart.isEmpty()) {

                throw new ShopException("Your basket is empty, you should add to it something first!");

            }

            costumerName = nameTextField.getText();
            costumerAddress = adressTextField.getText();
            costumerTelephone = telephoneTextField.getText();
            costumerCard = cardNumberTextField.getText();

            if (costumerName.equals("")) {
                throw new ShopException("Please fill name field");
            }
            if (costumerAddress.equals("")) {
                throw new ShopException("Please fill adress field");
            }
            if (costumerTelephone.equals("")) {
                throw new ShopException("Please fill telephone field");
            }
            if (costumerCard.equals("")) {
                throw new ShopException("Please fill card field");
            }

            //get components
            Iterator cartIterator = cart.entrySet().iterator();
            while (cartIterator.hasNext()) {
                HashMap.Entry cartElement = (HashMap.Entry) cartIterator.next();
                attributes += (cartElement.getKey().toString());
                attributes += (" " + cartElement.getValue().toString());
            }
            Date datenow = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-DD HH:mm");

            FileWriter invoice = new FileWriter("lastPurchase_invoice.txt");

            invoice.write(
                    "Thank you for purchase! " + System.getProperty("line.separator")
                    + System.getProperty("line.separator")
                    + "Your bill is ready" + System.getProperty("line.separator")
                    + "Costumer details: " + System.getProperty("line.separator")
                    + "Name: " + costumerName + " Telephone number: " + costumerTelephone
                    + System.getProperty("line.separator") + "Address: " + costumerAddress
                    + " Cardnumber: " + costumerCard + System.getProperty("line.separator")
                    + "Purchased items:" + System.getProperty("line.separator")
                    + attributes + " db" + System.getProperty("line.separator")
                    + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "Made at: " + formatter.format(datenow));
            invoice.close();
            //-in_stock
            for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
                entry.getKey().updateIn_Stock(entry.getValue());
                manager.saveProducts();
            }
            //remove from basketTable

            //remove from basket txt
            basket.deleteBasket();

            //refresh baskettable
            int rowCount = tModel.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                tModel.removeRow(i);
            }
            BasketTable.setModel(tModel);
            totalPricePane.setText(Integer.toString(basket.calculateTotal()));
            totalCostDispLab.setText(Integer.toString(basket.calculateTotal()));

            JOptionPane.showMessageDialog(null, "Your payment was succesfully. Thank you for buying! You can check your bill.");

        } catch (IOException ex) {
            Logger.getLogger(ShopGui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ShopException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_purchaseButtonMouseClicked

    public void fillProductList() {
        //create the listModell to edit the contents of the Jlist
        listModel = new DefaultListModel();
        //get names from productManager
        for (String name : manager.getNames()) {
            {
                listModel.addElement(name);

            }
            productList = new JList(listModel);
        }
    }
    

    public void fillTable() {
        tModel = new DefaultTableModel(
                new Object[]{"Product Name", "Product Type", "Amount", "Price"}, 0
        );
        for (Map.Entry<Product, Integer> entry : basket.getCart().entrySet()) {
            tModel.addRow(new Object[]{entry.getKey().getName(), entry.getKey().getType(), entry.getValue(), entry.getKey().getPrice()});
        }
        BasketTable = new JTable(tModel);
    }

    public void fillWishList() throws WishList.WishListException {

        wishModel = new DefaultListModel();
        wishlistList = new JList(wishModel);
        //get names from productManager
        ArrayList<String> names = wishList.getWishNames();
        if (!names.isEmpty()) {
            for (String name : names) {
                {
                    if (!wishModel.contains(name)) {
                        wishModel.addElement(name);
                    }

                }

            }
            wishlistList = new JList(wishModel);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShopGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShopGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShopGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShopGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ShopGui().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ShopGui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (WishList.WishListException ex) {
                    Logger.getLogger(ShopGui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BasketPanel;
    private javax.swing.JTable BasketTable;
    private javax.swing.JPanel PurchasePanel;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JLabel TotalPriceLabel;
    private javax.swing.JPanel WhisListPanel;
    private javax.swing.JLabel adressLabel;
    private javax.swing.JTextField adressTextField;
    private javax.swing.JLabel cardNumberLabel;
    private javax.swing.JTextField cardNumberTextField;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JList<String> productList;
    private javax.swing.JButton purchaseButton;
    private javax.swing.JButton removeFromWishlistButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JLabel telephoneLabel;
    private javax.swing.JTextField telephoneTextField;
    private javax.swing.JLabel totalCostDispLab;
    private javax.swing.JLabel totalCostLabel;
    private javax.swing.JTextPane totalPricePane;
    private javax.swing.JLabel whisListLabel;
    private javax.swing.JList<String> wishlistList;
    // End of variables declaration//GEN-END:variables
}