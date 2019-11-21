/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

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
import javax.swing.JPanel;

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
                            process.removeAll();
                            InfoPanel ip = new InfoPanel(bds.getBook());
                            ip.setSize(200, 200);
                            ip.getAddButton().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (ip.isAdded() == false)
                                        stagedBookList.add(ip.getBook());
                                        ip.setAdded(true);
                                }
                            });
                            process.add(ip);
                            process.setSize(new Dimension(123, 123));
                            process.updateUI();
                        }
                    });
                }
                process.removeAll();
                process.add(catalogPanel);
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
    public MainFrame() {
        initComponents();
        initWelcomePanel();
        initCatalogPanel();
        initCartPanel();
        
        this.process.add(welcomePanel);
        try {
            Connection connection = MySQLConnUtils.getMySQLConnection();
            statement = connection.createStatement();   
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
        but_discovery1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cartButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        process = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        head_produce.setBackground(new java.awt.Color(153, 255, 255));

        but_home1.setBackground(new java.awt.Color(255, 255, 255));
        but_home1.setText("Home");
        but_home1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_home1ActionPerformed(evt);
            }
        });

        searchBar.setText("search");
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

        but_discovery1.setText("Discovery");

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Name");

        cartButton.setText("Cart");
        cartButton.setToolTipText("");
        cartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout head_produceLayout = new javax.swing.GroupLayout(head_produce);
        head_produce.setLayout(head_produceLayout);
        head_produceLayout.setHorizontalGroup(
            head_produceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(head_produceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(but_home1)
                .addGap(0, 0, 0)
                .addComponent(but_discovery1)
                .addGap(0, 0, 0)
                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(but_search1)
                .addGap(0, 0, 0)
                .addComponent(but_signin1)
                .addGap(0, 0, 0)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartButton)
                .addContainerGap())
        );
        head_produceLayout.setVerticalGroup(
            head_produceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(head_produceLayout.createSequentialGroup()
                .addGroup(head_produceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(head_produceLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(head_produceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cartButton)))
                    .addGroup(head_produceLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(head_produceLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(head_produceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(but_home1)
                            .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(but_search1)
                            .addComponent(but_signin1)
                            .addComponent(but_discovery1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout processLayout = new javax.swing.GroupLayout(process);
        process.setLayout(processLayout);
        processLayout.setHorizontalGroup(
            processLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 855, Short.MAX_VALUE)
        );
        processLayout.setVerticalGroup(
            processLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(head_produce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(process, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(head_produce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(process, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void but_home1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_home1ActionPerformed
        this.process.removeAll();
        this.process.add(welcomePanel);
        this.process.updateUI();
    }//GEN-LAST:event_but_home1ActionPerformed

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

    private void but_signin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_signin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_but_signin1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartButtonActionPerformed
        this.process.removeAll();
        this.process.add(cartPanel);
        cartPanel.updateCartList(stagedBookList);
        this.process.updateUI();
    }//GEN-LAST:event_cartButtonActionPerformed

    private void but_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_search1ActionPerformed
        String bookName = this.searchBar.getText();
        
    }//GEN-LAST:event_but_search1ActionPerformed

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_discovery1;
    private javax.swing.JButton but_home1;
    private javax.swing.JButton but_search1;
    private javax.swing.JButton but_signin1;
    private javax.swing.JButton cartButton;
    private javax.swing.JPanel head_produce;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel process;
    private javax.swing.JTextField searchBar;
    // End of variables declaration//GEN-END:variables
}


// Với cấu hình cổng A là cổng vào, B là cổng ra và tất cả các bits của cổng C cấu hình như lối vào
//TÌm địa chỉ cổng gán cho A, B, C 
//b. tìm ba điều khiển cho cấu hình này của 8255
//c. viết chương trình để đọc dữ liệu từ cổng A và gửi dữ liệu này ra cổng B và cổng C