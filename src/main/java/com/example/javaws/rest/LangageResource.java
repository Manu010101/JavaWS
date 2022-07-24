package com.example.javaws.rest;

import com.example.javaws.DAO.LangageDAO;
import com.example.javaws.entites.Ide;
import com.example.javaws.entites.Langage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/langages")
public class LangageResource {
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        try {
            List<Langage> langages = LangageDAO.getAll();
            return Response
                    .ok(langages)
                    .build();
        } catch (Exception exception) {
            return Response.status(500).build();
        }

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLangage(@PathParam("id") int id) {
        Langage langage = LangageDAO.findById(id);
        if (langage != null) {
            return Response
                    .ok(langage)
                    .build();
        }
        return Response.status(404).build();
    }

    @Path("")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createLangage(@FormParam("nom") String nom, @FormParam("caracteristiques") String caracteristiques) {
        try {
            Langage langage = new Langage(nom, caracteristiques);
            LangageDAO.create(langage);

            return Response
                    .ok(langage)
                    .status(201)
                    .build();
        } catch (Exception exception) {
            return Response.status(500).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteLangage(@PathParam("id") int id) {
        if (!LangageDAO.getLangagesIds().contains(id)) {
            return Response.status(404).build();
        }
        try {
            LangageDAO.destroy(id);
            return Response.status(200).build();
        } catch (Exception exception) {
            return Response.status(500).build();
        }

    }

    @GET
    @Path("/{id}/ides")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLangageWithIdes(@PathParam("id") int id) {
        Langage langage = LangageDAO.findById(id);
        List<Ide> ides = LangageDAO.getIdesAssociesToLangage(id);
        List<Object> reponse = new ArrayList<>();
        reponse.add(langage);
        reponse.add(ides);
        return Response.ok(reponse).build();
    }

    @GET
    @Path("/ids")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLangagesIds() {
        return Response.ok(LangageDAO.getLangagesIds()).build();
    }


}
