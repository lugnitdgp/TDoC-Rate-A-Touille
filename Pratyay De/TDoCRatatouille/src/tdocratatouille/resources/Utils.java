/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdocratatouille.resources;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;
import tdocratatouille.models.Order;

/**
 *
 * @author Divyo
 */
public class Utils {
    
    public static String encryptPassword(String password,String salt){
        String encryptedPassword = null;
        
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();    
            for(byte aByte : bytes){
                sb.append(Integer.toString((aByte & 0xff) + 0x100,16).substring(1));
            }
            
            encryptedPassword = sb.toString();
        }
        
        catch(NoSuchAlgorithmException e){
            System.out.println(e);
        }
    return encryptedPassword;
}
       
    public static String genRandomSalt(){
        
        SecureRandom random = new SecureRandom();
        String genSalt = random.ints(48,122 + 1)
            .filter(i -> (i <=57 || i>=65) && (i <=90 || i>=97))
            .limit(10)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
        
        return genSalt;
    }
    
    public static ArrayList arrangeOrders(ArrayList<Order> orders){
        
        ArrayList<Order> arrangedOrders = new ArrayList();
        
        PriorityQueue<Order> pq = new PriorityQueue<Order>(10,new OrderComparator());
        
        for(Order order : orders){
            pq.add(order);
        }
        
        while(!pq.isEmpty()){
            arrangedOrders.add(pq.poll());
        }
        
        return arrangedOrders;
        
    }

}