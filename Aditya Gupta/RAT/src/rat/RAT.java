/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat;
import rat.models.*;
import rar.resources.*;
import java.util.*;
/**
 *
 * @author Aditya
 */
public class RAT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // MenuDbHandler mdbh = new MenuDbHandler();
       // mdbh.AddToMenu("Paneer Butter Masala", 90.0, 0, 0);
        StaffDbHandler sdbh = new StaffDbHandler();
        //sdbh.registerStaff("Aditya", "5498", 18, 10000);
        ArrayList<Staff> staff = new ArrayList<Staff>();
        staff = sdbh.getStaffList();
        System.out.println(staff);
    }
    
}
