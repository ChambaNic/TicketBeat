package modelo;

import interfaces.INotificar;

public class NotificarSMS implements INotificar {
    @Override
    public boolean enviar(String mensaje) {
        System.out.println("[SMS] " + mensaje);
        return true;
    }
}

