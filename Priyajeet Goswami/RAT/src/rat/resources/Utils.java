package rat.resources;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.PriorityQueue;
import java.util.ArrayList;
import rat.models.Order;


public class Utils {
    public static String encryptPassword(String password,String salt){
        String encryptedPassword=null;
        try{
            MessageDigest md=MessageDigest.getInstance("SHA-512");
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
    public static String getRandomSalt(){
        SecureRandom random=new SecureRandom();
        String genSalt=random.ints(48,123)
                .filter(i->(i<=57 || i>=65)&& (i<=90 || i>=97)) 
                .limit(10)
                .collect(StringBuilder ::new,StringBuilder::appendCodePoint,StringBuilder::append)
                .toString();
        return genSalt;
        
    }
    
    public ArrayList arrangeOrders(ArrayList<Order> orders){
        ArrayList<Order> finalOrders=new ArrayList<>();
        PriorityQueue<Order> pq=new PriorityQueue<>(10,new OrderComparator());
        
        for(Order order:orders){
            pq.add(order);
        }
        while(!pq.isEmpty()){
            finalOrders.add(pq.poll());
        }
        return finalOrders;
        
    }
    
}