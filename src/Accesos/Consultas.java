
package Accesos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
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
}
