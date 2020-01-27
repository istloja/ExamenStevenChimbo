/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Pais;
import modelo.Provincias;

/**
 *
 * @author Steven Chimbo
 */
@Stateless
@Path("modelo.pais")
public class PaisFacadeREST extends AbstractFacade<Pais> {

    @PersistenceContext(unitName = "EcuadorPU")
    private EntityManager em;

    public PaisFacadeREST() {
        super(Pais.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Pais entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Pais entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }
//creo el metodo obtener todo post
    @POST
    @Path("Obtener")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pais> Obtener(){
    return super.findAll();
    }
    //metodo crear
    @POST
    @Path("Crear")
   @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String CrearPaisNuevo(@FormParam("idPais") Integer idP ,@FormParam("nombre")String nP,@FormParam("superficie")Double km,@FormParam("lenguaje")String idioma,@FormParam("nroHabitantes") int habi){
        Pais pa= new Pais();
        pa.setIdPais(idP);
        pa.setNombre(nP);
        pa.setSuperficie(km);
        pa.setLenguaje(idioma);
        pa.setNroHabitantes(habi);
        super.create(pa);
        return "Crear";
    }
    //metodo eliminar
    @POST
    @Path("Eliminar")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public String Eliminar(@FormParam("idPais") Integer idP ,@FormParam("nombre")String nP,@FormParam("superficie")Double km,@FormParam("lenguaje")String idioma,@FormParam("nroHabitantes") int habi){
          Pais pa= super.find(idP);
        super.remove(pa);
        return "Editar";
    }
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Pais find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pais> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pais> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
