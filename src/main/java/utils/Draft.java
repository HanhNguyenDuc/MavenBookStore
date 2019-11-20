/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class Draft extends JFrame{
    private JPanel jp;
    public Draft(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Book book = new Book(10, "Sach giao khoa", "Kim dong", 2017, 30000, "resources/img/book_icon.png");
        this.setSize(500, 500);
        jp = new CartPanel();
        this.setMinimumSize(jp.getPreferredSize());
        this.add(jp);
    }
    public static void main(String[] args) {
        Draft d = new Draft();
        d.show();
    }
}
