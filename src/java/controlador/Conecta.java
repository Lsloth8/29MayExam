
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author sthefanyconza
 */
public class Conecta {
    
    
     public static Connection getConexion(String usu,String pas, String url) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// Driver depende de la BD
            //establece la conexión
            con = (Connection) DriverManager.getConnection(url, usu, pas);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            //System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
    
    
    
}
