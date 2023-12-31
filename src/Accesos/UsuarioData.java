
package Accesos;

import Entidades.Usuario;
import Interfaces.formPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UsuarioData {
    
    Connection con = Conexion.Conectar();
    
    
    
    public void validar(JTextField usuario,JPasswordField clave,JLabel user){
 
        formPrincipal frm = new formPrincipal();
       String sql = "SELECT nombre,apellido,usuario,clave FROM usuarios WHERE usuario =? AND clave = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,usuario.getText());
            pst.setString(2,String.valueOf(clave.getPassword()));            
            ResultSet rs =pst.executeQuery();
            if(rs.next()){          
                String nom = rs.getString("nombre");
                String ape = rs.getString("apellido");
                String users = nom+" "+ape;
                user.setText(nom+" "+ape);
              JOptionPane.showMessageDialog(null,  "Bienvenido Usuario: "+nom+" "+ape);
            }else{
                JOptionPane.showMessageDialog(null,  "No se esncotro ningun usuario con los datos ingresados ");
                System.exit(0);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,  "Error al conectar a la tabla Usuarios "+ex);
                    }
    }

    public void modificarPaciente(JTextField ape,JTextField nom,JTextField dom,JTextField tel,JComboBox estado,JTextField dni){
    boolean estadio = false;

    String sql ="UPDATE paciente SET apellido =?, nombre=?, domicilio=?,telefono=?,estado=? WHERE dni =?";
        try {
       
      
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,ape.getText());
            pst.setString(2,nom.getText());
            pst.setString(3,dom.getText());
            pst.setString(4,tel.getText());
            pst.setString(5,estado.getSelectedItem().toString());
            pst.setString(6,dni.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"El Paciente Fue Actualizado");
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioData.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public void RegistrarUsuario(JTextField ape,JTextField nom,JTextField user, JPasswordField clave1){
      String sql = "INSERT INTO usuarios(apellido,nombre,usuario,clave)VALUES(?,?,?,?)";
      try {
        String pass = String.valueOf(clave1.getPassword());
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,ape.getText());
        pst.setString(2, nom.getText());
        pst.setString(3,user.getText());
        pst.setString(4, pass); 
        
          pst.executeUpdate();
         
      } catch (SQLException ex) {
        Logger.getLogger(UsuarioData.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    
    
}
