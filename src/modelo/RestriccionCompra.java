package modelo;

public class RestriccionCompra {

    private int idRestriccion;
    private int maxBoletosPorUsuario;
    private boolean activa;

    public RestriccionCompra(int idRestriccion, int maxBoletosPorUsuario, boolean activa) {
        this.idRestriccion = idRestriccion;
        this.maxBoletosPorUsuario = maxBoletosPorUsuario;
        this.activa = activa;
    }

    public boolean validarCantidad(int cantidad) {
        if (!activa) return true;
        return cantidad > 0 && cantidad <= maxBoletosPorUsuario;
    }

    public int getIdRestriccion()        { return idRestriccion; }
    public int getMaxBoletosPorUsuario() { return maxBoletosPorUsuario; }
    public boolean isActiva()            { return activa; }
    public void setActiva(boolean activa){ this.activa = activa; }
}

