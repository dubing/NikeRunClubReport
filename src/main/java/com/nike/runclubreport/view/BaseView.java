package com.nike.runclubreport.view;

import com.yammer.dropwizard.views.View;

import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by bing.du on 4/21/14.
 */
public class BaseView extends View {
    private static final String TEMPLATE_PATH_FORMAT = "/views/page/%s.ftl";

    public BaseView(String templateName, Charset charset) {
        super(String.format(TEMPLATE_PATH_FORMAT, templateName), charset);
    }
}
