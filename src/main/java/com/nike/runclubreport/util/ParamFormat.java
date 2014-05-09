package com.nike.runclubreport.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bing.du on 4/24/14.
 */
public  class ParamFormat {
    public static Date ConvertStringToDate(String param) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(param);
    }
}
