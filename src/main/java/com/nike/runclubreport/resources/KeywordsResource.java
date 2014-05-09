package com.nike.runclubreport.resources;

import com.google.inject.Inject;
import com.nike.runclubreport.service.IKeywordsService;
import com.nike.runclubreport.util.ParamFormat;
import com.nike.runclubreport.view.KeywordsView;
import com.yammer.metrics.annotation.Timed;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bing.du on 4/22/14.
 */
@Path("/keywords")
public class KeywordsResource {
    private final IKeywordsService keywordsService;

    @Inject
    public KeywordsResource(final IKeywordsService keywordsService) {
        this.keywordsService = keywordsService;
    }

    @GET
    @Timed
    public KeywordsView get() {
        return new KeywordsView(keywordsService.getKeywords());
    }

    @POST
    @Path("/add")
    public void addKeyword(@Context HttpServletResponse response,
                           @FormParam("keywords") String keywords,
                           @FormParam("startTime") String startTime,
                           @FormParam("endTime") String endTime) throws ParseException {
        keywordsService.add(keywords, ParamFormat.ConvertStringToDate(startTime), ParamFormat.ConvertStringToDate(endTime));
    }

    @POST
    @Path("/edit")
    public void updateKeyword(@Context HttpServletResponse response,
                              @FormParam("keywords") String keywords,
                              @FormParam("startTime") String startTime,
                              @FormParam("endTime") String endTime,
                              @FormParam("id") int id) throws ParseException {

        keywordsService.update(id,
                            keywords,
                            ParamFormat.ConvertStringToDate(startTime),
                            ParamFormat.ConvertStringToDate(endTime));
    }

}
