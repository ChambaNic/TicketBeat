package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reserva {

    private int idReserva;
    private LocalDateTime fechaReserva;
    private LocalDateTime fechaExpiracion;
    private String estado;
    private int cantidadBoletos;

    private final Comprador comprador;
    private final List<Boleto> boletos = new ArrayList<>();  // 0..*

    Reserva(int idReserva, int cantidadBoletos, int horasVigencia, Comprador comprador) {
        this.idReserva = idReserva;
        this.cantidadBoletos = cantidadBoletos;
        this.comprador = comprador;
        this.fechaReserva = LocalDateTime.now();
        this.fechaExpiracion = this.fechaReserva.plusHours(horasVigencia);
        this.estado = "ACTIVA";
    }

    public boolean agregarBoleto(Boleto boleto) {
        if (!"ACTIVA".equals(estado)) return false;
        if (boletos.size() >= cantidadBoletos) return false;
        if (!boleto.reservar()) return false;
        boletos.add(boleto);
        return true;
    }

    public boolean estaVencida() {
        return LocalDateTime.now().isAfter(fechaExpiracion);
    }

    public void expirar() {
        if (!"ACTIVA".equals(estado)) return;
        for (Boleto b : boletos) {
            b.liberar();
        }
        this.estado = "EXPIRADA";
        System.out.println("La reserva#" + idReserva + " ha expirada y los boletos fueron liberados.");
    }

    public void confirmar() {
        this.estado = "CONFIRMADA";
    }

    public int getIdReserva(){ 
        return idReserva; 
    }
    
    public LocalDateTime getFechaReserva(){ 
        return fechaReserva;
    }
    
    public LocalDateTime getFechaExpiracion(){ 
        return fechaExpiracion; 
    }
    
    public String getEstado(){ 
        return estado; 
    }
    
    public int getCantidadBoletos(){ 
        return cantidadBoletos; 
    }
    
    public Comprador getComprador(){ 
        return comprador; 
    }
    
    public List<Boleto> getBoletos(){ 
        return Collections.unmodifiableList(boletos);
    }

}
