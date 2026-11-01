package modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Organizador {

    private int idOrganizador;
    private String nombre;
    private String correo;

    private final List<PoliticaDevolucion> politicas = new ArrayList<>();      
    private final List<RestriccionCompra> restricciones = new ArrayList<>();   

    public Organizador(int idOrganizador, String nombre, String correo) {
        this.idOrganizador = idOrganizador;
        this.nombre = nombre;
        this.correo = correo;
    }

    public void definirPolitica(PoliticaDevolucion politica) {
        if (politica == null) return;
        politicas.add(politica);
        System.out.println(" El organizador" + politica.getIdPolitica() + " registro una nueva politica.");
    }


    public void definirRestriccion(RestriccionCompra restriccion) {
        if (restriccion == null) return;
        restricciones.add(restriccion);
        System.out.println(" El organizador" + restriccion.getIdRestriccion() + " registro una nueva restriccion.");
    }

    public int getIdOrganizador() { return idOrganizador; }
    public String getNombre()     { return nombre; }
    public String getCorreo()     { return correo; }
    public List<PoliticaDevolucion> getPoliticas()     { return Collections.unmodifiableList(politicas); }
    public List<RestriccionCompra> getRestricciones()  { return Collections.unmodifiableList(restricciones); }
}

