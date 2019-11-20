/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author ADMIN
 */

class User{
    private String username;

    public User(String username, String password, int user_id) {
        this.username = username;
        this.password = password;
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getUser_id() {
        return user_id;
    }
    private String password;
    private int user_id;
}