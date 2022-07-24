package com.example.javaws.rest;

import com.example.javaws.rest.documentation.SwaggerApiController;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.Contact;
import io.swagger.models.Info;
import io.swagger.models.Swagger;

import javax.servlet.ServletConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class WSApplication extends Application {

    //pour faire de la documentation

    private final Set<Object> singletons = new HashSet<>();

    public WSApplication(@Context ServletConfig sc){
        initializeSwagger(sc);
        buildRestControllers();
    }

    private void buildRestControllers() {
        singletons.add(new SwaggerApiController());
    }

    private void initializeSwagger(ServletConfig sc) {
        Info info = new Info()
                .title("API REST Java")
                .description("Expose des langages de programmation avec des commentaires pertinents")
                .contact(new Contact().email("no@mail.com").name("manu"));
        Swagger swagger = new Swagger().info(info);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setResourcePackage("com.documentation");
        beanConfig.setInfo(info);
        beanConfig.setBasePath("/ws");
        beanConfig.configure(swagger);
        new SwaggerContextService()
                .withServletConfig(sc)
                .withScanner(beanConfig)
                .updateSwagger(swagger)
                .initScanner();
    }



}