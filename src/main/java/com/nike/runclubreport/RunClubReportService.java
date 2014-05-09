package com.nike.runclubreport;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.nike.runclubreport.command.CreateInitDataCommand;
import com.nike.runclubreport.dao.*;
import com.nike.runclubreport.resources.GroupAPIResource;
import com.nike.runclubreport.resources.HomeResource;
import com.nike.runclubreport.resources.KeywordsResource;
import com.nike.runclubreport.resources.SecurityResource;
import com.nike.runclubreport.service.*;
import com.nike.runclubreport.service.IWeChatMessageService;
import com.nike.runclubreport.service.WeChatMessageService;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.jdbi.DBIFactory;
import com.yammer.dropwizard.migrations.MigrationsBundle;
import com.yammer.dropwizard.views.ViewBundle;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by bing.du on 4/21/14.
 */
public class RunClubReportService extends Service<RunClubReportConfiguration> {

    private static final Logger log = LoggerFactory.getLogger(RunClubReportService.class);

    public static void main(String[] args) throws Exception {
        new RunClubReportService().run(args);
    }

    @Override
    public void initialize(final Bootstrap<RunClubReportConfiguration> bootstrap) {
        bootstrap.setName("Nike+ RunClub");

        bootstrap.addBundle(new AssetsBundle("/assets/css", "/css"));
        bootstrap.addBundle(new AssetsBundle("/assets/img", "/img"));
        bootstrap.addBundle(new AssetsBundle("/assets/js", "/js"));
        bootstrap.addBundle(new AssetsBundle("/assets/content", "/content"));

        bootstrap.addBundle(new ViewBundle());

        bootstrap.addBundle(
                new MigrationsBundle<RunClubReportConfiguration>() {
                    @Override
                    public DatabaseConfiguration getDatabaseConfiguration(RunClubReportConfiguration configuration) {
                        return configuration.getDatabaseConfiguration();
                    }
                });

        bootstrap.addCommand(new CreateInitDataCommand());

    }

    @Override
    public void run(final RunClubReportConfiguration config, final Environment environment) throws Exception {
        //create Java DBI
        final DBIFactory factory = new DBIFactory();
        final DBI dbi = factory.build(environment, config.getDatabaseConfiguration(), "mysql");

        // Guice injection
        Injector injector = getInjector(dbi);

        //init resource
        environment.addResource(injector.getInstance(KeywordsResource.class));
        environment.addResource(injector.getInstance(GroupAPIResource.class));
        environment.addResource(injector.getInstance(SecurityResource.class));
        environment.addResource(injector.getInstance(HomeResource.class));
    }

    private Injector getInjector(final DBI dbi){
        return Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(DBI.class).toInstance(dbi);
                bind(IKeywordDAO.class).toInstance(dbi.onDemand(IKeywordDAO.class));
                bind(IWeChatMessageDAO.class).toInstance(dbi.onDemand(IWeChatMessageDAO.class));
                bind(WeChatGroupDAO.class).toInstance(dbi.onDemand(WeChatGroupDAO.class));
                bind(WeChatMemberDAO.class).toInstance(dbi.onDemand(WeChatMemberDAO.class));
                bind(IUserDAO.class).toInstance(dbi.onDemand(IUserDAO.class));
                bind(IWeChatGroupMemberShipDAO.class).toInstance(dbi.onDemand(IWeChatGroupMemberShipDAO.class));
                bind(IWeChatGroupMonitoringDAO.class).toInstance(dbi.onDemand(IWeChatGroupMonitoringDAO.class));
                bind(IWeChatListeningMatchedMessageDAO.class).toInstance(dbi.onDemand(IWeChatListeningMatchedMessageDAO.class));
                bind(IKeywordsService.class).to(KeywordsService.class);
                bind(ISecurityService.class).to(SecurityService.class);
                bind(IWeChatGroupMemberShipService.class).to(WeChatGroupMemberShipService.class);
                bind(IWeChatGroupService.class).to(WeChatGroupService.class);
                bind(IWeChatMemberService.class).to(WeChatMemberService.class);
                bind(IWeChatMessageService.class).to(WeChatMessageService.class);
                bind(IWeChatGroupMonitoringService.class).to(WeChatGroupMonitoringService.class);
                bind(IWeChatListeningMatchedMessageService.class).to(WeChatListeningMatchedMessageService.class);
            }
        });
    }
}
