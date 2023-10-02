
package Entidades;


public class DietaComida {
    
   private int idDietaComida;
   private Comidas idComida;
   private Dieta idDieta;
   private boolean estado;

    public DietaComida(int idDietaComida, Comidas idComida, Dieta idDieta, boolean estado) {
        this.idDietaComida = idDietaComida;
        this.idComida = idComida;
        this.idDieta = idDieta;
        this.estado = estado;
    }

    public DietaComida(Comidas idComida, Dieta idDieta, boolean estado) {
        this.idComida = idComida;
        this.idDieta = idDieta;
        this.estado = estado;
    }

    public DietaComida() {
    }

    public int getIdDietaComida() {
        return idDietaComida;
    }

    public void setIdDietaComida(int idDietaComida) {
        this.idDietaComida = idDietaComida;
    }

    public Comidas getIdComida() {
        return idComida;
    }

    public void setIdComida(Comidas idComida) {
        this.idComida = idComida;
    }

    public Dieta getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(Dieta idDieta) {
        this.idDieta = idDieta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "DietaComida{" + "idDietaComida=" + idDietaComida + ", idComida=" + idComida + ", idDieta=" + idDieta + ", estado=" + estado + '}';
    }
   
   
   
    
}
