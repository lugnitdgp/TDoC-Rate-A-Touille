/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import rms.models.MenuItem;
import rms.models.Order;
import rms.resources.DbHandler;
import rms.resources.MenuDbHandler;
import rms.resources.OrdersDbHandler;
import rms.resources.staffDbHandler;
import static rms.resources.utils.arrangeOrders;
import rms.screens.app_Screen;
import rms.screens.*;
/**
 *
 * @author rammy
 */
public class RMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                loginStaff_screen app=new loginStaff_screen();
                app.setVisible(true);
            }
            
        });
//            staffDbHandler ob1=new staffDbHandler();
//            boolean a=ob1.registerStaff("david", "12345", 45, 60000.00);
    }
    
}
