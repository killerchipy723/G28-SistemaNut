
package Accesos;

import Entidades.Paciente;
import java.sql.Connection;


public class Pruebas  {
    public static void main(String args[]){
   //  Paciente paciente = new Paciente(23675432,"Perez","Mariela","Las Heras","345-87655",true);
      PacienteData pd = new PacienteData();
//       pd.cargarPaciente(paciente);
//        
//        
//        Paciente paciente2= new Paciente(345678,"Lopez","Juan","San Luis","2664-62766",true);
       PacienteData pd2=new PacienteData();
//        pd2.cargarPaciente(paciente2);
        
//     System.out.println(pd2.buscarPacientexDni(345678));
//     System.out.println(pd.buscarPacientexDni(23675432));
        
     //   System.out.println(pd2.listarPacientes());
        
     pd.darDeBaja(1);
}
}

