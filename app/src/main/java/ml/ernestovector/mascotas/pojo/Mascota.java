package ml.ernestovector.mascotas.pojo;

public class Mascota {

//---Atributos--------------------------------------------------------------------------------------
    private int foto;
    private String nombre;
    private String rate;

//---Constructor------------------------------------------------------------------------------------
    public Mascota(int foto, String nombre, String rate){
        this.foto = foto;
        this.nombre = nombre;
        this.rate = rate;
    }

//---Getters y Setters------------------------------------------------------------------------------

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
