/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenbookstore.form;

import com.mycompany.mavenbookstore.form.LoginFrame;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import com.mycompany.mavenbookstore.mainclass.Book;
import com.mycompany.mavenbookstore.panel.BookDisplayShell;
import com.mycompany.mavenbookstore.panel.CartPanel;
import com.mycompany.mavenbookstore.panel.CatalogPanel;
import com.mycompany.mavenbookstore.panel.ContentPanel;
import com.mycompany.mavenbookstore.utils.MySQLConnUtils;
import com.mycompany.mavenbookstore.panel.WelcomePanel;

/**
 *  
 * @author ADMIN
 */



public class MainFrame extends javax.swing.JFrame {
    CatalogPanel catalogPanel = new CatalogPanel();
    CartPanel cartPanel = new CartPanel();
    WelcomePanel welcomePanel = new WelcomePanel();
    ArrayList<Book> stagedBookList = new ArrayList<Book>();
    Statement statement = null;
    ArrayList<Book> displayBook = new ArrayList<Book>();
    ContentPanel ip = null;
    /**
     * Creates new form MainFrame
     */
    
    
    private ArrayList<Book> getBookByType(String type){
        ArrayList<Book> arr = new ArrayList<Book>();
        
        if (statement != null){
            String sqlQuery = "Select * from books where type = '" + type + "';";

            try {
                ResultSet rs = statement.executeQuery(sqlQuery);
                while (rs.next()){
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String description = rs.getString(3);
                    String imgPath = rs.getString(4);
//                    System.out.println(imgPath);
                    double price = rs.getDouble(5);
                    int amount = rs.getInt(6);
                    int year = rs.getInt(7);
                    String b_type = rs.getString(8);
                    String publisher = rs.getString(10);
                    
                    Book book = new Book(id, name, publisher, year, price, imgPath, description, amount);
                    //int id, String ten, String nhaXuatBan, int namXuatBan, double gia, String imgPath, String description, int amount
                    arr.add(book);
                }
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arr;
    }
    
    private void initWelcomePanel(){
        welcomePanel.setSize(welcomePanel.getPreferredSize());
        welcomePanel.getMangaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayBook = getBookByType("Manga");
                catalogPanel.updateBookDisplayList(displayBook);
                for (BookDisplayShell bds : catalogPanel.getBookDisplayList()){
                    bds.getImgButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            
                            ContentPanel ip = new ContentPanel(bds.getBook());
                            ip.getAddButton().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (ip.isAdded() == false)
                                        stagedBookList.add(ip.getBook());
                                        ip.setAdded(true);
                                }
                            });
                            
                            ip.setSize(ip.getPreferredSize());
                            process.removeAll();
                            initContentPosition();
//                            process.setMinimumSize(ip.getPreferredSize());
                            process.add(ip);
                            process.setPreferredSize(ip.getPreferredSize());
                            process.updateUI();
                        }
                    });
                }
                process.removeAll();
                initContentPosition();
                catalogPanel.updateUI();
                process.add(catalogPanel);
                
                process.setPreferredSize(catalogPanel.getPreferredSize());
        //        this.process.updateUI();
                process.updateUI();
            }
        });
        
        welcomePanel.getBookButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayBook = getBookByType("Book");
                catalogPanel.updateBookDisplayList(displayBook);
                for (BookDisplayShell bds : catalogPanel.getBookDisplayList()){
                    bds.getImgButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            
                            ContentPanel ip = new ContentPanel(bds.getBook());
                            ip.getAddButton().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (ip.isAdded() == false)
                                        stagedBookList.add(ip.getBook());
                                        ip.setAdded(true);
                                }
                            });
                            
                            ip.setSize(ip.getPreferredSize());
                            process.removeAll();
                            initContentPosition();
        //                            process.setMinimumSize(ip.getPreferredSize());

                            process.add(ip);
                            process.setPreferredSize(ip.getPreferredSize());
                            process.updateUI();
                        }
                    });
                }
                process.removeAll();
                initContentPosition();
                catalogPanel.updateUI();
                process.add(catalogPanel);
                
                process.setPreferredSize(catalogPanel.getPreferredSize());
        //        this.process.updateUI();
                process.updateUI();
            }
        });
    }
    private void initCatalogPanel(){
        catalogPanel.setSize(catalogPanel.getPreferredSize());
    }
    private void initCartPanel(){
        cartPanel.setSize(cartPanel.getPreferredSize());
    }
    
    private void initContentPosition(){
        scrollpane.getVerticalScrollBar().setValue(0);
    }
    public MainFrame(JFrame some) {
        some.dispose();
        initComponents();
        initWelcomePanel();
        initCatalogPanel();
        initCartPanel();
        this.setResizable(false);
        this.scrollpane.getVerticalScrollBar().setUnitIncrement(20);
        this.cartButton.setBorderPainted(false);
        this.process.add(welcomePanel);
        this.process.setPreferredSize(welcomePanel.getPreferredSize());
        try {
            Connection connection = MySQLConnUtils.getMySQLConnection();
            statement = connection.createStatement();   
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.process.updateUI();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        head_produce = new javax.swing.JPanel();
        but_home1 = new javax.swing.JButton();
        searchBar = new javax.swing.JTextField();
        but_search1 = new javax.swing.JButton();
        but_signin1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cartButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        scrollpane = new javax.swing.JScrollPane();
        process = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        head_produce.setBackground(new java.awt.Color(153, 255, 255));
        head_produce.setPreferredSize(new java.awt.Dimension(1300, 90));

        but_home1.setBackground(new java.awt.Color(255, 255, 255));
        but_home1.setText("Home");
        but_home1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_home1ActionPerformed(evt);
            }
        });

        searchBar.setToolTipText("");
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });

        but_search1.setText("Search");
        but_search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_search1ActionPerformed(evt);
            }
        });

        but_signin1.setText("Sign out");
        but_signin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_signin1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\Documents\\NetBeansProjects\\MavenBookStore\\resources\\img\\persion_icon2.png")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Name");

        cartButton.setBackground(new java.awt.Color(153, 255, 255));
        cartButton.setForeground(new java.awt.Color(153, 255, 255));
        cartButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\Documents\\NetBeansProjects\\MavenBookStore\\resources\\img\\cart.png")); // NOI18N
        cartButton.setToolTipText("");
        cartButton.setBorder(null);
        cartButton.setBorderPainted(false);
        cartButton.setContentAreaFilled(false);
        cartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartButtonActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 204, 204));
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\Documents\\NetBeansProjects\\MavenBookStore\\resources\\img\\logo.png")); // NOI18N

        javax.swing.GroupLayout head_produceLayout = new javax.swing.GroupLayout(head_produce);
        head_produce.setLayout(head_produceLayout);
        head_produceLayout.setHorizontalGroup(
            head_produceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(head_produceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(but_home1)
                .addGap(87, 87, 87)
                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(but_search1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(head_produceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(head_produceLayout.createSequentialGroup()
                        .addComponent(but_signin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(37, 37, 37))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(cartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(399, 399, 399))
        );
        head_produceLayout.setVerticalGroup(
            head_produceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(head_produceLayout.createSequentialGroup()
                .addGroup(head_produceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(head_produceLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(head_produceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(but_home1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(but_search1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(head_produceLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(head_produceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(head_produceLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(but_signin1)))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addComponent(cartButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        scrollpane.setMinimumSize(new java.awt.Dimension(1300, 720));
        scrollpane.setPreferredSize(new java.awt.Dimension(1300, 720));

        process.setBackground(new java.awt.Color(222, 239, 206));
        process.setPreferredSize(new java.awt.Dimension(1324, 974));

        javax.swing.GroupLayout processLayout = new javax.swing.GroupLayout(process);
        process.setLayout(processLayout);
        processLayout.setHorizontalGroup(
            processLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1324, Short.MAX_VALUE)
        );
        processLayout.setVerticalGroup(
            processLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
        );

        scrollpane.setViewportView(process);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(head_produce, javax.swing.GroupLayout.PREFERRED_SIZE, 1326, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(head_produce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 713, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartButtonActionPerformed
        this.process.removeAll();
        initContentPosition();
        this.process.add(cartPanel);
        cartPanel.updateCartList(stagedBookList);
        this.process.setPreferredSize(cartPanel.getPreferredSize());
        this.process.updateUI();
    }//GEN-LAST:event_cartButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void but_signin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_signin1ActionPerformed
        LoginFrame loginForm = new LoginFrame(this);
        loginForm.show();
    }//GEN-LAST:event_but_signin1ActionPerformed

    private void but_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_search1ActionPerformed
        String bookName = this.searchBar.getText();
        
        String sqlQuery = "Select * from books where bo_name = '" + bookName+ "'";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sqlQuery);
            System.out.println(sqlQuery);
            if (rs.next() == false){
                JOptionPane.showMessageDialog(null, "Khong co sach nay ");
            }
            else{
                 int id =rs.getInt(1);
                 
                int c =JOptionPane.showConfirmDialog(null, "ban co muon hien san pham? ");
                if(c==1);
                else if(c==0){
                    String name = rs.getString(2);
                    String description = rs.getString(3);
                    String imgPath = rs.getString(4);
//                    System.out.println(imgPath);
                    double price = rs.getDouble(5);
                    int amount = rs.getInt(6);
                    int year = rs.getInt(7);
                    String b_type = rs.getString(8);
                    String publisher = rs.getString(10);
                    
                    Book book = new Book(id, name, publisher, year, price, imgPath, description, amount);
                    ContentPanel ip = new ContentPanel(book);
                    ip.getAddButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (ip.isAdded() == false)
                                stagedBookList.add(ip.getBook());
                                ip.setAdded(true);
                        }
                    });
                    ip.setSize(ip.getPreferredSize());
                    process.removeAll();
                    initContentPosition();
//                            process.setMinimumSize(ip.getPreferredSize());

                    process.add(ip);
                    process.setPreferredSize(ip.getPreferredSize());
                    process.updateUI();
                }
                
            }
        } catch (SQLException ex) {
            
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_but_search1ActionPerformed

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

    private void but_home1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_home1ActionPerformed
        this.process.removeAll();
        initContentPosition();
        this.process.add(welcomePanel);
        this.process.setPreferredSize(welcomePanel.preferredSize());
        this.process.updateUI();
    }//GEN-LAST:event_but_home1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainFrame().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_home1;
    private javax.swing.JButton but_search1;
    private javax.swing.JButton but_signin1;
    private javax.swing.JButton cartButton;
    private javax.swing.JPanel head_produce;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel process;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTextField searchBar;
    // End of variables declaration//GEN-END:variables

    public JButton getCartButton() {
        return cartButton;
    }
}


// Với cấu hình cổng A là cổng vào, B là cổng ra và tất cả các bits của cổng C cấu hình như lối vào
//TÌm địa chỉ cổng gán cho A, B, C 
//b. tìm ba điều khiển cho cấu hình này của 8255
//c. viết chương trình để đọc dữ liệu từ cổng A và gửi dữ liệu này ra cổng B và cổng C