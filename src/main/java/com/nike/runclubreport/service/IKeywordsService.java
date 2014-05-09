package com.nike.runclubreport.service;

import com.nike.runclubreport.persistence.Keyword;

import java.util.Date;
import java.util.List;

/**
 * Created by bing.du on 4/22/14.
 */
public interface IKeywordsService {
    //get list of keyword
    List<Keyword> getKeywords();

    List<Keyword> findActiveKeyWords();

    void add(String keywords, Date startTime, Date endTime);

    void update(int id, String keywords, Date startTime, Date endTime);
}
