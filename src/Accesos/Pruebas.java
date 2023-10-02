
package Accesos;

import Entidades.Paciente;
import java.sql.Connection;


public class Pruebas  {
    public static void main(String args[]){
        Paciente paciente = new Paciente(23675432,"Perez","Mariela","Las Heras","345-87655",true);
        PacienteData pd = new PacienteData();
        pd.cargarPaciente(paciente);
        
        
}
}

