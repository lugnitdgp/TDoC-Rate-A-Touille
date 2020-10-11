/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms.resources;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import rms.models.Orders;

// encrypted password and random salt
// arranging orders by priority queue implementation

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

    public static ArrayList<Orders> arrangeOrdersByPriority(ArrayList<Orders> orders) {

        ArrayList<Orders> sorted = new ArrayList<>();

        PriorityQueue<Orders> pq = new PriorityQueue<>(new Comparator<Orders>() {
            @Override
            public int compare(Orders o1, Orders o2) {
                return (int) (o2.getPriority() - o1.getPriority()); // max heap
            }
        });

        // inserting into the heap
        for (Orders order : orders)
            pq.add(order);

        // retrieving the sorted orders
        while (!pq.isEmpty()) {
            sorted.add(pq.poll());
        }

        return sorted;
    }
    
}
