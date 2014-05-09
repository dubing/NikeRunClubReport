package com.nike.runclubreport.resources;

import com.nike.runclubreport.dao.AbstractDAOTest;
import com.nike.runclubreport.dao.IKeywordDAO;
import com.nike.runclubreport.persistence.Keyword;
import com.nike.runclubreport.service.IKeywordsService;
import com.nike.runclubreport.service.KeywordsService;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by bing.du on 4/24/14.
 */
public class KeywordsResourceTest extends AbstractDAOTest{
    private HttpServletRequest request;
    private IKeywordDAO keywordDAO;
    private IKeywordDAO mockDAO;
    private IKeywordsService keywordsService;
    private KeywordsResource keywordsResource;
    private KeywordsResource mockResource;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        request = mock(HttpServletRequest.class);
        mockDAO = mock(IKeywordDAO.class);
        keywordDAO = createDAO(IKeywordDAO.class);
        keywordsResource = new KeywordsResource(new KeywordsService(keywordDAO));
        mockResource = new KeywordsResource(new KeywordsService(mockDAO));
    }

    @Test
    public void testViewKeyWords() throws Exception {
        List<Keyword> keywords = new ArrayList<>();
        keywords.add(new Keyword(1,"1",new Date(),new Date(),new Date()));
        keywords.add(new Keyword(2,"2",new Date(),new Date(),new Date()));
        when(mockDAO.findAll()).thenReturn(keywords);
        assertThat(mockResource.get().getKeywords().size(), equalTo(2));
    }

    @Test
    public void testAddKeyWords() throws Exception {
        assertThat(keywordsResource.get().getKeywords().size(), equalTo(0));
        keywordDAO.add("king",new Date(),new Date());
        assertThat(keywordsResource.get().getKeywords().size(), equalTo(1));
    }

    @Test
    public void testEditKeyWords() throws Exception {
        keywordDAO.add("king",new Date(),new Date());
        assertThat(keywordsResource.get().getKeywords().get(0).getKeywords(), equalTo("king"));
        keywordDAO.update(1,"qq",new Date(),new Date());
        assertThat(keywordsResource.get().getKeywords().get(0).getKeywords(), equalTo("qq"));
    }



}
