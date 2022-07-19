package com.example.javaws.rest;

import com.example.javaws.rest.DAO.LangageDAO;
import com.example.javaws.rest.entites.Langage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/langage")
public class LangageResource {
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLangage(@PathParam("id") int id){
        Langage langage = LangageDAO.findById(id);
        if (langage != null){
            return Response
                    .ok(langage)
                    .build();
        }
        return Response.status(404).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        try {
            List<Langage> langages = LangageDAO.getAll();
            return Response
                    .ok(langages)
                    .build();
        }catch (Exception exception){
            return Response.status(500).build();
        }

    }

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createLangage(@FormParam("nom") String nom, @FormParam("caracteristiques") String caracteristiques){
        try {
        Langage langage = new Langage(nom, caracteristiques);
        LangageDAO.create(langage);

        return Response
                .ok(langage)
                .build();
        }catch (Exception exception){
            return Response.status(500).build();
        }
    }

    @GET
    @Path("/delete/{id}")
    public Response deleteLangage(@PathParam("id") int id){
        LangageDAO.destroy(id);
        return Response.status(200).build();
    }

}
