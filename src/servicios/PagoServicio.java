package servicios;

import interfaces.IPagador;

public class PagoServicio {

    private final IPagador pagador;  

    public PagoServicio(IPagador pagador) {
        this.pagador = pagador;
    }

    public boolean ejecutarPago(double monto) {
        if (pagador == null || monto <= 0) return false;
        return pagador.pagar(monto);
    }
}
