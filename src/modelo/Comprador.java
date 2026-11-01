package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comprador {

    private int idComprador;
    private String nombre;
    private String correo;

    private final List<Compra> compras = new ArrayList<>();                 
    private final List<Reserva> reservas = new ArrayList<>();               
    private final List<SolicitarDevolucion> solicitudes = new ArrayList<>();
    private final List<Incidente> incidentes = new ArrayList<>();           

    public Comprador(int idComprador, String nombre, String correo) {
        this.idComprador = idComprador;
        this.nombre = nombre;
        this.correo = correo;
    }

    public Compra iniciarCompra(int idCompra) {
        Compra compra = new Compra(idCompra, this);
        compras.add(compra);
        return compra;
    }

    public Reserva reservar(int idReserva, int cantidadBoletos, int horasVigencia) {
        Reserva reserva = new Reserva(idReserva, cantidadBoletos, horasVigencia, this);
        reservas.add(reserva);
        return reserva;
    }

    public SolicitarDevolucion solicitarDevolucion(int idSolicitud, String motivo, String tipoSolicitud) {
        SolicitarDevolucion solicitud = new SolicitarDevolucion(idSolicitud, motivo, tipoSolicitud, this);
        solicitudes.add(solicitud);
        return solicitud;
    }

    public void registrarIncidente(Incidente incidente) {
        if (incidente != null) {
            incidentes.add(incidente);
        }
    }

    public int getIdComprador() {
        return idComprador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public List<Compra> getCompras(){ 
        return Collections.unmodifiableList(compras); 
    }
    
    public List<Reserva> getReservas(){ 
        return Collections.unmodifiableList(reservas);
    }
    
    public List<SolicitarDevolucion> getSolicitudes()  { 
        return Collections.unmodifiableList(solicitudes); 
    }
    
    public List<Incidente> getIncidentes() { 
        return Collections.unmodifiableList(incidentes); 
    }

}
