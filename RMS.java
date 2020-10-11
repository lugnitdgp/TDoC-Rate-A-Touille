/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

import rms.frontend.AppScreen;
import rms.frontend.Login;
import rms.resources.DbHandler;
import rms.resources.MenuDbHandler;
import rms.resources.UsersDbHandler;

public class RMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         DbHandler dbH = new DbHandler();

        boolean status = dbH.isConnected();

        System.out.println(status);
        
//        UsersDbHandler ob=new UsersDbHandler();
//        ob.registerStaff("Soumitri", "1234", 20, 100000.00);
//        ob.registerStaff("Sreejit", "mav00", 25, 1000000.00);
//        ob.registerStaff("Sattam","qwerty",23,100000.00);
        
//        Login ob=new Login();
//        Login.main(new String[]{""});

//        MenuDbHandler menu=new MenuDbHandler();
//        menu.addToMenu("Butter Naan", 55.00, 100, 2, 2);
//        menu.addToMenu("Pulao", 175.00, 100, 5, 3);
//        menu.addToMenu("Chicken Biryani", 185.00, 100, 6, 5);
//        menu.addToMenu("Shahi Paneer",210.00,100,5,5);
//        menu.addToMenu("Mixed CHowmein",160.00,100,4,3);
//        menu.addToMenu("Chili FIsh", 190.00,100,7,5);

        AppScreen.main(new String[]{""});

    }
    
}
