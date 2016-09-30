package myPackage;

import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utility.JSONConverter;

/**
 * REST Web Service
 *
 * @author Peter
 */
@Path("person")
public class RESTperson {

    PersonFacade fac;

    @Context
    private UriInfo context;

    public RESTperson() {
        fac = new PersonFacade();
        fac.addEntityManagerFactory(Persistence.createEntityManagerFactory("myPU"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String getPerson(@PathParam("id") int id) {
        return JSONConverter.getJSONfromPerson(fac.getPerson(id));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        return JSONConverter.getJSONfromPerson(fac.getPersons());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postXml(String content) {
        Person p = fac.addPerson(JSONConverter.getPersonFromJSON(content));
        return JSONConverter.getJSONfromPerson(p);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putPerson(String content) {
        fac.editPerson(JSONConverter.getPersonFromJSON(content));
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String deletePerson(@PathParam("id") int id) {
        return JSONConverter.getJSONfromPerson(fac.deletePerson(id));
    }
}
