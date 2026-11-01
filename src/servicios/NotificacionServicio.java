package servicios;

import interfaces.INotificar;

public class NotificacionServicio {

    private final INotificar notificador;

    public NotificacionServicio(INotificar notificador) {
        this.notificador = notificador;
    }

    public boolean enviarNotificacion(String mensaje) {
        if (notificador == null || mensaje == null || mensaje.isEmpty()) {
            return false;
        }
        
        return notificador.enviar(mensaje);
    }
}
