
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "ServletUsuCon/" , urlPatterns = {"/ServletUsuCon"})
public class ServletUsuCon extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //getParameter recibe un parámetro
        String usuario=request.getParameter("usuario");
        String password=request.getParameter("password");
        
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("El usuario es: "+usuario);
        out.println("<br>El password es: "+password);
        out.println("</br>");
        
       
       ResultSet rs=Ejecuta.devuelveRS("Select * from seguridad "
               + "where usuario='"+usuario+"' and password ='"+password+"';","root", "kjdlchuli5", 
                "jdbc:mysql://localhost:3306/bd_exa_mf0490");
       
        try {
            rs.next();
            if (rs.getRow()==1)
               out.println("Gracias por utilizar nuestros servicios");
            
            else
             out.println("Usuario o Password incorrecta");
             out.println("</body>");
             out.println("</html>");
            
        } catch (SQLException ex) {
            Logger.getLogger(ServletUsuCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
