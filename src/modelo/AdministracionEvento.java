package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PARTE 4 - Administracion que recibe y resuelve incidentes.
 * Relaciones: AdministracionEvento 1 ---- 0..* AgenteSoporte
 *             AdministracionEvento 1 ---- 0..* Evento
 */
public class AdministracionEvento {

    private int idAdministrador;
    private String nombre;

    private final List<AgenteSoporte> agentes = new ArrayList<>();  // 0..*
    private final List<Evento> eventos = new ArrayList<>();         // 0..*

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
        evento.asignarAdministracion(this);   // requiere ese metodo en Evento
    }

    /** Operacion del diagrama: recibirIncidente(incidente: Incidente): void */
    public void recibirIncidente(Incidente incidente) {
        if (incidente == null) return;
        incidente.setEstado("RECIBIDO_POR_ADMINISTRACION");
        System.out.println("[AdministracionEvento] " + nombre + " recibio el incidente #"
                + incidente.getIdIncidente());
    }

    /** Operacion del diagrama: resolverIncidente(incidente: Incidente): void */
    public void resolverIncidente(Incidente incidente) {
        if (incidente == null) return;
        incidente.setSolucion("Caso resuelto por " + nombre);
        incidente.setEstado("RESUELTO");
        System.out.println("[AdministracionEvento] Incidente #" + incidente.getIdIncidente()
                + " resuelto.");
    }

    public int getIdAdministrador() { return idAdministrador; }
    public String getNombre()       { return nombre; }
    public List<AgenteSoporte> getAgentes() { return Collections.unmodifiableList(agentes); }
    public List<Evento> getEventos()        { return Collections.unmodifiableList(eventos); }
}
