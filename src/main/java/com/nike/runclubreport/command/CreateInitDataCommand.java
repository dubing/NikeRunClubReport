package com.nike.runclubreport.command;

import com.nike.runclubreport.RunClubReportConfiguration;
import com.yammer.dropwizard.cli.ConfiguredCommand;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.DBIFactory;
import net.sourceforge.argparse4j.inf.Namespace;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bing.du on 4/21/14.
 */
public class CreateInitDataCommand extends ConfiguredCommand<RunClubReportConfiguration> {
    private static final Logger log = LoggerFactory.getLogger(CreateInitDataCommand.class);

    public CreateInitDataCommand() {
        super("initdata", "Creates sample user, run crew test data in the system.");
    }

    @Override
    protected void run(final Bootstrap<RunClubReportConfiguration> bootstrap, final Namespace namespace, final RunClubReportConfiguration configuration) throws Exception {

        Environment tempEnvironment = new Environment("temporary", configuration, null, null);

        DBIFactory factory = new DBIFactory();
        DBI jdbi = factory.build(tempEnvironment, configuration.getDatabaseConfiguration(), "mysql");

        log.debug("Creating test community manager...");

        log.debug("...complete.");


    }
}
