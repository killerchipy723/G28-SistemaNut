/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accesos;

import Entidades.Comida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author scscl
 */
public class ComidaData {
    Connection con= Conexion.Conectar();
    
    public void cargarComidas(Comida comida){
        String sql="INSERT INTO comida (nombre, detalle, cantCalorias, estado) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, comida.getNombre());
            ps.setString (2, comida.getDetalle());
            ps.setInt(3, comida.getCantCalorias());
            ps.setBoolean(4, true);
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se pudo conectar a la tabla comida");
        }
        
    }
    
    public void ModificarComida(Comida com){
        String sql="UPDATE comida SET nombre=?,detalle=?,cantCalorias=?,estado=? WHERE idComida=?";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1,com.getNombre());
            ps.setString (2, com.getDetalle());
            ps.setInt(3, com.getCantCalorias());
            ps.setBoolean(4, true);
            ps.setInt(5, com.getIdComida());
            int exito= ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "se modifico correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "no se pudo modificar la comida");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se pudo acceder a la tabla Comida");
        }
        
    }
    public Comida buscarComidaxNombre(String nombre){
        String sql="SELECT * FROM comida WHERE nombre=?";
        Comida comida=null;
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
              comida=new Comida();
              comida.setIdComida(rs.getInt("idComida"));
              comida.setNombre(rs.getString("nombre"));
              comida.setDetalle(rs.getString("detalle"));
              comida.setCantCalorias(rs.getInt("cantCalorias"));
              comida.setEstado(rs.getBoolean("estado"));
            }else{
                JOptionPane.showMessageDialog(null, "no se encontro la comida");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se pudo conectar a la tabla comida");
        }
        return comida;
    }
    
    public List<Comida> listarComidas (){
        ArrayList<Comida> listComidas= new ArrayList <>();
        String sql="SELECT * FROM comida WHERE estado =1";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Comida comida=new Comida();
                comida.setIdComida(rs.getInt("idComida"));
                comida.setNombre(rs.getString("nombre"));
              comida.setDetalle(rs.getString("detalle"));
              comida.setCantCalorias(rs.getInt("cantCalorias"));
              comida.setEstado(rs.getBoolean("estado"));    
                listComidas.add(comida);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se pudo conectar a la tabla comida");
        }
        return listComidas;
    }
    public void cambiarEstado (int id){
         try {
            String sql = "UPDATE comida SET estado = 0 WHERE idComida = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se dio de baja la comida");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla comida");
        }
    } 
    public List<Comida> comidasSegunCalorias(int calorias){
        ArrayList<Comida> listCalorias=new ArrayList<>();
         String sql="SELECT * FROM comida WHERE cantCalorias < ?";   
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, calorias);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Comida comida=new Comida();
                comida.setIdComida(rs.getInt("idComida"));
                comida.setNombre(rs.getString("nombre"));
              comida.setDetalle(rs.getString("detalle"));
              comida.setCantCalorias(rs.getInt("cantCalorias"));
              comida.setEstado(rs.getBoolean("estado"));    
                listCalorias.add(comida);
            }
            ps.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, " Error al acceder a la tabla comida");
        }
        return listCalorias;
    } 
    
}
