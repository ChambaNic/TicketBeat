import enumeraciones.*;
import interfaces.*;
import modelo.*;

import java.time.LocalDateTime;

/**
 * PARTE 4 - Programa principal: recorre las cuatro partes del diagrama.
 * Va en src/Main.java (paquete por defecto), por eso importa los tres paquetes.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("===== 1. EVENTO, FUNCION Y BOLETOS (Parte 1) =====");
        Evento concierto = new Evento(1, "Noche de Rock", "Concierto en vivo",
                                      "Banda XYZ", "Rock");
        Funcion funcion = concierto.programarFuncion(
                100, LocalDateTime.now().plusDays(30), "Estadio Modelo");

        Boleto b1 = funcion.emitirBoleto(1001, TipoBoleto.VIP, 80.0);
        Boleto b2 = funcion.emitirBoleto(1002, TipoBoleto.GENERAL, 35.0);
        Boleto b3 = funcion.emitirBoleto(1003, TipoBoleto.ASIENTO_RESERVADO, 50.0);
        System.out.println("Boletos disponibles: " + funcion.boletosDisponibles().size());

        System.out.println("\n===== 2. ORGANIZADOR: POLITICAS Y RESTRICCIONES (Parte 3) =====");
        Organizador organizador = new Organizador(1, "Productora Andina", "org@productora.ec");
        PoliticaDevolucion politica = new PoliticaDevolucion(10, 15, true, true);
        RestriccionCompra restriccion = new RestriccionCompra(20, 4, true);
        organizador.definirPolitica(politica);
        organizador.definirRestriccion(restriccion);

        System.out.println("\n===== 3. COMPRA Y PAGO (Parte 2) =====");
        Comprador comprador = new Comprador(1, "Ana Torres", "ana@correo.com");

        int cantidadDeseada = 2;
        if (!restriccion.validarCantidad(cantidadDeseada)) {
            System.out.println("Cantidad no permitida por la restriccion del organizador.");
            return;
        }

        Compra compra = comprador.iniciarCompra(500);
        compra.agregarBoleto(b1);
        compra.agregarBoleto(b2);
        System.out.println("Total a pagar: $" + compra.calcularTotal());

        IPagador formaDePago = new PagoTarjeta();   // intercambiable: PagoMovil, PagoTransferencia
        compra.registrarPago(900, formaDePago);
        compra.confirmarCompra();

        NotificacionServicio notificador = new NotificacionServicio(new NotificarCorreo());
        notificador.enviarNotificacion("Hola " + comprador.getNombre()
                + ", tu compra #" + compra.getIdCompra() + " fue confirmada.");

        System.out.println("\n===== 4. RESERVA (Parte 2) =====");
        Reserva reserva = comprador.reservar(700, 1, 24);
        reserva.agregarBoleto(b3);
        System.out.println("Boleto reservado: " + b3);

        System.out.println("\n===== 5. SOLICITUD DE DEVOLUCION (Parte 3) =====");
        SolicitarDevolucion solicitud = comprador.solicitarDevolucion(
                800, "No puedo asistir al concierto", "DEVOLUCION");
        solicitud.asociarCompra(compra);

        DevolucionServicio devolucionServicio = new DevolucionServicio(politica);
        devolucionServicio.procesarDevolucion(solicitud);
        System.out.println("Estado de la solicitud: " + solicitud.getEstado());

        System.out.println("\n===== 6. SOPORTE E INCIDENTES (Parte 4) =====");
        AdministracionEvento administracion = new AdministracionEvento(1, "Administracion Central");
        administracion.administrarEvento(concierto);

        AgenteSoporte agente = new AgenteSoporte(1, "Carlos Mendez");
        administracion.contratarAgente(agente);

        Incidente incidente = new Incidente(1, "El reembolso no se refleja en la tarjeta", comprador);
        incidente.asociarReserva(reserva);

        agente.atenderIncidente(incidente);
        agente.escalarIncidente(incidente);
        administracion.resolverIncidente(incidente);

        System.out.println("Estado final del incidente: " + incidente.getEstado()
                + " | " + incidente.getSolucion());

        System.out.println("\n===== 7. CAMBIO DE ESTADO DEL EVENTO (Parte 1) =====");
        concierto.actualizarEstado("FINALIZADO");
    }
}
