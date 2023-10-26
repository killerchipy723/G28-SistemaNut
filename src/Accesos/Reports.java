
package Accesos;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Reports {
    Consultas consultas = new Consultas();
    DefaultTableModel modelo;
    Connection con = Conexion.Conectar();
   
    
    public void reporteDieta() throws IOException{
        try {
           String sql = "SELECT * from dieta";
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(sql);
        Document documento = new Document(PageSize.LEGAL.rotate());         
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(documento,new FileOutputStream(ruta+"/Desktop/Rep_Tratamiento.pdf"));        
        documento.open();        
        Paragraph paragraph = new Paragraph("REPORTE DE TRATAMIENTO DE PACIENTES");
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);        
        paragraph.setSpacingBefore(20); // Espacio antes del párrafo en puntos
        paragraph.setSpacingAfter(20);  // Espacio después del 
        documento.add(paragraph);
        
            
            PdfPTable tabla = new PdfPTable(8);
            
            tabla.setWidthPercentage(100);
            tabla.addCell("ID");
            tabla.addCell("Dieta");
            tabla.addCell("ID_Pac");
            tabla.addCell("F_Inical");
            tabla.addCell("P_Inicial");
            tabla.addCell("P_Buscado");
            tabla.addCell("P_Obtenido");
            tabla.addCell("F_Final");
            
            if(rs.next()){
                do{
                 tabla.addCell(rs.getString(1));
                 tabla.addCell(rs.getString(2));
                  tabla.addCell(rs.getString(3));
                   tabla.addCell(rs.getString(4));
                    tabla.addCell(rs.getString(5));
                     tabla.addCell(rs.getString(6));
                      tabla.addCell(rs.getString(7));
                       tabla.addCell(rs.getString(8));
                       tabla.setSpacingBefore(10f);
                      
                }while(rs.next());
              documento.add(tabla);
            }
            documento.close();
            JOptionPane.showMessageDialog(null,"Reporte Generado");
            File Rep_Tratamiento = new File(ruta+"/Desktop/Rep_Tratamiento.pdf");
       Desktop.getDesktop().open(Rep_Tratamiento);
       Desktop.getDesktop();
        } catch (DocumentException | HeadlessException | FileNotFoundException | SQLException e) {
        }
        
        
        
        
    }
    //REPORTE DE PACIENTES QUE LLEGARON AL PESO BUSCADO
    
    public void repPacLlegaron() throws DocumentException, FileNotFoundException, IOException{
       String SQL = "SELECT p.idPaciente, p.nombre, p.apellido,d.pesoInicial,d.pesoFinal,d.pesoObtenido\n" +
                        "FROM paciente p\n" +
                        "JOIN dieta d ON p.idPaciente = d.idPaciente\n" +
                        "WHERE d.pesoObtenido <= d.pesoFinal;";
      try {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(SQL);
        Document documento = new Document(PageSize.A4.rotate());         
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(documento,new FileOutputStream(ruta+"/Desktop/Rep_PacOK.pdf"));        
        documento.open();
        
        Paragraph paragraph2 = new Paragraph("CENTRO INTEGRAL DE NUTRICION - DRA FERNANDA SALAZAR");                
        paragraph2.setSpacingBefore(20); // Espacio antes del párrafo en puntos
        paragraph2.setSpacingAfter(20);  // Espacio después del 
        documento.add(paragraph2);
        
        Paragraph paragraph = new Paragraph("REPORTE DE PACIENTES QUE LLEGARON AL PESO BUSCADO");
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);        
        paragraph.setSpacingBefore(20); // Espacio antes del párrafo en puntos
        paragraph.setSpacingAfter(20);  // Espacio después del 
        documento.add(paragraph);
        
        
        PdfPTable tabla = new PdfPTable(6);
            
            tabla.setWidthPercentage(100);
            tabla.addCell("ID");
            tabla.addCell("Nombre Paciente");
            tabla.addCell("Apellido");
            tabla.addCell("Peso Inicial");
            tabla.addCell("Peso Buscado");
            tabla.addCell("Peso Obtenido");
            
        if(rs.next()){
          
          do{
                 tabla.addCell(rs.getString(1));
                 tabla.addCell(rs.getString(2));
                  tabla.addCell(rs.getString(3));
                   tabla.addCell(rs.getString(4));
                    tabla.addCell(rs.getString(5));
                     tabla.addCell(rs.getString(6));                      
                }while(rs.next());
          documento.add(tabla);         
        }
        
        documento.close();
       JOptionPane.showMessageDialog(null,"Reporte Generado Correctamente");
       File Rep_PacOK = new File(ruta+"/Desktop/Rep_PacOK.pdf");
       Desktop.getDesktop().open(Rep_PacOK);
       Desktop.getDesktop();
      } catch (SQLException ex) {
        Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    //REPORTE DE PACIENTES QUE NO LLEGARON AL PRECIO BUSCADO
    public void repPacNOLlegaron() throws DocumentException, FileNotFoundException, IOException{
       String SQL = "SELECT p.idPaciente, p.nombre, p.apellido,d.pesoInicial,d.pesoFinal,d.pesoObtenido\n" +
                        "FROM paciente p\n" +
                        "JOIN dieta d ON p.idPaciente = d.idPaciente\n" +
                        "WHERE d.pesoObtenido >= d.pesoFinal;";
      try {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(SQL);
        Document documento = new Document(PageSize.A4.rotate());         
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(documento,new FileOutputStream(ruta+"/Desktop/Rep_PacNO.pdf"));        
        documento.open();  
        Paragraph paragraph2 = new Paragraph("CENTRO INTEGRAL DE NUTRICION - DRA FERNANDA SALAZAR");                
        paragraph2.setSpacingBefore(20); // Espacio antes del párrafo en puntos
        paragraph2.setSpacingAfter(20);  // Espacio después del 
        documento.add(paragraph2);
        Paragraph paragraph = new Paragraph("REPORTE DE PACIENTES QUE NO LLEGARON AL PESO BUSCADO");
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);        
        paragraph.setSpacingBefore(20); // Espacio antes del párrafo en puntos
        paragraph.setSpacingAfter(20);  // Espacio después del 
        documento.add(paragraph);
        PdfPTable tabla = new PdfPTable(6);
            
            tabla.setWidthPercentage(100);
            tabla.addCell("ID");
            tabla.addCell("Nombre Paciente");
            tabla.addCell("Apellido");
            tabla.addCell("Peso Inicial");
            tabla.addCell("Peso Buscado");
            tabla.addCell("Peso Obtenido");
            
        if(rs.next()){
          
          do{
            tabla.addCell(rs.getString(1));
                 tabla.addCell(rs.getString(2));
                  tabla.addCell(rs.getString(3));
                   tabla.addCell(rs.getString(4));
                    tabla.addCell(rs.getString(5));
                     tabla.addCell(rs.getString(6));                     
                }while(rs.next());
          documento.add(tabla);         
        }
        documento.close();
        JOptionPane.showMessageDialog(null,"Reporte Generado Correctamente");
       File Rep_PacNO = new File(ruta+"/Desktop/Rep_PacNO.pdf");
       Desktop.getDesktop().open(Rep_PacNO);
       Desktop.getDesktop();
      } catch (SQLException ex) {
        Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
     public void repPacActivos() throws DocumentException, FileNotFoundException, IOException{
       String SQL = "SELECT p.idPaciente, p.nombre, p.apellido,d.pesoInicial,d.pesoFinal,d.pesoObtenido\n" +
                        "FROM paciente p\n" +
                        "JOIN dieta d ON p.idPaciente = d.idPaciente\n" +
                        "WHERE d.estado = 'Activo';";
      try {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(SQL);
        Document documento = new Document(PageSize.A4.rotate());         
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(documento,new FileOutputStream(ruta+"/Desktop/Rep_Activo.pdf"));        
        documento.open();  
        Paragraph paragraph2 = new Paragraph("CENTRO INTEGRAL DE NUTRICION - DRA FERNANDA SALAZAR");                
        paragraph2.setSpacingBefore(20); // Espacio antes del párrafo en puntos
        paragraph2.setSpacingAfter(20);  // Espacio después del 
        documento.add(paragraph2);
        Paragraph paragraph = new Paragraph("REPORTE DE PACIENTES CON TRATAMIENTO ACTIVO");
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);        
        paragraph.setSpacingBefore(20); // Espacio antes del párrafo en puntos
        paragraph.setSpacingAfter(20);  // Espacio después del 
        documento.add(paragraph);
        PdfPTable tabla = new PdfPTable(6);
            
            tabla.setWidthPercentage(100);
            tabla.addCell("ID");
            tabla.addCell("Nombre Paciente");
            tabla.addCell("Apellido");
            tabla.addCell("Peso Inicial");
            tabla.addCell("Peso Buscado");
            tabla.addCell("Peso Obtenido");
            
        if(rs.next()){
          
          do{
              tabla.addCell(rs.getString(1));
                 tabla.addCell(rs.getString(2));
                  tabla.addCell(rs.getString(3));
                   tabla.addCell(rs.getString(4));
                    tabla.addCell(rs.getString(5));
                     tabla.addCell(rs.getString(6));                     
                }while(rs.next());
          documento.add(tabla);         
        }
        documento.close();
        JOptionPane.showMessageDialog(null,"Reporte Generado Correctamente");
       File Rep_Activo = new File(ruta+"/Desktop/Rep_Activo.pdf");
       Desktop.getDesktop().open(Rep_Activo);
       Desktop.getDesktop();
      } catch (SQLException ex) {
        Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
}
