package modelo;

import interfaces.IPoliticaDevolucion;
import java.time.LocalDateTime;

public class PoliticaDevolucion implements IPoliticaDevolucion {

    private int idPolitica;
    private int plazoDias;
    private boolean permiteDevolucion;
    private boolean permiteIntercambio;

    public PoliticaDevolucion(int idPolitica, int plazoDias,boolean permiteDevolucion, boolean permiteIntercambio) {
        this.idPolitica = idPolitica;
        this.plazoDias = plazoDias;
        this.permiteDevolucion = permiteDevolucion;
        this.permiteIntercambio = permiteIntercambio;
    }

    @Override
    public boolean esDevolucionPermitida() {
        return permiteDevolucion;
    }

    @Override
    public boolean esIntercambioPermitido() {
        return permiteIntercambio;
    }

    // Verifica que la solicitud entre dentro del plazo en dias de la politica. 
    public boolean dentroDelPlazo(LocalDateTime fechaCompra, LocalDateTime fechaSolicitud) {
        return !fechaSolicitud.isAfter(fechaCompra.plusDays(plazoDias));
    }

    public int getIdPolitica() { return idPolitica; }
    public int getPlazoDias()   { return plazoDias; }
}
