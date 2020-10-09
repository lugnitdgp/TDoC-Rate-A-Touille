/*
 * ALL THE CREDENTIALS TO THE DATABASE WILL BE STORED IN THIS FILE 
 * AND WILL BE IMPORTED WHENEVER NECESSARY.
 * JDBC is the driver which connects mysql to RAT
 */
package rat;

/**
 *
 * @author P-G
 */
public class StringConstants {
    public static final String DB_URL="jdbc:mysql://localhost:3306/rms?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    public static final String USER="root";
    public static final String PASS="password";
    
    
}
