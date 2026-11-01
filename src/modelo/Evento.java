package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private int idEvento;
    private String nombre;
    private String descripcion;
    private String tipoMusica;
    private String estado;
    private String artista;
    private List<Funcion> funciones = new ArrayList<>();

    public Evento(int idEvento, String nombre, String descripcion, String tipoMusica, String estado, String artista) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoMusica = tipoMusica;
        this.estado = estado;
        this.artista = artista;
    }

    public Evento() {
        this.funciones = new ArrayList<>();
    }

    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("El estado del evento '" + nombre + "' ha sido actualizado a: " + nuevoEstado);
    }

    public void agregarFuncion(Funcion funcion) {
        if (funcion != null) {
            funciones.add(funcion);
        }
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoMusica() {
        return tipoMusica;
    }

    public void setTipoMusica(String tipoMusica) {
        this.tipoMusica = tipoMusica;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public List<Funcion> getFunciones() {
        return funciones;
    }

    public void setFunciones(List<Funcion> funciones) {
        this.funciones = funciones;
    }
}    
