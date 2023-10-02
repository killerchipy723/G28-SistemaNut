
package Accesos;

import Entidades.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PacienteData {
   public void cargarPaciente(Paciente paciente){
       Connection con = Conexion.Conectar();       
       String sql = "INSERT INTO paciente (dni,apellido,nombre,domicilio,telefono,estado)VALUES(?,?,?,?,?,?)";
       try {
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setInt(1,paciente.getDni());
           pst.setString(2, paciente.getApellido());
           pst.setString(3, paciente.getNombre());
           pst.setString(4, paciente.getDomicilio());
           pst.setString(5, paciente.getTelefono());
           pst.setBoolean(6, paciente.getEstado());
           pst.executeUpdate();
           
       } catch (SQLException ex) {
           Logger.getLogger(PacienteData.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }
}
