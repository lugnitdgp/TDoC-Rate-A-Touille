/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;
import rms.models.user;
import rms.resources.UserDbHandler;
import rms.screens.Login;
import rms.screens.StaffPanel;
/**
 *
 * @author asus
 */
public class RMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Login u = new Login();
        u.setVisible(true);
        
        
    }
    
}
