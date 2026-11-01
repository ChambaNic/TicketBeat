package modelo;

import interfaces.IPoliticaDevolucion;

public class DevolucionServicio {

    private final IPoliticaDevolucion politica;

    public DevolucionServicio(IPoliticaDevolucion politica) {
        this.politica = politica;
    }

    /** Operacion del diagrama: procesarDevolucion(solicitud): boolean */
    public boolean procesarDevolucion(SolicitarDevolucion solicitud) {
        if (solicitud == null) return false;
        if (!politica.esDevolucionPermitida()) {
            solicitud.setEstado("RECHAZADA");
            System.out.println("[DevolucionServicio] Devolucion no permitida por la politica.");
            return false;
        }
        if (solicitud.getCompra() != null) {
            solicitud.getCompra().cancelarCompra();
        }
        solicitud.setEstado("APROBADA");
        System.out.println("[DevolucionServicio] Devolucion #" + solicitud.getIdSolicitud() + " aprobada.");
        return true;
    }

    /** Operacion del diagrama: procesarIntercambio(solicitud): boolean */
    public boolean procesarIntercambio(SolicitarDevolucion solicitud) {
        if (solicitud == null) return false;
        if (!politica.esIntercambioPermitido()) {
            solicitud.setEstado("RECHAZADA");
            System.out.println("[DevolucionServicio] Intercambio no permitido por la politica.");
            return false;
        }
        if (solicitud.getBoleto() != null) {
            solicitud.getBoleto().cancelar();
        }
        solicitud.setEstado("INTERCAMBIADA");
        System.out.println("[DevolucionServicio] Intercambio #" + solicitud.getIdSolicitud() + " aprobado.");
        return true;
    }
}
