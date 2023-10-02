
package Accesos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PacienteData {
   public void cargarPaciente(){
       Connection con = Conexion.Conectar();
       String sql = "INSERT INTO paciente (dni,apellido,nombre,telefono,estado)VALUES(?,?,?,?,?)";
       try {
           PreparedStatement pst = con.prepareStatement(sql);
       } catch (SQLException ex) {
           Logger.getLogger(PacienteData.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }
}
