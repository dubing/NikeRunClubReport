package com.nike.runclubreport.resources;

import com.nike.runclubreport.model.LoginResult;
import com.nike.runclubreport.model.ReportUser;
import com.nike.runclubreport.service.ISecurityService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.google.inject.Inject;

/**
 * Created by andrew.bao on 4/24/14.
 */
@Path("/security")
public class SecurityResource {

    private final ISecurityService securityService;

    @Inject
    public SecurityResource(final ISecurityService securityService){
        this.securityService = securityService;
    }

    @Path("/login")
    @POST
    public LoginResult login(@FormParam("username") String userName, @FormParam("password") String password) {
        return this.securityService.validateUser(userName, password);
    }
}
