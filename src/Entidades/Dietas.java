
package Entidades;


public class Dietas {
    private int idDieta;
    private String nombre;
    private String estado;

    public Dietas() {
    }

    public Dietas(int idDieta, String nombre, String estado) {
        this.idDieta = idDieta;
        this.nombre = nombre;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Dietas{" + "idDieta=" + idDieta + ", nombre=" + nombre + ", estado=" + estado + '}';
    }
    
    
    
    
    
}
