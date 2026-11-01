package modelo;

import java.time.LocalDateTime;

public class SolicitarDevolucion {

    private int idSolicitud;
    private String motivo;
    private String tipoSolicitud;   // "DEVOLUCION" o "INTERCAMBIO"
    private String estado;
    private LocalDateTime fechaSolicitada;

    private final Comprador comprador;
    private Compra compra;
    private Boleto boleto;

    SolicitarDevolucion(int idSolicitud, String motivo, String tipoSolicitud, Comprador comprador) {
        this.idSolicitud = idSolicitud;
        this.motivo = motivo;
        this.tipoSolicitud = tipoSolicitud;
        this.comprador = comprador;
        this.estado = "PENDIENTE";
        this.fechaSolicitada = LocalDateTime.now();
    }

    public void asociarCompra(Compra compra) { this.compra = compra; }
    public void asociarBoleto(Boleto boleto) { this.boleto = boleto; }

    void setEstado(String estado) { this.estado = estado; }

    public int getIdSolicitud()                { return idSolicitud; }
    public String getMotivo()                  { return motivo; }
    public String getTipoSolicitud()           { return tipoSolicitud; }
    public String getEstado()                  { return estado; }
    public LocalDateTime getFechaSolicitada()  { return fechaSolicitada; }
    public Comprador getComprador()            { return comprador; }
    public Compra getCompra()                  { return compra; }
    public Boleto getBoleto()                  { return boleto; }
}
