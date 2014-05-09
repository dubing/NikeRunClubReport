package com.nike.runclubreport.resources;

import com.nike.runclubreport.view.BaseView;
import com.nike.runclubreport.view.IndexView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by andrew.bao on 4/28/14.
 */
@Path("/")
public class HomeResource {
    @GET
    public BaseView index() {
        return new IndexView();
    }
}
