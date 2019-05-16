/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restws.service;

import entities.ResidentHouseUsage;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
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
import restws.Houseusage;

/**
 *
 * @author Sanya
 */
@Stateless
@Path("restws.houseusage")
public class HouseusageFacadeREST extends AbstractFacade<Houseusage> {

    @PersistenceContext(unitName = "Sanya_SmartERPU")
    private EntityManager em;

    public HouseusageFacadeREST() {
        super(Houseusage.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Houseusage entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Houseusage entity) {
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
    public Houseusage find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    //3.1 Fetching HouseUsage JSON object based on residentid
    @GET
    @Path("findByResidentid/{residentid}")
    @Produces({"application/json"})
    public List<Houseusage> findByResidentid(@PathParam("residentid") Integer residentid) {
        Query query = em.createNamedQuery("Houseusage.findByResidentid");
        query.setParameter("residentid", residentid);
        return query.getResultList();
    }

    //3.1 Fetching HouseUsage JSON object based on usagedate
    @GET
    @Path("findByUsagedate/{usagedate}")
    @Produces({"application/json"})
    public List<Houseusage> findByUsagedate(@PathParam("usagedate") String usagedate) {
        Query query = em.createNamedQuery("Houseusage.findByUsagedate");
        query.setParameter("usagedate", usagedate);
        return query.getResultList();
    }

    //3.1 Fetching HouseUsage JSON object based on usagehour
    @GET
    @Path("findByUsagehour/{usagehour}")
    @Produces({"application/json"})
    public List<Houseusage> findByUsagehour(@PathParam("usagehour") Integer usagehour) {
        Query query = em.createNamedQuery("Houseusage.findByUsagehour");
        query.setParameter("usagehour", usagehour);
        return query.getResultList();
    }

    //3.1 Fetching HouseUsage JSON object based on fridgeusage
    @GET
    @Path("findByFridgeusage/{fridgeusage}")
    @Produces({"application/json"})
    public List<Houseusage> findByFridgeusage(@PathParam("fridgeusage") BigDecimal fridgeusage) {
        Query query = em.createNamedQuery("Houseusage.findByFridgeusage");
        query.setParameter("fridgeusage", fridgeusage);
        return query.getResultList();
    }

    //3.1 Fetching HouseUsage JSON object based on airconusage
    @GET
    @Path("findByAirconusage/{airconusage}")
    @Produces({"application/json"})
    public List<Houseusage> findByAirconusage(@PathParam("airconusage") BigDecimal airconusage) {
        Query query = em.createNamedQuery("Houseusage.findByAirconusage");
        query.setParameter("airconusage", airconusage);
        return query.getResultList();
    }

    //3.1 Fetching HouseUsage JSON object based on washingmachineusage
    @GET
    @Path("findByWashingmachineusage/{washingmachineusage}")
    @Produces({"application/json"})
    public List<Houseusage> findByWashingmachineusage(@PathParam("washingmachineusage") BigDecimal washingmachineusage) {
        Query query = em.createNamedQuery("Houseusage.findByWashingmachineusage");
        query.setParameter("washingmachineusage", washingmachineusage);
        return query.getResultList();
    }

    //3.1 Fetching HouseUsage JSON object based on temperature
    @GET
    @Path("findByTemperature/{temperature}")
    @Produces({"application/json"})
    public List<Houseusage> findByTemperature(@PathParam("temperature") BigDecimal temperature) {
        Query query = em.createNamedQuery("Houseusage.findByTemperature");
        query.setParameter("temperature", temperature);
        return query.getResultList();
    }

    //3.3 Fetching HouseUsage JSON object based on residentid and usage hour DYNAMIC QUERY
    @GET
    @Path("findByResidentAndUsage/{residentid}/{usagehour}")
    @Produces({"application/json"})
    public List<Houseusage> findByResidentAndUsage(@PathParam("residentid") Integer residentid, @PathParam("usagehour") Integer usagehour) {
        TypedQuery<Houseusage> q = em.createQuery("SELECT h FROM Houseusage h WHERE h.residentid.residentid = :residentid"
                + " AND h.usagehour = :usagehour", Houseusage.class);
        q.setParameter("residentid", residentid);
        q.setParameter("usagehour", usagehour);
        return q.getResultList();
    }

    //3.4 Fetching HouseUsage JSON object based on residentid and temperature STATIC QUERY
    @GET
    @Path("findByResidentidANDTemperature/{residentid}/{temperature}")
    @Produces({"application/json"})
    public List<Houseusage> findByResidentidANDTemperature(@PathParam("residentid") Integer residentid, @PathParam("temperature") BigDecimal temperature) {
        Query query = em.createNamedQuery("Houseusage.findByResidentidANDTemperature");
        query.setParameter("residentid", residentid);
        query.setParameter("temperature", temperature);
        return query.getResultList();
    }


    
     //4.1 Fetching HouseUsage  based on residentid, applicance name, date and hour APPROACH 3
    @GET
    @Path("findHourlyAppUsage/{residentid}/{appliance}/{usagehour}/{usagedate}")
    @Produces(MediaType.APPLICATION_JSON) 
    public Object findHourlyAppUsage(@PathParam("residentid") int residentid,
            @PathParam("appliance") String appliance, 
            @PathParam("usagehour") int usagehour, @PathParam("usagedate") String date) 
            throws ParseException {
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date usagedate = df.parse(date);
        
        List<Object[]> queryList;
        
      if(appliance.contains("air"))
      {
         queryList = em.createQuery("SELECT h.residentid.residentid,h.airconusage"
                + " FROM Houseusage h WHERE h.residentid.residentid = :residentid AND h.usagehour = :usagehour"
                + " AND h.usagedate = :usagedate", Object[].class)
                .setParameter("residentid", residentid)
                .setParameter("usagehour", usagehour)
                .setParameter("usagedate", usagedate).getResultList();
        
      }
        
        else if(appliance.contains("washing")){
              queryList = em.createQuery("SELECT h.residentid.residentid,h.washingmachineusage"
                + " FROM Houseusage h WHERE h.residentid.residentid = :residentid AND h.usagehour = :usagehour"
                + " AND h.usagedate = :usagedate", Object[].class)
                .setParameter("residentid", residentid)
                .setParameter("usagehour", usagehour)
                .setParameter("usagedate", usagedate).getResultList();
            }
        
        else {
           queryList = em.createQuery("SELECT h.residentid.residentid,h.fridgeusage"
                + " FROM Houseusage h WHERE h.residentid.residentid = :residentid AND h.usagehour = :usagehour"
                + " AND h.usagedate = :usagedate", Object[].class)
                .setParameter("residentid", residentid)
                .setParameter("usagehour", usagehour)
                .setParameter("usagedate", usagedate).getResultList();
        }
      
       JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
           
       for (Object[] row: queryList){
       JsonObject usageObject = Json.createObjectBuilder().add("Appliance Usage ", (BigDecimal)(row[1])).build();
       arrayBuilder.add(usageObject);
   }
       JsonArray jArray = arrayBuilder.build();
       return jArray;

    }
    
 //4.2 Fetching AllApplianceUsage based on residentid, date and hour APPROACH 3
    @GET
    @Path("findAllApplianceUsage/{residentid}/{usagehour}/{usagedate}")
    @Produces(MediaType.APPLICATION_JSON) 
    public Object findAllApplianceUsage(@PathParam("residentid") int residentid,
                   @PathParam("usagehour") int usagehour, @PathParam("usagedate") String date) 
            throws ParseException {
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date usagedate = df.parse(date);
        
        List<Object[]> queryList = em.createQuery("SELECT h.residentid.residentid,"
                + "(h.airconusage+h.washingmachineusage+h.fridgeusage) as s"
                + " FROM Houseusage h WHERE h.residentid.residentid = :residentid AND h.usagehour = :usagehour"
                + " AND h.usagedate = :usagedate", Object[].class)
                .setParameter("residentid", residentid)
                .setParameter("usagehour", usagehour)
                .setParameter("usagedate", usagedate).getResultList();
        
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
           
       for (Object[] row: queryList){
       JsonObject usageObject = Json.createObjectBuilder().add("All Appliance Usage ", (BigDecimal)(row[1])).build();
       arrayBuilder.add(usageObject);
   }
       JsonArray jArray = arrayBuilder.build();
       return jArray;
        
    }
    
    
     //4.3 Fetching Hourly Usage for all residents based on date and hour APPROACH 3
    @GET
    @Path("findHourUsageForResidents/{usagehour}/{usagedate}")
    @Produces(MediaType.APPLICATION_JSON) 
    public Object findHourUsageForResidents(@PathParam("usagehour") int usagehour, 
            @PathParam("usagedate") String date) throws ParseException {
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date usagedate = df.parse(date);
        
        List<Object[]> queryList = em.createQuery("SELECT h.residentid.residentid, h.residentid.address,"
                + "h.residentid.postcode, (h.airconusage+h.washingmachineusage+h.fridgeusage) as s"
                + " FROM Houseusage h WHERE h.usagehour = :usagehour"
                + " AND h.usagedate = :usagedate", Object[].class)
                .setParameter("usagehour", usagehour)
                .setParameter("usagedate", usagedate).getResultList();
        
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
           
       for (Object[] row: queryList){
       JsonObject usageObject = Json.createObjectBuilder()
               .add("ResidentId ", (Integer)(row[0]))
               .add("Address ", (String)(row[1]))
               .add("Postcode ", (short)(row[2]))
               .add("All Appliance Usage ", (BigDecimal)(row[3])).build();
       arrayBuilder.add(usageObject);
   }
       JsonArray jArray = arrayBuilder.build();
       return jArray;
        
    }
    
  
      //4.4 Fetching Highest Hourly Power Usage for a resident based on residentid APPROACH 3
    @GET
    @Path("findHighestHourlyConsumption/{residentid}")
    @Produces(MediaType.APPLICATION_JSON) 
    public Object findHighestHourlyConsumption(@PathParam("residentid") int residentid) {
        
        List<Object[]> queryList = em.createQuery
        ("SELECT h.usageid, h.usagedate, h.usagehour,(h.fridgeusage + h.airconusage + h.washingmachineusage) as totalconsumption from Houseusage h"
                + " WHERE h.residentid.residentid = :residentid and (h.fridgeusage + h.airconusage + h.washingmachineusage) IN"
                + " (SELECT MAX(h.fridgeusage + h.airconusage + h.washingmachineusage) FROM Houseusage h where h.residentid.residentid = :residentid) ",
                Object[].class)
                    .setParameter("residentid", residentid).getResultList();
     
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
           
        
       for (Object[] row: queryList){
       JsonObject usageObject = Json.createObjectBuilder()
               .add("UsageID ", (int)(row[0]))
               .add("UsageDate ", (String)(row[1]).toString())
               .add("UsageHour ", (int)(row[2]))
               .add("Total Usage ", (BigDecimal)(row[3])).build();
       arrayBuilder.add(usageObject);
   }
       JsonArray jArray = arrayBuilder.build();
       return jArray;
        
    }
    
      
    
     //5.1 Fetching Daily Power Usage of Appliances for a resident and date APPROACH 3
    @GET
    @Path("findDailyUsageOfAppliance/{residentid}/{usagedate}")
    @Produces(MediaType.APPLICATION_JSON) 
    public Object findDailyUsageOfAppliance(@PathParam("residentid") int residentid,
            @PathParam("usagedate") String usagedate) throws ParseException {
        
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        date = df.parse(usagedate);
        
        List<Object[]> queryList = em.createQuery
        (" SELECT h.residentid.residentid, sum(h.fridgeusage), sum(h.airconusage),"
                + " sum(h.washingmachineusage) from Houseusage h WHERE h.residentid.residentid = :residentid"
                + " AND h.usagedate = :usagedate GROUP BY h.residentid.residentid",
                Object[].class)
                    .setParameter("residentid", residentid)
                    .setParameter("usagedate", date).getResultList();        
        
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
           
        
       for (Object[] row: queryList){
       JsonObject usageObject = Json.createObjectBuilder()
               .add("ResidentID ", (int)(row[0]))
               .add("fridge ", (BigDecimal)(row[1]))
               .add("AirCon ", (BigDecimal)(row[2]))
               .add("Washing Machine ", (BigDecimal)(row[3])).build();
       arrayBuilder.add(usageObject);
   }
       JsonArray jArray = arrayBuilder.build();
       return jArray;
        
    }
    
    
    //5.2 Fetching Hourly/Daily Power Usage of Appliances for a resident based on date and view variable APPROACH 3
    @GET
    @Path("findDailyORHourlyUsageOfAppliance/{residentid}/{usagedate}/{viewvariable}")
    @Produces(MediaType.APPLICATION_JSON) 
    public Object findDailyORHourlyUsageOfAppliance(@PathParam("residentid") Integer residentid,
            @PathParam("usagedate") String usagedate, @PathParam("viewvariable") String viewvariable) 
            throws ParseException {
        
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        date = df.parse(usagedate);
        
        List<Object[]>  queryList;
        JsonArrayBuilder arrayBuilder;
      
      //if view variable is daily
      if(viewvariable.contains("daily"))
      {
        
        queryList = em.createQuery
        (" SELECT h.residentid.residentid, sum(h.fridgeusage)+ sum(h.airconusage)+ sum(h.washingmachineusage), "
                 + " AVG(h.temperature) from Houseusage h WHERE h.residentid.residentid = :residentid"
                + " AND h.usagedate = :usagedate GROUP BY h.residentid.residentid",
                Object[].class)
                    .setParameter("residentid", residentid)
                    .setParameter("usagedate", date).getResultList();    
        
             arrayBuilder = Json.createArrayBuilder();
           
        
                for (Object[] row: queryList){
                    JsonObject usageObject = Json.createObjectBuilder()
                        .add("ResidentID ", (Integer)(row[0]))
                        .add("day usage ", (BigDecimal)(row[1]))
                        .add("Temperature ", (Double)(row[2])).build();
                        arrayBuilder.add(usageObject);
                    }
       
      }
      
      //if view variable is hourly
      else
      {
      queryList = em.createQuery
        (" SELECT h.residentid.residentid, sum(h.fridgeusage)+ sum(h.airconusage)+ sum(h.washingmachineusage), "
                 + " AVG(h.temperature), h.usagedate, h.usagehour from Houseusage h "
                + " WHERE h.residentid.residentid = :residentid AND h.usagedate = :usagedate "
                + " GROUP BY h.residentid.residentid, h.usagedate, h.usagehour ",
                Object[].class)
                    .setParameter("residentid", residentid)
                    .setParameter("usagedate", date).getResultList();
                 arrayBuilder = Json.createArrayBuilder();
           
        
                for (Object[] row: queryList){
                    JsonObject usageObject = Json.createObjectBuilder()
                        .add("ResidentID ", (Integer)(row[0]))
                        .add("usage ", (BigDecimal)(row[1]))
                        .add("Temperature ", (Double)(row[2]))
                        .add("Usage Date ", (String)(row[3]).toString())
                        .add("Hour ", (Integer)(row[4])).build();
                         arrayBuilder.add(usageObject);
                }
      
      }
      
        
       JsonArray jArray = arrayBuilder.build();
       return jArray;
        
    }
    
    
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Houseusage> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Houseusage> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
