/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author ADMIN
 */
public class CartPanel extends javax.swing.JPanel {
    private int lastIndex = 3;
    private ArrayList<Book> cartList = new ArrayList<Book>();
    private ArrayList<BuyShellPanel> shellList = new ArrayList<BuyShellPanel>();
    private int tempId;

    public void setCartList(ArrayList<Book> cartList) {
        this.cartList = cartList;
    }

    
    public void initCartList(){
        this.cartList.add(new Book(10, "Sach giao khoa1", "Kim dong", 2017, 30000, "resources/img/book_icon.png"));
        this.cartList.add(new Book(10, "Sach giao khoa2", "Kim dong", 2017, 30000, "resources/img/book_icon.png"));
        this.cartList.add(new Book(10, "Sach giao khoa3", "Kim dong", 2017, 30000, "resources/img/book_icon.png"));
        this.cartList.add(new Book(10, "Sach giao khoa4", "Kim dong", 2017, 30000, "resources/img/book_icon.png"));
        this.cartList.add(new Book(10, "Sach giao khoa5", "Kim dong", 2017, 30000, "resources/img/book_icon.png"));
        this.cartList.add(new Book(10, "Sach giao khoa6", "Kim dong", 2017, 30000, "resources/img/book_icon.png"));
        this.cartList.add(new Book(10, "Sach giao khoa7", "Kim dong", 2017, 30000, "resources/img/book_icon.png"));
        this.cartList.add(new Book(10, "Sach giao khoa8", "Kim dong", 2017, 30000, "resources/img/book_icon.png"));
        this.cartList.add(new Book(10, "Sach giao khoa9", "Kim dong", 2017, 30000, "resources/img/book_icon.png"));
        this.cartList.add(new Book(10, "Sach giao khoa10", "Kim dong", 2017, 30000, "resources/img/book_icon.png"));
        
    }
    
    public void updateCartList(ArrayList<Book> bookList){
        shellList.clear();
        for (Book book : bookList){
            BuyShellPanel shellPanel = new BuyShellPanel(book);
            shellList.add(shellPanel);
            shellPanel.getCheckbox().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    shellPanel.recomputeValue();
                    totalPrice.setText("Total: " + Double.toString(computeTotal()));
                }
            });
            shellPanel.getAmountSpinner().addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    shellPanel.recomputeValue();
                    if (shellPanel.isChecked() == true){
                        totalPrice.setText("Total: " + Double.toString(computeTotal()));
                    }
                }
            });
            shellPanel.getDeleteButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    shellList.remove(shellPanel);
                    productReDisplay();
                    totalPrice.setText("Total: " + Double.toString(computeTotal()));
                }
            });
        }
        this.productDisplayArea.removeAll();
        lastIndex = 3;
        for (int i=0; i< Math.min(3, shellList.size()); i++){
            this.productDisplayArea.add(shellList.get(i));
        }
        this.productDisplayArea.updateUI();
    }
    
    public void initBuyShellPanelList(){
        for (Book book : cartList){
            BuyShellPanel shellPanel = new BuyShellPanel(book);
            this.shellList.add(new BuyShellPanel(book));
            
        }
    }
    /**
     * Creates new form CartPanel
     */
    
    private double computeTotal(){
        double total = 0;
        for (BuyShellPanel shellPanel : shellList){
            total += shellPanel.getValue();
        }
        
        return total;
    }
    public CartPanel() {
        initComponents();
        initCartList();
        initBuyShellPanelList();
        this.cartList = cartList;
        this.setMinimumSize(this.getPreferredSize());
        this.setSize(300, 300);
        
        for (BuyShellPanel shellPanel : shellList){
            shellPanel.getCheckbox().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    shellPanel.recomputeValue();
                    totalPrice.setText("Total: " + Double.toString(computeTotal()));
                }
            });
            shellPanel.getAmountSpinner().addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    shellPanel.recomputeValue();
                    if (shellPanel.isChecked() == true){
                        totalPrice.setText("Total: " + Double.toString(computeTotal()));
                    }
                }
            });
            shellPanel.getDeleteButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    shellList.remove(shellPanel);
                    productReDisplay();
                    totalPrice.setText("Total: " + Double.toString(computeTotal()));
                }
            });
        }
    }
    
    private void productReDisplay(){
        this.productDisplayArea.removeAll();
        for (int i=Math.max(lastIndex - 3, 0); i < Math.min(shellList.size(), lastIndex); i++){
            this.productDisplayArea.add(shellList.get(i));
        }
        this.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        totalPrice = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        productDisplayArea = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jCheckBox4 = new javax.swing.JCheckBox();
        backButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalPrice.setText("Total:");
        jPanel1.add(totalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, -1, -1));

        jLabel18.setText("Total cost:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, -1, -1));

        jButton8.setText("Confirm");
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Lưu ý : - Khách mua hàng kiểm tra lại \ngiá của sản phẩm.\n            - Khách mua hàng được đổi trả \nsản phẩm trong vòng 7 ngày.\n            - Đổi trả phải mang theo hoá \nđơn và thông tin sản phẩm.\n\nMy Book Store cam kết đảm bảo chất \nLượng sản phẩm và nguồn gốc. Nếu \nphát hiện hàng giả sẽ được hoàn tiền \n200%.\nMọi thắc mắc xin liên hệ :\nHotline : 0969837995 \n");
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 260, 240));

        productDisplayArea.setBackground(new java.awt.Color(255, 255, 255));
        productDisplayArea.setLayout(new java.awt.GridLayout(3, 1, 1, 1));
        jPanel1.add(productDisplayArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 460, 600));

        jCheckBox4.setText("Select all");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jCheckBox4)
                .addGap(38, 38, 38)
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nextButton)
                .addGap(0, 213, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox4)
                    .addComponent(backButton)
                    .addComponent(nextButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.productDisplayArea.removeAll();
        if (lastIndex - 3 > 0){
            lastIndex -= 3;
        }
        for (int i=Math.max(lastIndex - 3, 0); i < Math.min(lastIndex, shellList.size()); i++){
            this.productDisplayArea.add(shellList.get(i));
        }
        
        this.productDisplayArea.updateUI();
    }//GEN-LAST:event_backButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        this.productDisplayArea.removeAll();
        if (lastIndex >= this.cartList.size()) return;
        for (int i=lastIndex; i < Math.min(lastIndex + 3, this.shellList.size()); i++){
            this.productDisplayArea.add(shellList.get(i));
        }
        
        if (lastIndex + 3 < this.shellList.size() + 3){
            lastIndex += 3;
        }
        
        this.productDisplayArea.updateUI();
    }//GEN-LAST:event_nextButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton nextButton;
    private javax.swing.JPanel productDisplayArea;
    private javax.swing.JLabel totalPrice;
    // End of variables declaration//GEN-END:variables
}
