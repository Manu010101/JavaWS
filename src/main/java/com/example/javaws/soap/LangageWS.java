package com.example.javaws.soap;

import com.example.javaws.rest.DAO.LangageDAO;
import com.example.javaws.rest.entites.Langage;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService()
public class LangageWS {

    @WebMethod(operationName = "getLangage")
    public Langage getLangage(@WebParam(name = "id") int id) {
        return LangageDAO.findById(id);
    }

    @WebMethod(operationName = "getLangageIds")
    public List<Integer> getLangageIds() {
        List<Integer> langageIds = new ArrayList<>();
        List<Langage> langages = LangageDAO.getAll();
        for (Langage langage : langages) {
            langageIds.add(langage.getId());
        }
        return langageIds;
    }

    @WebMethod(operationName = "getLangages")
    public List<Langage> getLangages() {
        return LangageDAO.getAll();
    }

}
