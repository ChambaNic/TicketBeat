package modelo;

public class Comprador {
    private int idComprador;
    private String nombre;
    private String correo;

    public Comprador(int idComprador, String nombre, String correo) {
        this.idComprador = idComprador;
        this.nombre = nombre;
        this.correo = correo;
    }

    public int getIdComprador() {
        return idComprador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
