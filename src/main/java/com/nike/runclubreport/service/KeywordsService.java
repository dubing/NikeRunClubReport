package com.nike.runclubreport.service;

import com.google.inject.Inject;
import com.nike.runclubreport.dao.IKeywordDAO;
import com.nike.runclubreport.persistence.Keyword;

import java.util.Date;
import java.util.List;

/**
 * Created by bing.du on 4/22/14.
 */
public class KeywordsService implements IKeywordsService {
    private final IKeywordDAO keywordDAO;

    @Inject
    public KeywordsService(final IKeywordDAO keywordDAO) {
        this.keywordDAO = keywordDAO;
    }

    //get list of keyword
    public List<Keyword> getKeywords() {
        return keywordDAO.findAll();
    }

    public void add(String keywords, Date startTime, Date endTime) {
        keywordDAO.add(keywords, startTime, endTime);
    }

    public void update(int id, String keywords, Date startTime, Date endTime) {
        keywordDAO.update(id, keywords, startTime, endTime);
    }

    public List<Keyword> findActiveKeyWords()
    {
        return keywordDAO.findActiveKeyWords();
    }

}
