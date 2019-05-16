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
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import restws.Resident;

/**
 *
 * @author Sanya
 */
@Stateless
@Path("restws.resident")
public class ResidentFacadeREST extends AbstractFacade<Resident> {

    @PersistenceContext(unitName = "Sanya_SmartERPU")
    private EntityManager em;

    public ResidentFacadeREST() {
        super(Resident.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Resident entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Resident entity) {
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
    public Resident find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Resident> findAll() {
        return super.findAll();
    }
    
    //3.1 Fetching Resident JSON object based on firstname
    @GET
    @Path("findByFirstname/{firstname}")
    @Produces({"application/json"})
    public List <Resident> findByFirstname(@PathParam("firstname") String firstname) {
        Query query = em.createNamedQuery("Resident.findByFirstname");
        query.setParameter("firstname", firstname);
        return query.getResultList();
    }
    
    //3.1 Fetching Resident JSON object based on lastname
    @GET
    @Path("findByLastname/{lastname}")
    @Produces({"application/json"})
    public List <Resident> findByLastname(@PathParam("lastname") String lastname) {
        Query query = em.createNamedQuery("Resident.findByLastname");
        query.setParameter("lastname", lastname);
        return query.getResultList();
    }
    
    
    //3.1 Fetching Resident JSON object based on dob
    @GET
    @Path("findByDob/{dob}")
    @Produces({"application/json"})
    public List <Resident> findByDob(@PathParam("dob") String dob) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        date = df.parse(dob);
        Query query = em.createNamedQuery("Resident.findByDob");
        query.setParameter("dob", date);
        return query.getResultList();
    }
    
     //3.1 Fetching Resident JSON object based on address
    @GET
    @Path("findByAddress/{address}")
    @Produces({"application/json"})
    public List <Resident> findByAddress(@PathParam("address") String address) {
        Query query = em.createNamedQuery("Resident.findByAddress");
        query.setParameter("address", address);
        return query.getResultList();
    }
    
    //3.1 Fetching Resident JSON object based on postcode
    @GET
    @Path("findByPostcode/{postcode}")
    @Produces({"application/json"})
    public List <Resident> findByPostcode(@PathParam("postcode") Short postcode) {
        Query query = em.createNamedQuery("Resident.findByPostcode");
        query.setParameter("postcode", postcode);
        return query.getResultList();
    }
    
    
     //3.1 Fetching Resident JSON object based on email
    @GET
    @Path("findByEmail/{email}")
    @Produces({"application/json"})
    public List <Resident> findByEmail(@PathParam("email") String email) {
        Query query = em.createNamedQuery("Resident.findByEmail");
        query.setParameter("email", email);
        return query.getResultList();
    }
    
    //3.1 Fetching Resident JSON object based on mobile
    @GET
    @Path("findByMobile/{mobile}")
    @Produces({"application/json"})
    public List <Resident> findByMobile(@PathParam("mobile") Long mobile) {
        Query query = em.createNamedQuery("Resident.findByMobile");
        query.setParameter("mobile", mobile);
        return query.getResultList();
    }
  
    
   //3.1Fetching Resident JSON object based on noofresidents
    @GET
    @Path("findByNoofresidents/{noofresidents}")
    @Produces({"application/json"})
    public List <Resident> findByNoofresidents(@PathParam("noofresidents") Integer noofresidents) {
        Query query = em.createNamedQuery("Resident.findByNoofresidents");
        query.setParameter("noofresidents", noofresidents);
        return query.getResultList();
    }  
    
    //3.1 Fetching Resident JSON object based on nameofenergyprovider
    @GET
    @Path("findByNameofenergyprovider/{nameofenergyprovider}")
    @Produces({"application/json"})
    public List <Resident> findByNameofenergyprovider(@PathParam("nameofenergyprovider") String nameofenergyprovider) {
        Query query = em.createNamedQuery("Resident.findByNameofenergyprovider");
        query.setParameter("nameofenergyprovider", nameofenergyprovider);
        return query.getResultList();
    }  

    //3.2 Fetching Resident JSON object based on firstname and lastname DYNAMIC QUERY   
    @GET
    @Path("findByFullName/{firstname}/{lastname}")
    @Produces({"application/json"})
    public List<Resident> findByFullName(@PathParam("firstname") String firstname, @PathParam("lastname") String lastname ) {
        TypedQuery<Resident> query = em.createQuery("SELECT r FROM Resident r WHERE r.firstname = :firstname AND r.lastname = :lastname", Resident.class);
        query.setParameter("firstname", firstname);
        query.setParameter("lastname", lastname);
    return query.getResultList();
 }

 
 
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Resident> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
