package com.slabstech.revive.server.dropwizard.cli

import com.slabstech.revive.server.dropwizard.AppConfiguration
import io.dropwizard.cli.ConfiguredCommand
import io.dropwizard.setup.Bootstrap
import net.sourceforge.argparse4j.impl.Arguments
import net.sourceforge.argparse4j.inf.Namespace
import net.sourceforge.argparse4j.inf.Subparser
import org.slf4j.LoggerFactory
import java.lang.Boolean
import java.util.*
import kotlin.Exception
import kotlin.String
import kotlin.Throws

class RenderCommand : ConfiguredCommand<AppConfiguration>("render", "Render the template data to console") {
    override fun configure(subparser: Subparser) {
        super.configure(subparser)
        subparser.addArgument("-i", "--include-default")
            .action(Arguments.storeTrue())
            .dest("include-default")
            .help("Also render the template with the default name")
        subparser.addArgument("names").nargs("*")
    }

    @Throws(Exception::class)
    override fun run(
        bootstrap: Bootstrap<AppConfiguration>,
        namespace: Namespace,
        configuration: AppConfiguration
    ) {
        val template = configuration.buildTemplate()
        if (Boolean.TRUE == namespace.getBoolean("include-default")) {
            if (template != null) {
                LOGGER.info("DEFAULT => {}", template.render(Optional.empty()))
            }
        }
        for (name in namespace.getList<String>("names")) {
            for (i in 0..999) {
                if (template != null) {
                    LOGGER.info("{} => {}", name, template.render(Optional.of(name)))
                }
                Thread.sleep(1000)
            }
        }
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(RenderCommand::class.java)
    }
}