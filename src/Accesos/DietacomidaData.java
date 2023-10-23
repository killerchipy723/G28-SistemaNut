/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accesos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author scscl
 */
public class DietacomidaData {
    
    Connection con = Conexion.Conectar();
   public void modificarDieta(JTextField pObtenido,JComboBox estado,JTextField paci){
       int id = Integer.parseInt(paci.getText());
       String state = (String)estado.getSelectedItem();
       String sql = "UPDATE dieta SET pesoObtenido=?,estado=? WHERE idDieta="+id+"";
      
        try {
            
            PreparedStatement pst = con.prepareStatement(sql);   
             pst.setDouble(1, Double.parseDouble(pObtenido.getText()));           
            pst.setString(2, state);
            System.out.println(""+state);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro Actualizado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectar a la tabla dieta");
        }
   } 
}
