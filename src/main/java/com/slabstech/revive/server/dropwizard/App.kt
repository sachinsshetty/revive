package com.slabstech.revive.server.dropwizard

import com.slabstech.revive.server.dropwizard.auth.AppAuthenticator
import com.slabstech.revive.server.dropwizard.auth.AppAuthorizer
import com.slabstech.revive.server.dropwizard.cli.RenderCommand
import com.slabstech.revive.server.dropwizard.core.User
import com.slabstech.revive.server.dropwizard.core.UserRole
import com.slabstech.revive.server.dropwizard.db.UserDAO
import com.slabstech.revive.server.dropwizard.filter.DateRequiredFeature
import com.slabstech.revive.server.dropwizard.health.TemplateHealthCheck
import com.slabstech.revive.server.dropwizard.resources.*
import com.slabstech.revive.server.dropwizard.tasks.EchoTask
import io.dropwizard.Application
import io.dropwizard.assets.AssetsBundle
import io.dropwizard.auth.AuthDynamicFeature
import io.dropwizard.auth.AuthValueFactoryProvider
import io.dropwizard.auth.basic.BasicCredentialAuthFilter
import io.dropwizard.configuration.EnvironmentVariableSubstitutor
import io.dropwizard.configuration.SubstitutingSourceProvider
import io.dropwizard.db.DataSourceFactory
import io.dropwizard.db.PooledDataSourceFactory
import io.dropwizard.hibernate.HibernateBundle
import io.dropwizard.migrations.MigrationsBundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import io.dropwizard.views.ViewBundle
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature

//import com.okta.jwt.JwtHelper;
class App : Application<AppConfiguration>() {
    private val hibernateBundle: HibernateBundle<AppConfiguration?> = object : HibernateBundle<AppConfiguration?>(
        User::class.java
    ) {
        override fun getDataSourceFactory(p0: AppConfiguration?): PooledDataSourceFactory? {
            return configuration.dataSourceFactory!!
        }
    }

    override fun getName(): String {
        return "hello-world"
    }

    override fun initialize(bootstrap: Bootstrap<AppConfiguration>) {
        // Enable variable substitution with environment variables
        bootstrap.configurationSourceProvider = SubstitutingSourceProvider(
            bootstrap.configurationSourceProvider,
            EnvironmentVariableSubstitutor(false)
        )
        bootstrap.addCommand(RenderCommand())
        bootstrap.addBundle(AssetsBundle())
        bootstrap.addBundle(object : MigrationsBundle<AppConfiguration?>() {
            override fun getDataSourceFactory(p0: AppConfiguration?): PooledDataSourceFactory? {
                return configuration.dataSourceFactory!!
            }
        })
        bootstrap.addBundle(hibernateBundle)
        bootstrap.addBundle(object : ViewBundle<AppConfiguration>() {
            override fun getViewConfiguration(configuration: AppConfiguration): Map<String, Map<String, String>> {
                return configuration.viewRendererConfiguration!!
            }
        })
    }

    /*

    private void configureOAuth(final AppConfiguration configuration, final Environment environment) {
        try {
            OktaOAuthConfig widgetConfig = configuration.oktaOAuth;
            // Configure the JWT Validator, it will validate Okta's JWT access tokens
            JwtHelper helper = new JwtHelper()
                    .setIssuerUrl(widgetConfig.issuer)
                    .setClientId(widgetConfig.clientId);

            // set the audience only if set, otherwise the default is: api://default
            String audience = widgetConfig.audience;
            if (StringUtils.isNotEmpty(audience)) {
                helper.setAudience(audience);
            }

            // register the OktaOAuthAuthenticator
            environment.jersey().register(new AuthDynamicFeature(
                    new OAuthCredentialAuthFilter.Builder<AccessTokenPrincipal>()
                            .setAuthenticator(new OktaOAuthAuthenticator(helper.build()))
                            .setPrefix("Bearer")
                            .buildAuthFilter()));

            // Bind our custom principal to the @Auth annotation
            environment.jersey().register(new AuthValueFactoryProvider.Binder<>(AccessTokenPrincipal.class));
        } catch (Exception e) {
            throw new IllegalStateException("Failed to configure JwtVerifier", e);
        }
    }


     */
    override fun run(configuration: AppConfiguration, environment: Environment) {
        val dao = UserDAO(hibernateBundle.sessionFactory)
        val template = configuration.buildTemplate()
        environment.healthChecks().register("template", template?.let { TemplateHealthCheck(it) })
        environment.admin().addTask(EchoTask())
        environment.jersey().register(DateRequiredFeature::class.java)
        environment.jersey().register(
            AuthDynamicFeature(
                BasicCredentialAuthFilter.Builder<UserRole>()
                    .setAuthenticator(AppAuthenticator())
                    .setAuthorizer(AppAuthorizer())
                    .setRealm("SUPER SECRET STUFF")
                    .buildAuthFilter()
            )
        )

        // configure OAuth
        //  configureOAuth(configuration, environment);
        environment.jersey().register(AuthValueFactoryProvider.Binder(UserRole::class.java))
        environment.jersey().register(RolesAllowedDynamicFeature::class.java)
        environment.jersey().register(template?.let { AppResource(it) })
        environment.jersey().register(ViewResource())
        environment.jersey().register(ProtectedResource())
        environment.jersey().register(UsersResource(dao))
        environment.jersey().register(UserResource(dao))
        environment.jersey().register(FilteredResource())
    }

    companion object {
        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {
            App().run(*args)
        }
    }
}