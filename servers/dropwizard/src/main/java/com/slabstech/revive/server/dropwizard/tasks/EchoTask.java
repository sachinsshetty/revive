package com.slabstech.revive.server.dropwizard.tasks

import io.dropwizard.servlets.tasks.PostBodyTask
import java.io.PrintWriter

class EchoTask : PostBodyTask("echo") {
    @Throws(Exception::class)
    override fun execute(parameters: Map<String, List<String>>, body: String, output: PrintWriter) {
        output.print(body)
        output.flush()
    }
}