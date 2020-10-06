/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.models;
import java.util.ArrayList;
/**
 *
 * @author pakhe
 */
public class order {
    private int id;
    private String timePlaced;
    private ArrayList<MenuItem> items;
    public order(int id, String timePlaced,ArrayList<MenuItem> items){
        this.id=id;
        this.timePlaced=timePlaced;
        this.items=items;
    }
    public void DisplayDetails()
    {
        System.out.println(id+" "+timePlaced);
        for(MenuItem mi :items )
        {
            mi.DisplayDetails();
        }
    }
    
    
}
