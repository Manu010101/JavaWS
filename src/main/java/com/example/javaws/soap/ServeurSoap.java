package com.example.javaws.soap;

import javax.xml.ws.Endpoint;

public class ServeurSoap {

    public static void main(String[] args) {
        String url = "http://0.0.0.0:9090/";
        Endpoint.publish(url, new LangageWS());
        System.out.println("ws starts sur: " + url);
    }

}
