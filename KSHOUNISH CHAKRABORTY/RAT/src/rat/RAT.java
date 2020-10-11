//we create a separate package RAT.models where we will have all the classes
package rat;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import rat.models.Staff;
import rat.models.MenuItem;
import rat.models.Order;
//import rat.resources.DbHandler;
import rat.resources.OrdersDbHandler;
import rat.resources.UserDbHandler;
import rms.screens.*;

public class RAT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //UserDbHandler obj=new UserDbHandler();
        //System.out.println(obj.loginStaff(name, password));
      /* MenuItem m1=new MenuItem("paneer", 50.0, 1, 1, 2, 3);
         MenuItem m2=new MenuItem("pizza", 150.0, 2, 2, 3, 4);
         ArrayList items=new ArrayList<MenuItem> ();
         items.add(m1);
         items.add(m2);
         OrdersDbHandler ob=new OrdersDbHandler();
         ob.addOrder("10:00", items); */

       /*UserDbHandler ob1=new UserDbHandler();
       ob1.registerStaff("ksh428","1234", 20, 10.0); */
    /*   UserDbHandler ob1=new UserDbHandler();
       ob1.loginStaff("ksh428","1234"); */
        SwingUtilities.invokeLater(new Runnable(){
        @Override 
        public void run(){ 
           login_screen login=new login_screen();
            login.setVisible(true);       
    }
    });
                }
}

                
