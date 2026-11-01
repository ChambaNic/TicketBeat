package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdministracionEvento {

    private int idAdministrador;
    private String nombre;

    private final List<AgenteSoporte> agentes = new ArrayList<>();  
    private final List<Evento> eventos = new ArrayList<>();         

    public AdministracionEvento(int idAdministrador, String nombre) {
        this.idAdministrador = idAdministrador;
        this.nombre = nombre;
    }

    public void contratarAgente(AgenteSoporte agente) {
        if (agente == null) return;
        agentes.add(agente);
        agente.setAdministracion(this);
    }

    public void administrarEvento(Evento evento) {
        if (evento == null) return;
        eventos.add(evento);  
    }

    public void recibirIncidente(Incidente incidente) {
        if (incidente == null) return;
        incidente.setEstado("RECIBIDO_POR_ADMINISTRACION");
        System.out.println("La administracion " + nombre + " recibio el incidente # " + incidente.getIdIncidente());
    }

    public void resolverIncidente(Incidente incidente) {
        if (incidente == null) return;
        incidente.setSolucion("Caso resuelto por " + nombre);
        incidente.setEstado("RESUELTO");
        System.out.println("La administracion " + nombre + " resolvio el incidente # " + incidente.getIdIncidente());
    }

    public int getIdAdministrador() { return idAdministrador; }
    public String getNombre()       { return nombre; }
    public List<AgenteSoporte> getAgentes() { return Collections.unmodifiableList(agentes); }
    public List<Evento> getEventos()        { return Collections.unmodifiableList(eventos); }
}
