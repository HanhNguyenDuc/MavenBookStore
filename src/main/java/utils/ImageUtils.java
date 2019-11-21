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

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Image;

class ImageUtils{
    public static Image getImage(String path, int width, int height){
        Image img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    }

    public static void main(String args[]){
        getImage("resources/img/73566751_p0.jpg", 100, 100);
    }
}
