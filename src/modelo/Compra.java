package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import enumeraciones.EstadoCompra;
import interfaces.IPagador;

public class Compra {

    private int idCompra;
    private LocalDateTime fecha;
    private double total;
    private EstadoCompra estado;

    private final Comprador comprador;
    private final List<Boleto> boletos = new ArrayList<>();  // 0..*
    private Pago pago;                                       // 0..1

    Compra(int idCompra, Comprador comprador) {
        this.idCompra = idCompra;
        this.comprador = comprador;
        this.fecha = LocalDateTime.now();
        this.estado = EstadoCompra.PENDIENTE;
        this.total = 0.0;
    }

    public void agregarBoleto(Boleto boleto) {
        if (estado != EstadoCompra.PENDIENTE) {
            System.out.println(" No se puede agregar boletos a una compra que no esta pendiente:  " + estado);
            return;
        }
        boletos.add(boleto);
        calcularTotal();
    }

    public double calcularTotal() {
        double suma = 0.0;
        for (Boleto b : boletos) {
            suma += b.getPrecio();
        }
        this.total = suma;
        return this.total;
    }

    public void confirmarCompra() {
        if (estado != EstadoCompra.PENDIENTE) return;
        if (pago == null || !"PAGADO".equals(pago.getEstado())) {
            System.out.println("No se puede confirmar la compra sin un pago aprobado previamente.");
            return;
        }
        this.estado = EstadoCompra.CONFIRMADA;
        generarBoletos();
        System.out.println("Compra #" + idCompra + " confirmada correctamente por un total de $" + total);
    }

    public void cancelarCompra() {
        if (estado == EstadoCompra.CANCELADA) return;
        for (Boleto b : boletos) {
            b.cancelar();
        }
        if (pago != null) {
            pago.reembolsar();
        }
        this.estado = EstadoCompra.CANCELADA;
        System.out.println("La compra #" + idCompra + " ha sido cancelada.");
    }

    public List<Boleto> generarBoletos() {
        List<Boleto> emitidos = new ArrayList<>();
        for (Boleto b : boletos) {
            if (b.vender()) {
                emitidos.add(b);
            }
        }
        return emitidos;
    }

    public boolean registrarPago(int idPago, IPagador formaDePago) {
        calcularTotal();
        this.pago = new Pago(idPago, total, formaDePago);
        return this.pago.procesarPago();
    }

    public int getIdCompra(){ 
        return idCompra; 
    }
    public LocalDateTime getFecha(){ 
        return fecha; 
        }
    public double getTotal(){
         return total; 
    }
    public EstadoCompra getEstado(){ 
        return estado; 
    }
    public Comprador getComprador()  { 
        return comprador; 
    }
    public Pago getPago(){ 
        return pago; 
    }
    public List<Boleto> getBoletos() { return Collections.unmodifiableList(boletos); }
}
