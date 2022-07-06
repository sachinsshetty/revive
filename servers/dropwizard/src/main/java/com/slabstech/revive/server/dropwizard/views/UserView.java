package com.slabstech.revive.server.dropwizard.views

import com.slabstech.revive.server.dropwizard.core.User
import io.dropwizard.views.View

class UserView(template: Template, val user: User) : View(
    template.templateName
) {

    enum class Template(val templateName: String) {
        FREEMARKER("freemarker/user.ftl"), MUSTACHE("mustache/user.mustache");

    }
}