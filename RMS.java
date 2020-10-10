/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

import rms.resources.DbHandler;
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
        
        UsersDbHandler ob=new UsersDbHandler();
        ob.registerStaff("Soumitri", "1234", 21, 10000.00);
        ob.registerStaff("Sreejit","mav00", 22, 6900.00);

    }
    
}
