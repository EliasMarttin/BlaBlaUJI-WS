package servicios;
import jakarta.ws.rs.*;
import modelo.*;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import org.json.simple.JSONArray;


@Path("viajes")
public class RecursoViajes {

	private GestorViajes gestor = new GestorViajes();

	/**
	 * Constructor por defecto
	 */
	public RecursoViajes() {
		super();
		gestor = new GestorViajes();
		System.out.println("construyo RecursoViajes");
	}

	/**
	 * Cuando cada cliente cierra su sesion volcamos los datos en el fichero para mantenerlos actualizados
	 */
	/* FALTAN ANOTACIONES JAX-RS */

	@Path("/guardarDatos/")
	@GET
	public Response guardaDatos() {
		/* POR IMPLEMENTAR */
		return null; // A MODIFICAR
	}


	/**
	 * Devuelve los viajes disponibles con un origen dado
	 *
	 * @param origen
	 * @return JSONArray de viajes con un origen dado. Vacío si no hay viajes disponibles con ese origen
	 */
	/* FALTAN ANOTACIONES JAX-RS */
	@GET
	@Path("{origen}")
	@Produces("aplication/json")
	public Response consultaViajes(@PathParam("origen") String origen) { // CABECERA POR COMPLETAR
		JSONArray res = gestor.consultaViajes(origen);
		if (res == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			ResponseBuilder builder = Response.ok(res.toJSONString());
			return builder.build();
		}
}

	/**
	 * El cliente codcli reserva el viaje codviaje
	 *
	 * @param codviaje
	 * @param codcli
	 * @return JSONObject con la información del viaje. Vacío si no existe o no está disponible
	 */
	/* FALTAN ANOTACIONES JAX-RS */
	@POST
	@Path("{codViaje}/{codCli}")
	public Response reservaViaje(@PathParam("codViaje") String codviaje,@PathParam("codCli") String codcli) { // CABECERA POR COMPLETAR
		/* POR IMPLEMENTAR */
		return null; // A MODIFICAR
	}

	/**
	 * El cliente codcli anula su reserva del viaje codviaje
	 *
	 * @param codviaje	codigo del viaje a anular
	 * @param codcli	codigo del cliente
	 * @return	JSON del viaje en que se ha anulado la reserva. JSON vacio si no se ha anulado
	 */
	/* FALTAN ANOTACIONES JAX-RS */
	@DELETE
	@Path("anulaReserva")
	public Response anulaReserva(String codviaje,  String codcli) { // CABECERA POR COMPLETAR
		/* POR IMPLEMENTAR */
		return null; // A MODIFICAR
	}

	/**
	 * El cliente codcli oferta un Viaje
	 * @param codcli
	 * @param origen
	 * @param destino
	 * @param fecha
	 * @param precio
	 * @param numplazas
	 * @return	JSONObject con los datos del viaje ofertado. Vacio si no se oferta
	 */
	/* FALTAN ANOTACIONES JAX-RS */
	@POST
	@Path("/ofertaViaje")
	public Response ofertaViaje(String codcli, String origen,
								String destino, String fecha,
								long precio, long numplazas) { // CABECERA POR COMPLETAR
		/* POR IMPLEMENTAR */
		return null; // A MODIFICAR
	}




	/**
	 * El cliente codcli borra un viaje que ha ofertado
	 *
	 * @param codviaje	codigo del viaje a borrar
	 * @param codcli	codigo del cliente
	 * @return	JSONObject del viaje borrado. JSON vacio si no se ha borrado
	 */
	/* FALTAN ANOTACIONES JAX-RS */
	@DELETE
	@Path("/borraViaje")
	public Response borraViaje(String codviaje, String codcli) {
		/* POR IMPLEMENTAR */
		return null; // A MODIFICAR
	}



}
