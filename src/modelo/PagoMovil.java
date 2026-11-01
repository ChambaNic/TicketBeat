package modelo;

import interfaces.IPagador;

public class PagoMovil implements IPagador {
    @Override
    public boolean pagar(double monto) {
        System.out.println("[PagoMovil] Cobro movil por $" + monto + ".");
        return monto > 0;
    }
}
