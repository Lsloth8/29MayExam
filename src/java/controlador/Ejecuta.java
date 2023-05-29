/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Ejecuta {
    
         public static ResultSet devuelveRS(String consulta,String usu,
             String pas, String cad)
     {
         
         
        Connection con=Conecta.getConexion(usu,pas,cad);
       
         ResultSet rs=null;
         
            try {
                Statement st=con.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                // ResultSet es donde se guarda el resultado de la consulta
                rs=st.executeQuery(consulta);
                return rs;
            } catch (SQLException ex) {
                //System.out.println("Error: "+ex.getMessage());
                JOptionPane.showMessageDialog(null,ex.getMessage());
                return null;
            }
          
        } 
    
    
}
