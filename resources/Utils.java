package resources;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

// encrypted password and random salt

public class Utils {

    public static String encryptSHA(String pass, String salt) {
        String encrypt = "";
        try {
            // SHA-512 algorithm
            MessageDigest mDigest = MessageDigest.getInstance("SHA-512");
            mDigest.update(salt.getBytes(StandardCharsets.UTF_8));
            byte bytes[] = mDigest.digest(pass.getBytes(StandardCharsets.UTF_8));
            StringBuffer sb = new StringBuffer();
            for (byte bit : bytes) {
                sb.append(Integer.toString((bit & 0xff) * 0x100, 16).substring(1));
            }
            encrypt = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypt;
    }

    public static String genRandomSalt() {
        /*
         * generate 10-character random salt using SecureRandom class of java.security
         */

        SecureRandom random = new SecureRandom();
        String salt = random.ints(48, 123).filter(asc -> (asc <= 57 || asc >= 65) && (asc <= 90 || asc >= 97)).limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        return salt;

    }

}
