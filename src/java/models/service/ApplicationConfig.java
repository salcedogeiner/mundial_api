/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Salcedo
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(CORS.CORSFilter.class);
        resources.add(models.service.ArbitrosFacadeREST.class);
        resources.add(models.service.CiudadesFacadeREST.class);
        resources.add(models.service.ConfederacionesFacadeREST.class);
        resources.add(models.service.EnfrentaFacadeREST.class);
        resources.add(models.service.EquiposFacadeREST.class);
        resources.add(models.service.EstadiosFacadeREST.class);
        resources.add(models.service.IncideFacadeREST.class);
        resources.add(models.service.JuegaFacadeREST.class);
        resources.add(models.service.JugadoresFacadeREST.class);
        resources.add(models.service.PaisesFacadeREST.class);
        resources.add(models.service.ParticipaFacadeREST.class);
        resources.add(models.service.TecnicosFacadeREST.class);
        resources.add(models.service.TieneFacadeREST.class);
        resources.add(models.service.TorneosFacadeREST.class);
    }
    
}
