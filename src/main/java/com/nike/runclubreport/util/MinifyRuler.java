package com.nike.runclubreport.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bing.du on 5/8/14.
 */
public class MinifyRuler {
    private HashMap<String,String> minifyMap;

    public MinifyRuler() {
        minifyMap = new HashMap<String,String>();
        minifyMap.put("https://wx.qq.com/zh_CN/htmledition/images/qqface/", "wx[qqface]");
    }

    public HashMap getMinifyMap() {
        return minifyMap;
    }

    public String convert(String s) {
        for(Map.Entry<String, String> entry : minifyMap.entrySet()) {
            s = s.replaceAll(entry.getKey(), entry.getValue());
        }
        return s;
    }

}
