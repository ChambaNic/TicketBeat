package modelo;

import enumeraciones.EstadoBoleto;
import enumeraciones.TipoBoleto;

public class Boleto {
    private int idBoleto;
    private TipoBoleto tipo;
    private double precio;
    private EstadoBoleto estado;
    

    public Boleto(int idBoleto, TipoBoleto tipo, double precio, EstadoBoleto estado) {
        this.idBoleto = idBoleto;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
    }
    

    public Boleto(){
        this.estado = EstadoBoleto.Disponible;
    }

    public boolean reservar() {
        if (estado == EstadoBoleto.Disponible) {
            estado = EstadoBoleto.Reservado;
            return true;
        }
        return false;
    }

    public boolean vender() {
        if (estado == EstadoBoleto.Disponible || estado == EstadoBoleto.Reservado) {
            estado = EstadoBoleto.Vendido;
            return true;
        }
        return false;
    }

    public void liberar() {
        if (estado == EstadoBoleto.Reservado) {
            estado = EstadoBoleto.Disponible;
        }
    }

    public void cancelar() {
        estado = EstadoBoleto.Cancelado;
    }

    public int getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }

    public TipoBoleto getTipo() {
        return tipo;
    }

    public void setTipo(TipoBoleto tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public EstadoBoleto getEstado() {
        return estado;
    }

    public void setEstado(EstadoBoleto estado) {
        this.estado = estado;
    }

}
