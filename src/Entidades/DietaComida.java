
package Entidades;


public class DietaComida {
    
   private int idDietaComida;
   private Comida idComida;
   private Dieta idDieta;
   private boolean estado;

    public DietaComida(int idDietaComida, Comida idComida, Dieta idDieta, boolean estado) {
        this.idDietaComida = idDietaComida;
        this.idComida = idComida;
        this.idDieta = idDieta;
        this.estado = estado;
    }

    public DietaComida(Comida idComida, Dieta idDieta, boolean estado) {
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

    public Comida getIdComida() {
        return idComida;
    }

    public void setIdComida(Comida idComida) {
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

  
   
    
}
