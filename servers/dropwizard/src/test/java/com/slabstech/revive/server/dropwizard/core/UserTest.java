package com.slabstech.revive.server.dropwizard.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static io.dropwizard.jackson.Jackson.newObjectMapper;
import static org.assertj.core.api.Assertions.assertThat;

/*
 * This test is used as an example in the docs - if you update it, consider
 * updating the docs too.
 */
class UserTest {
    private static final ObjectMapper MAPPER = newObjectMapper();

    @Test
    void serializesToJSON() throws Exception {
        final User user = new User("Luther Blissett", "Lead Tester", 1902);

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(getClass().getResource("/user.json"), User.class));

        assertThat(MAPPER.writeValueAsString(user)).isEqualTo(expected);
    }
}