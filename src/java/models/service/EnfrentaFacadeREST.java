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
import models.Enfrenta;
import models.EnfrentaPK;

/**
 *
 * @author Salcedo
 */
@Stateless
@Path("models.enfrenta")
public class EnfrentaFacadeREST extends AbstractFacade<Enfrenta> {

    @PersistenceContext(unitName = "mundial_apiPU")
    private EntityManager em;

    private EnfrentaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codEstadio=codEstadioValue;codEquipoLocal=codEquipoLocalValue;codEquipoVisitante=codEquipoVisitanteValue;fEnfrenta=fEnfrentaValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        models.EnfrentaPK key = new models.EnfrentaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codEstadio = map.get("codEstadio");
        if (codEstadio != null && !codEstadio.isEmpty()) {
            key.setCodEstadio(new java.lang.Integer(codEstadio.get(0)));
        }
        java.util.List<String> codEquipoLocal = map.get("codEquipoLocal");
        if (codEquipoLocal != null && !codEquipoLocal.isEmpty()) {
            key.setCodEquipoLocal(codEquipoLocal.get(0));
        }
        java.util.List<String> codEquipoVisitante = map.get("codEquipoVisitante");
        if (codEquipoVisitante != null && !codEquipoVisitante.isEmpty()) {
            key.setCodEquipoVisitante(codEquipoVisitante.get(0));
        }
        java.util.List<String> fEnfrenta = map.get("fEnfrenta");
        if (fEnfrenta != null && !fEnfrenta.isEmpty()) {
            key.setFEnfrenta(new java.util.Date(fEnfrenta.get(0)));
        }
        return key;
    }

    public EnfrentaFacadeREST() {
        super(Enfrenta.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Enfrenta entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Enfrenta entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        models.EnfrentaPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Enfrenta find(@PathParam("id") PathSegment id) {
        models.EnfrentaPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Enfrenta> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Enfrenta> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
