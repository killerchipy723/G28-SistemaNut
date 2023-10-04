
package Accesos;

import Entidades.Comida;
import Entidades.Paciente;
import java.sql.Connection;


public class Pruebas  {
    public static void main(String args[]){
        //pruebas pacienteData
   //  Paciente paciente = new Paciente(23675432,"Perez","Mariela","Las Heras","345-87655",true);
   //   PacienteData pd = new PacienteData();
//       pd.cargarPaciente(paciente);
//        
//        
//        Paciente paciente2= new Paciente(345678,"Lopez","Juan","San Luis","2664-62766",true);
       PacienteData pd2=new PacienteData();
//        pd2.cargarPaciente(paciente2);
        
//     System.out.println(pd2.buscarPacientexDni(345678));
//     System.out.println(pd.buscarPacientexDni(23675432));
        
     //   System.out.println(pd2.listarPacientes());
        
    // pd.darDeBaja(1);
     
     //puebas clase comidaData
    // Comida com1= new Comida("Pollo","pechuga a la plancha", 350, true);
     ComidaData cd= new ComidaData();
     
//     Comida com2=new Comida("Manzana","manzana roja",52,true);
//     Comida com3=new Comida("Granola","mix de granos",471,true);
//     
//     cd.cargarComidas(com1);
//     cd.cargarComidas(com2);
//     cd.cargarComidas(com3);

        //System.out.println(cd.buscarComidaxNombre("manzana"));
        
       // System.out.println(cd.listarComidas());
        
        System.out.println(cd.comidasSegunCalorias(355));
}
}

