/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restTestSystem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import su.jet.testsystem.Client;
import su.jet.testsystem.ClientHolder;

/**
 * REST Web Service
 *
 * @author sergey
 */
@Path("RestTestSystem")
public class RestTestSystemResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestTestSystemResource
     */
    public RestTestSystemResource() {
    }

    /**
     * Retrieves representation of an instance of restTestSystem.RestTestSystemResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClient() {
        System.out.println("Rest getClient called");
        Client client = ClientHolder.getInstance().getClient();
        if (client!=null){
       return Response.ok(client).build();
        }
        return Response.status(404).build();
  //   return Response.ok(new Client("Иванов","Иван","Иванович",100,"1234567890123456","+71234567890")).build();
    }

    /**
     * PUT method for updating or creating an instance of RestTestSystemResource
     * @param content representation for the resource
     */
    @PUT
     @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addClient(Client client) {
        System.out.println("Rest addClient called");
         Pattern pattern = Pattern.compile("[0-9]{16}", Pattern.CASE_INSENSITIVE);
        if(client.getAccount().length()>16||client.getAccount().length()<16){
            System.out.println("<>16");
            return Response.status(Response.Status.BAD_REQUEST).entity("\"status\":\"Ошибка ввода номера счета: введите 16 цифр\"").build();
            
        } 
        Matcher matcher = pattern.matcher(client.getAccount());
        if(!matcher.find()){
             return Response.status(Response.Status.BAD_REQUEST).entity("\"status\":\"Ошибка ввода номера счета: введите 16 цифр\"").build();
        }
        Pattern patternBalance = Pattern.compile("^\\d+$", Pattern.CASE_INSENSITIVE);
        matcher = patternBalance.matcher(client.getBalance());
        if(!matcher.find()){
             return Response.status(Response.Status.BAD_REQUEST).entity("\"status\":\"Ошибка ввода баланса: введите число\"").build();

        }
        Pattern patternPhone = Pattern.compile("^\\+[0-9]{11}$", Pattern.CASE_INSENSITIVE);
         matcher = patternPhone.matcher(client.getPhone());
         if(!matcher.find()){
              return Response.status(Response.Status.BAD_REQUEST).entity("\"status\":\"Ошибка ввода номера телефона: некорректный формат\"").build();

        }
        ClientHolder.getInstance().addClient(client);
        return Response.ok("{\"status\":\""+client.getFirstname()+" "+client.getSurname()+" success add\"}").build();
    }
}
