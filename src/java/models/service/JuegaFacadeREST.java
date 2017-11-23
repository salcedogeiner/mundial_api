/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import models.Juega;
import models.JuegaPK;

/**
 *
 * @author Salcedo
 */
@Stateless
@Path("models.juega")
public class JuegaFacadeREST extends AbstractFacade<Juega> {

    @PersistenceContext(unitName = "mundial_apiPU")
    private EntityManager em;

    private JuegaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codJugador=codJugadorValue;codEquipo=codEquipoValue;idTorneo=idTorneoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        models.JuegaPK key = new models.JuegaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codJugador = map.get("codJugador");
        if (codJugador != null && !codJugador.isEmpty()) {
            key.setCodJugador(new java.lang.Integer(codJugador.get(0)));
        }
        java.util.List<String> codEquipo = map.get("codEquipo");
        if (codEquipo != null && !codEquipo.isEmpty()) {
            key.setCodEquipo(codEquipo.get(0));
        }
        java.util.List<String> idTorneo = map.get("idTorneo");
        if (idTorneo != null && !idTorneo.isEmpty()) {
            key.setIdTorneo(new java.lang.Integer(idTorneo.get(0)));
        }
        return key;
    }

    public JuegaFacadeREST() {
        super(Juega.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Juega entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Juega entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        models.JuegaPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Juega find(@PathParam("id") PathSegment id) {
        models.JuegaPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Juega> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Juega> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
