/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Script;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author asus
 */
public class AP_Database {
    
    public static Connection con;
    
    public static void koneksi(){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_watergo?user=root&password=");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Koneksi Terputus");
            System.exit((0));
        }
    }
}
