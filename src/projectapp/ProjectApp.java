
package projectapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jubae
 */
public class ProjectApp {
    Connection con;

    public static void main(String[] args) {
        new TestjFrame4x1().setVisible(true);
        
        //ProjectApp projectapp1 = new ProjectApp();
       // projectapp1.createconnection();      
    }
    
   /* void createconnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/projectdb", "root", "162157850");
            System.out.println("Connected...");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Not Connected...");
        }
    }*/

}
