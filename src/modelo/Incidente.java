package modelo;

import java.time.LocalDateTime;

/**
 * PARTE 4 - Incidente reportado por un Comprador.
 * Relaciones: Comprador 1 ---- 0..* Incidente
 *             Incidente 0..* ---- 0..1 Reserva
 */
public class Incidente {

    private int idIncidente;
    private String descripcion;
    private LocalDateTime fechaReporte;
    private String estado;
    private String solucion;

    private final Comprador comprador;
    private Reserva reserva;

    public Incidente(int idIncidente, String descripcion, Comprador comprador) {
        this.idIncidente = idIncidente;
        this.descripcion = descripcion;
        this.comprador = comprador;
        this.fechaReporte = LocalDateTime.now();
        this.estado = "ABIERTO";
        this.solucion = "";
        if (comprador != null) {
            comprador.registrarIncidente(this);   // requiere ese metodo en Comprador
        }
    }

    public void asociarReserva(Reserva reserva) { this.reserva = reserva; }

    /** Visibilidad de paquete: solo AgenteSoporte y AdministracionEvento mueven el estado. */
    void setEstado(String estado)     { this.estado = estado; }
    void setSolucion(String solucion) { this.solucion = solucion; }

    public int getIdIncidente()             { return idIncidente; }
    public String getDescripcion()          { return descripcion; }
    public LocalDateTime getFechaReporte()  { return fechaReporte; }
    public String getEstado()               { return estado; }
    public String getSolucion()             { return solucion; }
    public Comprador getComprador()         { return comprador; }
    public Reserva getReserva()             { return reserva; }
}
