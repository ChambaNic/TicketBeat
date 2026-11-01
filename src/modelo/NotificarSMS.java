package modelo;

import interfaces.INotificar;

public class NotificarSMS implements INotificar {
    @Override
    public boolean enviar(String mensaje) {
        System.out.println("Enviando SMS: " + mensaje);
        return true;
    }
}

