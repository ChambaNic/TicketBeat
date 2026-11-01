package modelo;

import interfaces.INotificar;

public class NotificarMensajeria implements INotificar {
    @Override
    public boolean enviar(String mensaje) {
        System.out.println("Enviando mensaje instantaneo: " + mensaje);
        return true;
    }
}
