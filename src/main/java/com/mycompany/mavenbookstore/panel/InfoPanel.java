/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenbookstore.panel;

import com.mycompany.mavenbookstore.mainclass.Book;
import javax.swing.JButton;

/**
 *
 * @author ADMIN
 */
public class InfoPanel extends javax.swing.JPanel {
    Book book = null;

    public Book getBook() {
        return book;
    }
    /**
     * Creates new form InfoPanel
     */
    public InfoPanel(Book book) {
        initComponents();
        this.book = book;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addButton = new javax.swing.JButton();

        addButton.setText("Add to cart");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(addButton)
                .addGap(0, 34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(addButton)
                .addGap(0, 76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    // End of variables declaration//GEN-END:variables
    private boolean added;
    
    public boolean isAdded(){
        return this.added;
    }
    public void setAdded(boolean added){
        this.added = added;
    }
    
    public JButton getAddButton(){
        return this.addButton;
    }
}
