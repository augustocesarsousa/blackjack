package org.acsousa.resources.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acsousa.domain.entities.Partida;
import org.acsousa.services.PartidaService;

@Path("/api/partida")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PartidaResource {

    @Inject
    PartidaService partidaService;

    @POST
    @Path("/novo-jogo")
    public Response iniciarNovoJogo() {
        Partida partida = partidaService.novaPartida();
        return Response.status(Response.Status.CREATED).entity(partida).build();
    }

    @GET
    public Response obterPartidaAtual() {
        return partidaService.obterPartidaAtual()
                .map(partida -> Response.ok(partida).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @PATCH
    @Path("/pedir-carta")
    public Response pedirCarta() {
        try {
            Partida partida = partidaService.pedirCarta();
            return Response.ok(partida).build();
        } catch (IllegalStateException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PATCH
    @Path("/parar")
    public Response pararPartida() {
        try {
            Partida partida = partidaService.pararPartida();
            return Response.ok(partida).build();
        } catch (IllegalStateException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    public Response reiniciarJogo() {
        partidaService.resetarJogo();
        return Response.noContent().build();
    }
}
