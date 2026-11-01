package modelo;

/**
 * PARTE 4 - Agente que atiende y escala incidentes.
 * Relacion: AdministracionEvento 1 ---- 0..* AgenteSoporte
 */
public class AgenteSoporte {

    private int idAgente;
    private String nombre;

    private AdministracionEvento administracion;

    public AgenteSoporte(int idAgente, String nombre) {
        this.idAgente = idAgente;
        this.nombre = nombre;
    }

    /** Operacion del diagrama: atenderIncidente(incidente: Incidente): void */
    public void atenderIncidente(Incidente incidente) {
        if (incidente == null) return;
        incidente.setEstado("EN_ATENCION");
        System.out.println("[AgenteSoporte] " + nombre + " atiende el incidente #"
                + incidente.getIdIncidente());
    }

    /** Operacion del diagrama: escalarIncidente(incidente: Incidente): void */
    public void escalarIncidente(Incidente incidente) {
        if (incidente == null) return;
        incidente.setEstado("ESCALADO");
        System.out.println("[AgenteSoporte] " + nombre + " escala el incidente #"
                + incidente.getIdIncidente());
        if (administracion != null) {
            administracion.recibirIncidente(incidente);
        }
    }

    /** Visibilidad de paquete: la asigna AdministracionEvento al contratar al agente. */
    void setAdministracion(AdministracionEvento administracion) {
        this.administracion = administracion;
    }

    public int getIdAgente()                       { return idAgente; }
    public String getNombre()                      { return nombre; }
    public AdministracionEvento getAdministracion(){ return administracion; }
}
