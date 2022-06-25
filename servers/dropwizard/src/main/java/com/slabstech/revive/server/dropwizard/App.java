package com.slabstech.revive.server.dropwizard;


import com.slabstech.revive.server.dropwizard.auth.AppAuthenticator;
import com.slabstech.revive.server.dropwizard.auth.AppAuthorizer;
import com.slabstech.revive.server.dropwizard.cli.RenderCommand;
import com.slabstech.revive.server.dropwizard.core.Template;
import com.slabstech.revive.server.dropwizard.core.User;
import com.slabstech.revive.server.dropwizard.core.UserRole;
import com.slabstech.revive.server.dropwizard.db.UserDAO;
import com.slabstech.revive.server.dropwizard.filter.DateRequiredFeature;
import com.slabstech.revive.server.dropwizard.health.TemplateHealthCheck;
import com.slabstech.revive.server.dropwizard.resources.FilteredResource;
import com.slabstech.revive.server.dropwizard.resources.AppResource;
import com.slabstech.revive.server.dropwizard.resources.UsersResource;
import com.slabstech.revive.server.dropwizard.resources.UserResource;
import com.slabstech.revive.server.dropwizard.resources.ProtectedResource;
import com.slabstech.revive.server.dropwizard.resources.ViewResource;
import com.slabstech.revive.server.dropwizard.tasks.EchoTask;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import java.util.Map;

public class App extends Application<AppConfiguration> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    private final HibernateBundle<AppConfiguration> hibernateBundle =
            new HibernateBundle<AppConfiguration>(User.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(AppConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );

        bootstrap.addCommand(new RenderCommand());
        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(new MigrationsBundle<AppConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(AppConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(new ViewBundle<AppConfiguration>() {
            @Override
            public Map<String, Map<String, String>> getViewConfiguration(AppConfiguration configuration) {
                return configuration.getViewRendererConfiguration();
            }
        });
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) {
        final UserDAO dao = new UserDAO(hibernateBundle.getSessionFactory());
        final Template template = configuration.buildTemplate();

        environment.healthChecks().register("template", new TemplateHealthCheck(template));
        environment.admin().addTask(new EchoTask());
        environment.jersey().register(DateRequiredFeature.class);
        environment.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<UserRole>()
                .setAuthenticator(new AppAuthenticator())
                .setAuthorizer(new AppAuthorizer())
                .setRealm("SUPER SECRET STUFF")
                .buildAuthFilter()));
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(UserRole.class));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new AppResource(template));
        environment.jersey().register(new ViewResource());
        environment.jersey().register(new ProtectedResource());
        environment.jersey().register(new UsersResource(dao));
        environment.jersey().register(new UserResource(dao));
        environment.jersey().register(new FilteredResource());
    }
}
