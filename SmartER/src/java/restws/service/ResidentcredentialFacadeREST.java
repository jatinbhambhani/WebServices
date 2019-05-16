/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restws.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import restws.Residentcredential;

/**
 *
 * @author Sanya
 */
@Stateless
@Path("restws.residentcredential")
public class ResidentcredentialFacadeREST extends AbstractFacade<Residentcredential> {

    @PersistenceContext(unitName = "Sanya_SmartERPU")
    private EntityManager em;

    public ResidentcredentialFacadeREST() {
        super(Residentcredential.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Residentcredential entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Residentcredential entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Residentcredential find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Residentcredential> findAll() {
        return super.findAll();
    }
    
    //3.1 Fetching ResidentCredential JSON object based on residentid
    @GET
    @Path("findByResidentid/{residentid}")
    @Produces({"application/json"})
    public List <Residentcredential> findByResidentid(@PathParam("residentid") Integer residentid) {
        Query query = em.createNamedQuery("Residentcredential.findByResidentid");
        query.setParameter("residentid", residentid);
        return query.getResultList();
    }

    //3.1 Fetching ResidentCredential JSON object based on passwordhash
    @GET
    @Path("findByPasswordhash/{passwordhash}")
    @Produces({"application/json"})
    public List <Residentcredential> findByPasswordhash(@PathParam("passwordhash") String passwordhash) {
        Query query = em.createNamedQuery("Residentcredential.findByPasswordhash");
        query.setParameter("passwordhash", passwordhash);
        return query.getResultList();
    }
   
    //3.1 Fetching ResidentCredential JSON object based on registrationdate
    @GET
    @Path("findByRegistrationdate/{registrationdate}")
    @Produces({"application/json"})
    public List <Residentcredential> findByRegistrationdate(@PathParam("registrationdate") String registrationdate) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        date = df.parse(registrationdate);
        Query query = em.createNamedQuery("Residentcredential.findByRegistrationdate");
        query.setParameter("registrationdate", date);
        return query.getResultList();
    }
    
    
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Residentcredential> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
