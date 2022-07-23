package com.example.javaws.soap;

import com.example.javaws.DAO.LangageDAO;
import com.example.javaws.entites.Langage;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService()
public class LangageWS {

    @WebMethod(operationName = "getLangage")
    public Langage getLangage(@WebParam(name = "id") int id) {
        return LangageDAO.findById(id);
    }

    @WebMethod(operationName = "getLangageIds")
    public List<Integer> getLangageIds() {
        return LangageDAO.getLangagesIds();
    }

    @WebMethod(operationName = "getLangages")
    public List<Langage> getLangages() {
        return LangageDAO.getAll();
    }

}
