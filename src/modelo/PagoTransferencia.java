package modelo;

import interfaces.IPagador;


public class PagoTransferencia implements IPagador {
    @Override
    public boolean pagar(double monto) {
        System.out.println("[PagoTransferencia] Transferencia bancaria por $" + monto + ".");
        return monto > 0;
    }
}
