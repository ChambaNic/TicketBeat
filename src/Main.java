import enumeraciones.*;
import interfaces.*;
import modelo.*;
import servicios.DevolucionServicio;
import servicios.NotificacionServicio;

import java.time.LocalDateTime;

public class Main {
         public static void main(String[] args) {

        System.out.println("1. Registro de un evento y su función");
        Evento concierto = new Evento(1, "Noche de Rock", "Concierto en vivo", "Rock","ACTIVO", "Banda XYZ");
        
        Funcion funcion = new Funcion(100, LocalDateTime.now().plusDays(30), "Estadio Modelo", "DISPONIBLE");

        Boleto b1 = new Boleto(1001, TipoBoleto.VIP, 80.0, EstadoBoleto.Disponible);
        Boleto b2 = new Boleto(1002, TipoBoleto.General, 35.0, EstadoBoleto.Disponible);
        Boleto b3 = new Boleto(1003, TipoBoleto.Asiento_Reservado, 50.0, EstadoBoleto.Disponible);
        System.out.println("Total de boletos registrados en la función: " + funcion.getBoletos().size());
        System.out.println("\n");

        System.out.println("2. Definición de política de devolución y restricción de compra por parte del organizador");
        Organizador organizador = new Organizador(1, "Productora Andina", "org@productora.ec");
        PoliticaDevolucion politica = new PoliticaDevolucion(10, 15, true, true);
        RestriccionCompra restriccion = new RestriccionCompra(20, 4, true);
        organizador.definirPolitica(politica);
        organizador.definirRestriccion(restriccion);
        System.out.println("\n");

        System.out.println("3. Compra y pago de boletos");
        Comprador comprador = new Comprador(1, "Ana Torres", "ana@correo.com");

        int cantidadDeseada = 2;
        if (!restriccion.validarCantidad(cantidadDeseada)) {
            System.out.println("La cantidad seleccionada supera el limite permitido por el organizador.");
            return;
        }

        Compra compra = comprador.iniciarCompra(500);
        compra.agregarBoleto(b1);
        compra.agregarBoleto(b2);
        System.out.println("Total a pagar: $" + compra.calcularTotal());

        IPagador formaDePago = new PagoTarjeta();   
        compra.registrarPago(900, formaDePago);
        compra.confirmarCompra();

        NotificacionServicio notificador = new NotificacionServicio(new NotificarCorreo());
        notificador.enviarNotificacion("Hola " + comprador.getNombre() + ", tu compra #" + compra.getIdCompra() + " fue confirmada.");
        System.out.println("\n");

        System.out.println("4. Reserva de boletos y solicitud de devolución");
        Reserva reserva = comprador.reservar(700, 1, 24);
        reserva.agregarBoleto(b3);
        System.out.println("Boleto reservado: " + b3.getIdBoleto());
        System.out.println("\n");

        System.out.println("5. Solicitud de devolución de boletos");
        SolicitarDevolucion solicitud = comprador.solicitarDevolucion(800, "Impreviso personal, no puedo asistir al concierto", "DEVOLUCION");
        solicitud.asociarCompra(compra);

        DevolucionServicio devolucionServicio = new DevolucionServicio(politica);
        devolucionServicio.procesarDevolucion(solicitud);
        System.out.println("Estado de la solicitud: " + solicitud.getEstado());
        System.out.println("\n");

        System.out.println("6. Gestión de incidentes y soporte al cliente");
        AdministracionEvento administracion = new AdministracionEvento(1, "Administracion Central");
        administracion.administrarEvento(concierto);

        AgenteSoporte agente = new AgenteSoporte(1, "Carlos Mendez");
        administracion.contratarAgente(agente);

        Incidente incidente = new Incidente(1, "El reembolso no se refleja en la tarjeta", comprador);
        incidente.asociarReserva(reserva);

        agente.atenderIncidente(incidente);
        agente.escalarIncidente(incidente);
        administracion.resolverIncidente(incidente);

        System.out.println("Estado final del incidente: " + incidente.getEstado() + " | Detalle: " + incidente.getSolucion());
        System.out.println("\n");

        System.out.println("7. Finalización del evento y cierre de la función");
        concierto.actualizarEstado("FINALIZADO");
    }
}
