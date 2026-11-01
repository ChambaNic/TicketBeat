package modelo;

import interfaces.IPagador;

public class PagoTarjeta implements IPagador {
    @Override
    public boolean pagar(double monto) {
        System.out.println("[PagoTarjeta] Cobrando $" + monto + " a la tarjeta.");
        return monto > 0;
    }
}
