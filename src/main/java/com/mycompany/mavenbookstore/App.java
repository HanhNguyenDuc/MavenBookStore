/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenbookstore;
import com.mycompany.mavenbookstore.form.FormNhapDuLieu;
import com.mycompany.mavenbookstore.form.LoginFrame;

/**
 *
 * @author ADMIN
 */
public class App {
    public static void main(String[] args) {
        LoginFrame login = new LoginFrame(null);
        login.show();
    }
}
