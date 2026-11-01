package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Funcion {
    private int idFuncion;
    private LocalDateTime fecha;
    private String localidad;
    private String estado;
    private List<Boleto> boletos = new ArrayList<>();

    public Funcion(int idFuncion, LocalDateTime fecha, String localidad, String estado) {
        this.idFuncion = idFuncion;
        this.fecha = fecha;
        this.localidad = localidad;
        this.estado = estado;
    }

    public Funcion() {
        this.boletos = new ArrayList<>();
    }

    public void agregarBoleto(Boleto boleto) {
        if (boleto != null) {
            boletos.add(boleto);
        }
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getEstado() {
        return estado;
    }

    void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }
}
