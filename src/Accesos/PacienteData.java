
package Accesos;

import Entidades.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PacienteData {
    Connection con = Conexion.Conectar(); 
    
   public void cargarPaciente(Paciente paciente){
             
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
   public Paciente buscarPacientexDni (int dni){
       Connection con= Conexion.Conectar();
       Paciente paciente= null;
       String sql="SELECT * FROM paciente WHERE dni=? AND estado=1";
       try {
           PreparedStatement ps= con.prepareStatement(sql);
           ps.setInt(1, dni);
           
           
           ResultSet rs= ps.executeQuery();
           if(rs.next()){
            
//            paciente.setIdAlumno(rs.getInt("idAlumno"));
//            alumno.setDni(rs.getInt("dni"));
//            alumno.setApellido(rs.getString("apellido"));
//            alumno.setNombre(rs.getString("nombre"));
//            alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
//            alumno.setActivo(true);
//          
           paciente = new Paciente();
           paciente.setIdPaciente(rs.getInt("idPaciente"));
           paciente.setDni(rs.getInt("dni"));
           paciente.setApellido(rs.getString("apellido"));
           paciente.setNombre(rs.getString("nombre"));
           paciente.setDomicilio(rs.getString("domicilio"));
           paciente.setTelefono(rs.getString("telefono"));
           paciente.setEstado(true);
        }else{
                JOptionPane.showMessageDialog(null, "no existe ese paciente");
            }
            ps.close();
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "no se pudo establecer la coneccion con la tabla paciente");
       }
       
    return paciente;   
   }
   public Paciente buscarPacientexId(int id){
     Connection con= Conexion.Conectar();
       Paciente paciente= null;
       String sql="SELECT * FROM paciente WHERE idPaciente=? AND estado=1";
       try {
           PreparedStatement ps= con.prepareStatement(sql);
           ps.setInt(1, id);
           
           
           ResultSet rs= ps.executeQuery();
           if(rs.next()){ 
               paciente = new Paciente();
           paciente.setIdPaciente(rs.getInt("idPaciente"));
           paciente.setDni(rs.getInt("dni"));
           paciente.setApellido(rs.getString("apellido"));
           paciente.setNombre(rs.getString("nombre"));
           paciente.setDomicilio(rs.getString("domicilio"));
           paciente.setTelefono(rs.getString("telefono"));
           paciente.setEstado(true);
        }else{
                JOptionPane.showMessageDialog(null, "no existe ese paciente");
            }
            ps.close();
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "no se pudo establecer la coneccion con la tabla paciente");
       }
       
    return paciente;   
           
   }
   public List<Paciente> listarPacientes(){
       ArrayList <Paciente> listaPac= new ArrayList<>();
       String sql="SELECT * FROM paciente WHERE estado=1";
       Connection con= Conexion.Conectar();
       try {
           PreparedStatement ps= con.prepareStatement(sql);
           ResultSet rs= ps.executeQuery();
           while(rs.next()){
               Paciente paciente=new Paciente();
               paciente.setIdPaciente(rs.getInt("idPaciente"));
           paciente.setDni(rs.getInt("dni"));
           paciente.setApellido(rs.getString("apellido"));
           paciente.setNombre(rs.getString("nombre"));
           paciente.setDomicilio(rs.getString("domicilio"));
           paciente.setTelefono(rs.getString("telefono"));
           paciente.setEstado(true);
           listaPac.add(paciente);
           }
           ps.close();
       } catch (SQLException ex) {
           JOptionPane.showInternalMessageDialog(null, "no se pudo conectar a la tabla paciente");
       }
       return listaPac;
   }
   public void modificarPaciente (Paciente pac){
       String sql ="UPDATE paciente SET dni=?,apellido=?,nombre=?,domicilio=?,telefono=?,estado=? WHERE idPaciente=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, pac.getDni());
            ps.setString(2, pac.getApellido());
            ps.setString(3, pac.getNombre());
            ps.setString(4, pac.getDomicilio());
            ps.setString(5, pac.getTelefono());
            ps.setBoolean(6, true);
            ps.setInt(7, pac.getIdPaciente());
            int exito= ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "se modifico el paciente");
            }else{
                JOptionPane.showMessageDialog(null, "el paciente no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se pudo acceder a la tabla paciente");
        }
   }
     public void darDeBaja (int id){
         try {
            String sql = "UPDATE paciente SET estado = 0 WHERE idPaciente = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se dio de baja el paciente");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Paciente");
        }
    }   
   
}
