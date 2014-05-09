package com.nike.runclubreport.dao;

import liquibase.Liquibase;
import liquibase.database.jvm.HsqlConnection;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.h2.jdbcx.JdbcConnectionPool;
import org.junit.After;
import org.junit.Before;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import java.sql.Connection;

/**
 * Created by bing.du on 4/24/14.
 */
public class AbstractDAOTest {

    protected Handle handle;
    private JdbcConnectionPool ds;
    private DBI dbi;

    @Before
    public void setUp() throws Exception {
        ds = JdbcConnectionPool.create("jdbc:h2:mem:test2", "username", "password");

        Connection connection = ds.getConnection();
        Liquibase liquibase = new Liquibase("migrations.xml", new ClassLoaderResourceAccessor(), new HsqlConnection(connection));
        liquibase.update(" ");
        connection.close();

        dbi = new DBI(ds);
        handle = dbi.open();
    }

    @After
    public void tearDown() throws Exception {
        handle.close();
        ds.dispose();
    }

    protected <SqlObjectType> SqlObjectType createDAO(Class<SqlObjectType> daoClass) {
        return handle.attach(daoClass);
    }
}

