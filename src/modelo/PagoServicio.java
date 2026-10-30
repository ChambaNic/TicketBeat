package modelo;

import interfaces.Ipagador;

public class PagoServicio {

    private final IPagador pagador;   // -pagador: IPagador

    public PagoServicio(IPagador pagador) {
        this.pagador = pagador;
    }

    public boolean ejecutarPago(double monto) {
        if (pagador == null || monto <= 0) return false;
        return pagador.pagar(monto);
    }
}
