package modelo;

import java.time.LocalDateTime;

import interfaces.IPagador;
import servicios.PagoServicio;

public class Pago {

    private int idPago;
    private double monto;
    private LocalDateTime fecha;
    private String estado;

    private final PagoServicio servicio;

    public Pago(int idPago, double monto, IPagador pagador) {
        this.idPago = idPago;
        this.monto = monto;
        this.fecha = LocalDateTime.now();
        this.estado = "PENDIENTE";
        this.servicio = new PagoServicio(pagador);
    }

    public boolean procesarPago() {
        boolean exito = servicio.ejecutarPago(monto);
        this.estado = exito ? "PAGADO" : "RECHAZADO";
        this.fecha = LocalDateTime.now();
        return exito;
    }

    public boolean reembolsar() {
        if (!"PAGADO".equals(estado)) return false;
        this.estado = "REEMBOLSADO";
        System.out.println("Se ha realizado un reembolso de $" + monto + ".");
        return true;
    }

    public int getIdPago(){ 
        return idPago; 
    }
    
    public double getMonto(){ 
        return monto; 
    }
    
    public LocalDateTime getFecha(){ 
        return fecha; 
    }
    
    public String getEstado(){ 
        return estado;
    }

}
