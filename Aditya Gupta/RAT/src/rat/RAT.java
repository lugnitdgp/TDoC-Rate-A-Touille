/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat;
import rat.models.MenuItem;
import rar.resources.MenuDbHandler;
/**
 *
 * @author Aditya
 */
public class RAT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MenuDbHandler mdbh = new MenuDbHandler();
        mdbh.AddToMenu("Butter Chicken", 80.0, 0, 0);
    }
    
}
