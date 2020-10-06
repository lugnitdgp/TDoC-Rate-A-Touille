/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.models;
import java.security.SecureRandom;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Rishabh
 */
public class Utils {
      public static String encryptPassword (String password, String salt){
            String encryptPass = null;
            try{
                    MessageDigest md = MessageDigest.getInstance("SHA-512");
                    md.update(salt.getBytes(StandardCharsets.UTF_8));
                    byte[] byteData;
                    byteData = md.digest(password.getBytes(StandardCharsets.UTF_8));
                    StringBuilder hashCodeBuffer = new StringBuilder();
                    for (byte i : byteData) {
                        hashCodeBuffer.append(Integer.toString((i & 0xff) + 0x100, 16).substring(1));
                    }
                    encryptPass = hashCodeBuffer.toString();
            }
            catch(NoSuchAlgorithmException ex){
                    System.out.println(ex);
                    }
            return encryptPass;
            }
      
      public static String genRandomSalt(){
          SecureRandom random = new SecureRandom();
          String genSalt = random.ints(48, 122 + 1)
                  .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >=97))
                  .limit(10)
                  .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                  .toString();
          return genSalt;
      }
}
