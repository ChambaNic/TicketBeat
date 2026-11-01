package modelo;

import interfaces.INotificar;

public class NotificarMensajeria implements INotificar {
    @Override
    public boolean enviar(String mensaje) {
        System.out.println("[Mensajeria] " + mensaje);
        return true;
    }
}
