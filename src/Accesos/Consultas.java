
package Accesos;

import Entidades.Dieta;
import Entidades.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Consultas {
   Connection con = Conexion.Conectar();
   public void consultar(JTable lista,JComboBox listaDieta,JTable listaComidas){
       Object select = listaDieta.getSelectedIndex()+1;
       int selectedRow = listaComidas.getSelectedRow();
       DefaultTableModel modelo = new DefaultTableModel();
       String sql = "SELECT dc.idDietaComida, c.nombre, c.detalle\n" +
        "FROM dietacomida dc\n" +
        "JOIN comida c ON dc.idComida = c.idComida\n" +
        "WHERE dc.idDieta ="+select+"";
       try {
           Statement pst = con.createStatement();
           ResultSet rs = pst.executeQuery(sql);
//           pst.setString(3, tablaMaterias.getValueAt(selectedRow, 0).toString());
       } catch (SQLException ex) {
           Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   public void llenarTablaTratamiento(JTable grid){
       int selectedRow = grid.getSelectedRow();
       DefaultTableModel modelo = new DefaultTableModel();
       String sql = "SELECT * FROM dieta ";
       try {
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(sql);
           modelo.setColumnIdentifiers(new Object[]{"ID","NOMB.DIETA","ID.PACIENTE","F.INICIAL","PESO.INI","PESO.BUSC","PESO,OBT","F.FINAL","ESTADO"});
           while(rs.next()){
               modelo.addRow(new Object[]{
                rs.getInt("idDieta"),
                    rs.getString("nombre"),  
                    rs.getInt("idPaciente"),  
                    rs.getString("fechaInicial"),  
                    rs.getInt("pesoInicial"),  
                    rs.getInt("pesoFinal"),  
                    rs.getInt("pesoObtenido"), 
                    rs.getString("fechaFinal"), 
                    rs.getString("estado")});
           }
           grid.setModel(modelo);
       } catch (SQLException ex) {
           Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
       }
       
      
   }
    public void pacienteOk(JTable JT){
        DefaultTableModel model = new DefaultTableModel();
        
           String SQL = "SELECT p.idPaciente, p.nombre, p.apellido,d.pesoInicial,d.pesoFinal,d.pesoObtenido\n" +
                        "FROM paciente p\n" +
                        "JOIN dieta d ON p.idPaciente = d.idPaciente\n" +
                        "WHERE d.pesoObtenido <= d.pesoFinal;";
       try {
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while(rs.next()){
            model.setColumnIdentifiers(new Object[]{"ID","NOMBRE PACIENTE","APELLIDO","PESO.INI","PESO.BUSC","PESO,OBT",});
             model.addRow(new Object[]{
                rs.getInt("idPaciente"),
                    rs.getString("nombre"),  
                    rs.getString("apellido"),                     
                    rs.getDouble("pesoInicial"),  
                    rs.getDouble("pesoFinal"),                    
                     rs.getDouble("pesoObtenido")});
           }
           JT.setModel(model);
       } catch (SQLException ex) {
           Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
       }
       }
    
    
     public void pacienteNO(JTable JT){
        DefaultTableModel model = new DefaultTableModel();
        
           String SQL = "SELECT p.idPaciente, p.nombre, p.apellido,d.pesoInicial,d.pesoFinal,d.pesoObtenido\n" +
                        "FROM paciente p\n" +
                        "JOIN dieta d ON p.idPaciente = d.idPaciente\n" +
                        "WHERE d.pesoObtenido >= d.pesoFinal;";
       try {
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while(rs.next()){
            model.setColumnIdentifiers(new Object[]{"ID","NOMBRE PACIENTE","APELLIDO","PESO.INI","PESO.BUSC","PESO,OBT",});
             model.addRow(new Object[]{
                rs.getInt("idPaciente"),
                    rs.getString("nombre"),  
                    rs.getString("apellido"),                     
                    rs.getDouble("pesoInicial"),  
                    rs.getDouble("pesoFinal"),                    
                     rs.getDouble("pesoObtenido")});
           }
           JT.setModel(model);
       } catch (SQLException ex) {
           Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
       }
       }
     
      public void pacienteActivo(JTable JT){
        DefaultTableModel model = new DefaultTableModel();
        
           String SQL = "SELECT p.idPaciente, p.nombre, p.apellido,d.pesoInicial,d.pesoFinal,d.pesoObtenido\n" +
                        "FROM paciente p\n" +
                        "JOIN dieta d ON p.idPaciente = d.idPaciente\n" +
                        "WHERE d.estado = 'Activo';";
       try {
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while(rs.next()){
            model.setColumnIdentifiers(new Object[]{"ID","NOMBRE PACIENTE","APELLIDO","PESO.INI","PESO.BUSC","PESO,OBT",});
             model.addRow(new Object[]{
                rs.getInt("idPaciente"),
                    rs.getString("nombre"),  
                    rs.getString("apellido"),                     
                    rs.getDouble("pesoInicial"),  
                    rs.getDouble("pesoFinal"),                    
                     rs.getDouble("pesoObtenido")});
           }
           JT.setModel(model);
       } catch (SQLException ex) {
           Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
       }
       }
      
      
      
      public void buscarPcDni(int dni,JComboBox JC){
          ArrayList<Object> modelo = new ArrayList<>();
          DefaultComboBoxModel modcombo = new DefaultComboBoxModel();
          String SQL = "SELECT * FROM paciente WHERE dni ="+dni+" OR idPaciente = "+dni+"";
       try {
           PreparedStatement pst = con.prepareStatement(SQL);
           ResultSet rs = pst.executeQuery();
           while(rs.next()){              
           Paciente paciente = new Paciente();
           paciente.setIdPaciente(rs.getInt("idPaciente"));
           paciente.setDni(rs.getInt("dni"));
           paciente.setApellido(rs.getString("apellido"));
           paciente.setNombre(rs.getString("nombre"));
           paciente.setDomicilio(rs.getString("domicilio"));
           paciente.setTelefono(rs.getString("telefono"));
           
               
               modelo.add(rs.getInt("idPaciente"));
               modelo.add(rs.getInt("dni"));
               modelo.add(rs.getString("apellido"));
               modelo.add(rs.getString("nombre"));
               modelo.add(rs.getString("domicilio"));
               modelo.add(rs.getString("telefono"));
               modelo.add(rs.getString("estado"));
       
            modcombo.addElement(paciente.getIdPaciente()+"-"+paciente.getApellido()+", "+paciente.getNombre());
           }
           JC.setModel(modcombo);
       } catch (SQLException ex) {
           Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
       }
}
      
      public void consultaTratamientoxDNI(int id,JTextField nom,JTextField fechI,JTextField pesI,JTextField pesB,JTextField pesO,JTextField fechaF,JComboBox estado){
          String sql = "SELECT nombre,fechaInicial,pesoInicial,pesoFinal,pesoObtenido,fechaFinal,estado FROM dieta WHERE idPaciente = "+id+"";
       try {
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(sql);
           while(rs.next()){
               Dieta dieta = new Dieta();
          
               nom.setText(rs.getString("nombre"));
               fechI.setText(String.valueOf(rs.getDate("fechaIncial")));
               pesI.setText(String.valueOf(rs.getString("pesoInicial")));
               pesB.setText(String.valueOf(rs.getString("pesoFinal")));
               pesO.setText(String.valueOf(rs.getString("pesoObtenido")));
               fechaF.setText(String.valueOf(rs.getString("fechaFinal")));
               estado.setSelectedItem(rs.getString("estado"));
           }
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"No se puede acceder a la tabla dieta");
       }
      }
      
      
      
}

