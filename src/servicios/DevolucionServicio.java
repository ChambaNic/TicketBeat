package servicios;

import interfaces.IPoliticaDevolucion;
import modelo.SolicitarDevolucion;

public class DevolucionServicio {

    private final IPoliticaDevolucion politica;

    public DevolucionServicio(IPoliticaDevolucion politica) {
        this.politica = politica;
    }

    public boolean procesarDevolucion(SolicitarDevolucion solicitud) {
        if (solicitud == null) return false;
        if (!politica.esDevolucionPermitida()) {
            solicitud.setEstado("RECHAZADA");
            System.out.println("La devolucion no esta permitida por la politica establecidas.");
            return false;
        }
        if (solicitud.getCompra() != null) {
            solicitud.getCompra().cancelarCompra();
        }
        solicitud.setEstado("APROBADA");
        System.out.println(" Devolucion #" + solicitud.getIdSolicitud() + " aprobada.");
        return true;
    }

    public boolean procesarIntercambio(SolicitarDevolucion solicitud) {
        if (solicitud == null) return false;
        if (!politica.esIntercambioPermitido()) {
            solicitud.setEstado("RECHAZADA");
            System.out.println("El intercambio no esta permitido por la politica establecidas.");
            return false;
        }
        if (solicitud.getBoleto() != null) {
            solicitud.getBoleto().cancelar();
        }
        solicitud.setEstado("INTERCAMBIADA");
        System.out.println("Intercambio #" + solicitud.getIdSolicitud() + " aprobado.");
        return true;
    }
}
