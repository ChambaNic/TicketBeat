package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            System.out.println("[Compra] No se puede modificar una compra " + estado);
            return;
        }
        boletos.add(boleto);
        calcularTotal();
    }

    /** Operacion del diagrama: calcularTotal(): double */
    public double calcularTotal() {
        double suma = 0.0;
        for (Boleto b : boletos) {
            suma += b.getPrecio();
        }
        this.total = suma;
        return this.total;
    }

    /** Operacion del diagrama: confirmarCompra(): void */
    public void confirmarCompra() {
        if (estado != EstadoCompra.PENDIENTE) return;
        if (pago == null || !"PAGADO".equals(pago.getEstado())) {
            System.out.println("[Compra] No se puede confirmar sin un pago aprobado.");
            return;
        }
        this.estado = EstadoCompra.CONFIRMADA;
        generarBoletos();
        System.out.println("[Compra] Compra #" + idCompra + " confirmada por $" + total);
    }

    /** Operacion del diagrama: cancelarCompra(): void */
    public void cancelarCompra() {
        if (estado == EstadoCompra.CANCELADA) return;
        for (Boleto b : boletos) {
            b.cancelar();
        }
        if (pago != null) {
            pago.reembolsar();
        }
        this.estado = EstadoCompra.CANCELADA;
        System.out.println("[Compra] Compra #" + idCompra + " cancelada.");
    }

    /** Operacion del diagrama: generarBoletos(): List<Boleto> */
    public List<Boleto> generarBoletos() {
        List<Boleto> emitidos = new ArrayList<>();
        for (Boleto b : boletos) {
            if (b.vender()) {
                emitidos.add(b);
            }
        }
        return emitidos;
    }

    /** Crea y procesa el pago asociado (relacion Compra 1 -- 0..1 Pago). */
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
