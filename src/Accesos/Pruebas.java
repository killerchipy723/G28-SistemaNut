package Accesos;

import Entidades.Comida;
import Entidades.Dieta;
import Entidades.Paciente;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;

public class Pruebas {

    public static void main(String args[]) {
////        pruebas pacienteData
//           Paciente paciente = new Paciente(32723567,"Albornoz","Claudia","Moron 345","345-23655",true);
//           PacienteData pd = new PacienteData();
//       pd.cargarPaciente(paciente);
//        //   pd.modificarPaciente(paciente);
////        
//        Paciente paciente2= new Paciente(4573345,"IBANEZ","Anahi","Puyrredon","355-62766",true);
//             PacienteData pd2=new PacienteData();
//        pd2.cargarPaciente(paciente2);

//     System.out.println(pd2.buscarPacientexDni(345678));
//     System.out.println(pd.buscarPacientexDni(23675432));
        // pd.darDeBaja(1);
        //   System.out.println(pd2.listarPacientes());
        
        
        
        //puebas clase comidaData
//         Comida com1= new Comida("Pollo","pechuga a la plancha", 350, true);
        //ComidaData cd = new ComidaData();
//
//        Comida com2 = new Comida("Manzana", "manzana verde", 52, true);
//     Comida com3=new Comida("Granola","mix de granos",471,true);
//     
//     cd.cargarComidas(com1);
//     cd.cargarComidas(com2);
//     cd.cargarComidas(com3);

//        cd.ModificarComida(com2);
//        System.out.println(cd.buscarComidaxNombre("pollo"));
//
//         System.out.println(cd.listarComidas());
//           System.out.println(cd.comidasSegunCalorias(355));
        
        
        //pruebas dietaData
        
        PacienteData pd=new PacienteData();
        DietaData dd= new DietaData();
        Paciente susana= pd.buscarPacientexDni(23675432);
        //Dieta luna=new Dieta("dieta de la luna",susana,LocalDate.of(2023, 10, 5),99.0,85.5,LocalDate.of(2024, 3, 10),true);
        //dd.cargarDieta(luna);
        //System.out.println(dd.buscardietaPorNombre(" luna"));
        
        Dieta luna=new Dieta(1,"dieta de la luna llena",susana,LocalDate.of(2023, 10, 5),99.0,70.0, LocalDate.of(2024, 5, 10),true);
        dd.modificarDieta(luna);
    }
}
