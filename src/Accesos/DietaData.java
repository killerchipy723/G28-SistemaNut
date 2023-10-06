/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accesos;

import Entidades.Dieta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author scscl
 */
public class DietaData {
    Connection con=Conexion.Conectar();
    
    public void cargarDieta(Dieta dieta){
        String sql="INSERT INTO dieta (nombre,idPaciente, fechaInicial, pesoInicial,pesoFinal,fechaFinal, estado) VALUES(?,?,?,?,?,?,?)";
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
    
    
    
    
}
