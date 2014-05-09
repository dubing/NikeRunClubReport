package com.nike.runclubreport.view;

import com.google.common.base.Charsets;
import com.nike.runclubreport.persistence.Keyword;

import java.util.List;

/**
 * Created by bing.du on 4/22/14.
 */
public class KeywordsView extends BaseView {
    private List<Keyword> keywords;


    public KeywordsView(List<Keyword> keywords) {
        super(ViewNames.KeywordsView, Charsets.UTF_8);
        this.keywords = keywords;
    }

    public List<Keyword> getKeywords()
    {
        return keywords;
    }
}
