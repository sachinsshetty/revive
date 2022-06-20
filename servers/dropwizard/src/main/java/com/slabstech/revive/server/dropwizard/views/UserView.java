package com.slabstech.revive.server.dropwizard.views;

import com.slabstech.revive.server.dropwizard.core.User;
import io.dropwizard.views.View;

public class UserView extends View {
    private final User user;

    public enum Template {
        FREEMARKER("freemarker/user.ftl"),
        MUSTACHE("mustache/user.mustache");

        private String templateName;

        Template(String templateName) {
            this.templateName = templateName;
        }

        public String getTemplateName() {
            return templateName;
        }
    }

    public UserView(Template template, User user) {
        super(template.getTemplateName());
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
