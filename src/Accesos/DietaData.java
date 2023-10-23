/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accesos;

import Entidades.Comida;
import Entidades.Dieta;
import Entidades.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author scscl
 */
public class DietaData {
    private PacienteData pd= new PacienteData();
    Connection con=Conexion.Conectar();
    
    public void cargarDieta(Dieta dieta){
        String sql="INSERT INTO dieta (nombre,idPaciente, fechaInicial, pesoInicial,pesoFinal,pesoObtenido,fechaFinal, estado)"
                + " VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, dieta.getNombre());
            ps.setInt(2, dieta.getIdPaciente().getIdPaciente());
            ps.setDate(3, Date.valueOf(dieta.getFechaInicial()));
            ps.setDouble(4, dieta.getPesoInicial());
            ps.setDouble(5, dieta.getPesoFinal());
            ps.setDate(6, Date.valueOf(dieta.getFechaFinal()));
            ps.setBoolean(7, dieta.isEstado());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DietaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void listaDieta(JComboBox lista){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        String sql = "SELECT id_Dieta,nombre FROM dietasvarias";
        Statement pst;
        try {
            pst = con.createStatement();
             ResultSet rs = pst.executeQuery(sql);
             while(rs.next()){
                 Dieta dieta = new Dieta();
              dieta.setIdDieta(rs.getInt("id_Dieta"));
              dieta.setNombre(rs.getString("nombre"));
               
              modelo.addElement(dieta.getIdDieta()+" - "+dieta.getNombre());
             
              lista.setModel(modelo);
            
             }
             
             
        } catch (SQLException ex) {
            Logger.getLogger(DietaData.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public Dieta buscardietaPorNombre(String nombre){
       
     Dieta dieta = null;
 String sql = "SELECT * FROM dieta WHERE nombre=? AND estado = 1";
 PreparedStatement ps = null;
 try {
 ps = con.prepareStatement(sql);
 ps.setString(1,nombre );
 ResultSet rs = ps.executeQuery();

 if (rs.next()) {
     
 dieta =new Dieta();
 
            dieta.setIdDieta(rs.getInt("idDieta"));
            dieta.setNombre(rs.getString("nombre"));
            dieta.setFechaInicial(rs.getDate("fechaInicial").toLocalDate());
            dieta.setPesoInicial(rs.getDouble("pesoInicial"));
            dieta.setPesoFinal(rs.getDouble("pesoFinal"));
            dieta.setFechaFinal(rs.getDate("fechaFinal").toLocalDate());
            dieta.setEstado(rs.getBoolean("estado"));
            
            
            

 } else {
 JOptionPane.showMessageDialog(null, "No existe la dieta"); 

}
 ps.close();
} catch (SQLException ex) {
 JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dieta "+ex.getMessage());
}

return dieta;   
        
        
    }
   
    
    public void modificarDieta(Dieta dieta){
        String sql="UPDATE dieta SET nombre=?, idPaciente=?, fechaInicial=?, pesoInicial=?, pesoFinal=?, fechaFinal=?, estado=? WHERE idDieta=?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, dieta.getNombre());
            ps.setInt(2, dieta.getIdPaciente().getIdPaciente());
            ps.setDate(3, Date.valueOf(dieta.getFechaInicial()));
            ps.setDouble(4, dieta.getPesoInicial());
            ps.setDouble(5, dieta.getPesoFinal());
            ps.setDate(6, Date.valueOf(dieta.getFechaFinal()));
            ps.setBoolean(7, true);
            ps.setInt(8, dieta.getIdDieta());
            
            int exito= ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "la dieta se modifico");
            }else{
                JOptionPane.showMessageDialog(null, "no se encontro la dieta");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se pudo acceder a la tabla dieta");
        }
        
    }
  public List<Dieta> listarDietas(){
      ArrayList<Dieta> listaDietas= new ArrayList <>();
      String sql="SELECT * FROM dieta WHERE estado =1";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Dieta dieta=new Dieta();
                dieta.setIdDieta(rs.getInt("idDieta"));
                dieta.setNombre(rs.getString("nombre"));
                Paciente pac= pd.buscarPacientexId(rs.getInt("idPaciente"));
                dieta.setIdPaciente(pac);
                dieta.setFechaInicial(rs.getDate("fechaInicial").toLocalDate());
                dieta.setPesoInicial(rs.getDouble("pesoInicial"));
                dieta.setPesoFinal(rs.getDouble("pesoFinal"));
                dieta.setFechaFinal(rs.getDate("fechaFinal").toLocalDate());
                dieta.setEstado(rs.getBoolean("estado"));
                listaDietas.add(dieta);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se pudo acceder a la tabla dieta");
        }
    return listaDietas; 
  }
  public List<Paciente> listaPacientesNoLlegan(double pesoActual, LocalDate fechaFinal){
      ArrayList <Paciente> listaPacientes= new ArrayList<> ();
      String sql="SELECT dieta.idPaciente, dni, apellido, paciente.nombre FROM dieta, paciente WHERE dieta.idPaciente= paciente.idPaciente AND"
              + " dieta.fechaFinal=? AND dieta.pesoFinal<?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fechaFinal));
            ps.setDouble(2, pesoActual);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Paciente pac= new Paciente();
                pac.setIdPaciente(rs.getInt("idPaciente"));
                pac.setDni(rs.getInt("dni"));
                pac.setApellido(rs.getString("apellido"));
                pac.setNombre(rs.getString("nombre"));
                listaPacientes.add(pac);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DietaData.class.getName()).log(Level.SEVERE, null, ex);
        }
     return listaPacientes;  
  }
 public void regTratamiento(JTextField nombre,JComboBox pac,JTextField fInicial,JTextField pInicial,JTextField pFinal,JTextField pObtenido,JTextField fFinal,JComboBox estado){
     String sql="INSERT INTO dieta (nombre,idPaciente, fechaInicial, pesoInicial,pesoFinal,pesoObtenido,fechaFinal, estado)"
             + " VALUES(?,?,?,?,?,?,?,?)";
        try {
            int paciente = pac.getSelectedIndex();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nombre.getText());
            pst.setInt(2,paciente+1);
            pst.setDate(3, Date.valueOf(fInicial.getText()));
            pst.setDouble(4, Double.parseDouble(pInicial.getText()));
            pst.setDouble(5, Double.parseDouble(pFinal.getText()));
             pst.setDouble(6, Double.parseDouble(pObtenido.getText()));
            pst.setDate(7, Date.valueOf(fFinal.getText()));
            pst.setString(8, estado.getSelectedItem().toString());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro Guardado Exitosamente");
            
            
        
        
        
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null,"Error al Conectar a la tabla Dieta"+ex.toString());
        }
        
        
       
        
}
 
 public void modificarTratamiento(){
     
 }
 
 
}

//Se necesita listar los pacientes que a la fecha de fin no han llegado al peso buscado.