
package rat.resources;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.PriorityQueue;
import rat.models.Order;

/* 
steps:
1.generate salt
2.generate message digest instance
3.run the digest method and store in byte array and append to string builder
4.convert to string builder

*/
public class Utils {
    public static String encryptPassword(String password,String salt){
        String encryptedPassword=null;
        try{
            MessageDigest md=MessageDigest.getInstance("SHA-512");//creates an instance of sha-512
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte bytes[]=md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb=new StringBuilder();
            for(byte b:bytes){
                sb.append(Integer.toString((b & 0xff) +0x100, 16).substring(1));
            }
            encryptedPassword=sb.toString();
            
            
        }catch(NoSuchAlgorithmException ex){
            ex.printStackTrace();
            
        }
        return encryptedPassword;
        
    }
    public static String getRandomSalt(){//generates 10 char random salrt
        SecureRandom random=new SecureRandom();
        String genSalt=random.ints(48,123)//creates a stream of integers b/w 48 and 122
                .filter(i->(i<=57 || i>=65)&& (i<=90 || i>=97)) //filter out all the letters and characters
                .limit(10)
                .collect(StringBuilder ::new,StringBuilder::appendCodePoint,StringBuilder::append)//stringbuilder helps to build a string from int stream
                .toString();
        return genSalt;
        
    }
    //arrange orders based on priority
    public ArrayList arrangeOrders(ArrayList<Order> orders){
        ArrayList<Order> finalOrders=new ArrayList<>();
        PriorityQueue<Order> pq=new PriorityQueue<>(10,new OrderComparator());//10 is the default size it dosent matter
        //by default a pq matches the first field ie in this case itit id but we want the priorities to be compared 
        //so we are passing the comparator class func..
        for(Order order:orders){
            pq.add(order);
        }
        while(!pq.isEmpty()){
            finalOrders.add(pq.poll());
        }
        return finalOrders;
        
    }
    
}
//WE ARE USING PR TO IMPROVE TC..
