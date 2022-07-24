package com.example.javaws.rest.documentation;

import io.swagger.jaxrs.listing.ApiListingResource;

import javax.ws.rs.Path;

@Path("/api-docs/swagger.{type:json|yaml}")
public class SwaggerApiController extends ApiListingResource {
}
