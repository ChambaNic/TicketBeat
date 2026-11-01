package modelo;


public class AgenteSoporte {

    private int idAgente;
    private String nombre;

    private AdministracionEvento administracion;

    public AgenteSoporte(int idAgente, String nombre) {
        this.idAgente = idAgente;
        this.nombre = nombre;
    }

    public void atenderIncidente(Incidente incidente) {
        if (incidente == null) return;
        incidente.setEstado("EN_ATENCION");
        System.out.println("El agente de soporte " + nombre + " atiende el incidente # " + incidente.getIdIncidente());
    }

    public void escalarIncidente(Incidente incidente) {
        if (incidente == null) return;
        incidente.setEstado("ESCALADO");
        System.out.println("El agente de soporte " + nombre + " escalo el incidente # " + incidente.getIdIncidente() + " a la administracion del evento.");
        if (administracion != null) {
            administracion.recibirIncidente(incidente);
        }
    }

    void setAdministracion(AdministracionEvento administracion) {
        this.administracion = administracion;
    }

    public int getIdAgente()                       { return idAgente; }
    public String getNombre()                      { return nombre; }
    public AdministracionEvento getAdministracion(){ return administracion; }
}
