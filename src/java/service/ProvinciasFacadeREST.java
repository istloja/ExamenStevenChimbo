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
import modelo.Provincias;

/**
 *
 * @author Steven Chimbo
 */
@Stateless
@Path("modelo.provincias")
public class ProvinciasFacadeREST extends AbstractFacade<Provincias> {

    @PersistenceContext(unitName = "EcuadorPU")
    private EntityManager em;

    public ProvinciasFacadeREST() {
        super(Provincias.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Provincias entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Provincias entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Provincias find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Provincias> findAll() {
        return super.findAll();
    }
    //creo metodo obtener
    @POST
    @Path("Obtener")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Provincias> Obtener(){
    return super.findAll();
    }
    //metodo crear
     @POST
    @Path("Crear")
   @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String CrearProvinciaNuevo(@FormParam("idProvincias") Integer idPro ,@FormParam("nroCantones")int Cantones,@FormParam("superficie") double km,@FormParam("region")String region){
        Provincias pro= new Provincias();
        pro.setIdProvincias(idPro);
        pro.setNroCantones(Cantones);
        pro.setSuperficie(km);
        pro.setRegion(region);
        super.create(pro);
        return "Crear";
    }
    //metodo editar
    @POST
    @Path("Editar")
   @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Editar(@FormParam("idProvincias") Integer idPro ,@FormParam("nroCantones")int Cantones,@FormParam("superficie") double km,@FormParam("region")String region){
        Provincias pro= new Provincias();
        pro.setIdProvincias(idPro);
        pro=super.find(idPro);
        pro.setNroCantones(Cantones);
        pro.setSuperficie(km);
        pro.setRegion(region);
        super.edit(pro);
        return "Editar";
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Provincias> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
