package modelo;

import interfaces.INotificar;

public class NotificarCorreo implements INotificar {
    @Override
    public boolean enviar(String mensaje) {
        System.out.println("Enviando correo electronico: " + mensaje);
        return true;
    }
}
