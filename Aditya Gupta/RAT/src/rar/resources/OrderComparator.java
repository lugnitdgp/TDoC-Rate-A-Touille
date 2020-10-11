/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rar.resources;

import java.util.Comparator;
import rat.models.Order;

/**
 *
 * @author Aditya
 */
public class OrderComparator implements Comparator<Order>{
    @Override
    public int compare(Order o1, Order o2){
        
        if(o1.getpriority() < o2.getpriority()){
            return 1;
        }
        else if(o1.getpriority() > o2.getpriority()){
            return -1;
        }
        return 0;
    }
}
