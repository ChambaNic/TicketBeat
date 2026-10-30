package modelo;

public class Evento {
    private int idEvento;
    private String nombre;
    private String descripcion;
    private String tipoMusica;
    private String estado;

    public Evento(int idEvento, String nombre, String descripcion, String tipoMusica, String estado) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoMusica = tipoMusica;
        this.estado = estado;
    }

    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoMusica() {
        return tipoMusica;
    }

    public String getEstado() {
        return estado;
    }
}
