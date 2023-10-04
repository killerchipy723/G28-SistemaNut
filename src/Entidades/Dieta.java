
package Entidades;

import java.sql.Date;
import java.time.LocalDate;

public class Dieta {
   private int idDieta;
   private String nombre;
   private Paciente idPaciente;
   private LocalDate fechaInicial;
   private double pesoInicial;
   private double pesoFinal;
   private LocalDate fechaFinal;
   private boolean estado;

    public Dieta() {
    }

    public Dieta(int idDieta, String nombre, Paciente idPaciente, LocalDate fechaInicial, double pesoInicial, double pesoFinal, LocalDate fechaFinal, boolean estado) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.idPaciente = idPaciente;
        this.fechaInicial = fechaInicial;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
    }

    public Dieta(String nombre, Paciente idPaciente, LocalDate fechaInicial, double pesoInicial, double pesoFinal, LocalDate fechaFinal, boolean estado) {
        this.nombre = nombre;
        this.idPaciente = idPaciente;
        this.fechaInicial = fechaInicial;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Dieta{" + "idDieta=" + idDieta + ", nombre=" + nombre + ", idPaciente=" + idPaciente + ", fechaInicial=" + fechaInicial + ", pesoInicial=" + pesoInicial + ", pesoFinal=" + pesoFinal + ", fechaFinal=" + fechaFinal + ", estado=" + estado + '}';
    }

    
   
   
   
   
}
