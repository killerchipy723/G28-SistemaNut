
package Accesos;

import Entidades.Dietas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class DietasVariasData {
    Connection con = Conexion.Conectar();
    
    
    public void agregarDietas(String nombre){
        
       
      String sql = "INSERT INTO dietasvarias (nombre) VALUES (?)"; 
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,nombre);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"El registro se Guardó correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar con la tabla dietasvarias"+ex);
        }
      
    }
    public void llenarComboDietas(JComboBox dieta){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
  
        String sql = "SELECT id_Dieta,nombre FROM dietasvarias";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                      Dietas dietas = new Dietas();
               dietas.setIdDieta(rs.getInt("id_Dieta"));
               dietas.setNombre(rs.getString("nombre"));
               
                
                modelo.addElement(dietas.getNombre());
               dieta.setModel(modelo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al Conectar a la BD dietasvarias" +ex);
        }
    }
    public void capturarDieta(JTextField dieta,String cap){
        dieta.setText(cap);
        String SQL = "SELECT nombre FROM dietasvarias WHERE nombre ="+cap+"";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(DietasVariasData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
