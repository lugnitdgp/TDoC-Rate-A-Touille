
package rat;
import rat.models.Staff;
import rat.models.MenuItem;
import rat.resources.DbHandler;
/**
 *
 * @author RUP <your.name at your.org>
 */
public class RAT 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        DbHandler ob=new DbHandler();
        boolean value=ob.connection();
        System.out.println(value);
               //Staff s1=new Staff(1,"Manager",30,50000.00);
               //s1.setSalary(75000.00);
               //s1.displayDetails();
               
               //MenuItem m1=new MenuItem(1,"Butter Chicken",300.00);
               //m1.setName("Butter Paneer");
              // m1.displayDetails();
              boolean status =ob.insert("Rajas");
    }
    
}
