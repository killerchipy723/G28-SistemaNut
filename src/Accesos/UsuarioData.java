
package Accesos;

import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UsuarioData {
    
    Connection con = Conexion.Conectar();
    
    
    public void validar(JTextField usuario,JPasswordField clave){
        Usuario user = new Usuario();
       String sql = "SELECT usuario,clave FROM usuarios WHERE usuario =? AND clave = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,usuario.getText());
            pst.setString(2,String.valueOf(clave.getPassword()));
            ResultSet rs =pst.executeQuery();
            if(rs.next()){
              JOptionPane.showMessageDialog(null,  "Acceso Correcto");
            }else{
                JOptionPane.showMessageDialog(null,  "No se esncotro ningun usuario con los datos ingresados ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,  "Error al conectar a la tabla Usuarios "+ex);
                    }
    }
    
}
