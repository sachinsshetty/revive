package com.slabstech.revive.server.dropwizard.core

import com.fasterxml.jackson.databind.ObjectMapper
import io.dropwizard.jackson.Jackson
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/*
 * This test is used as an example in the docs - if you update it, consider
 * updating the docs too.
 */
internal class UserTest {
    @Test
    @Throws(Exception::class)
    fun serializesToJSON() {
        val user = User("Luther Blissett", "Lead Tester", 1902)
        val expected: String = MAPPER.writeValueAsString(
            MAPPER.readValue(javaClass.getResource("/user.json"), User::class.java)
        )
        assertThat(MAPPER.writeValueAsString(user)).isEqualTo(expected)
    }

    companion object {
        private val MAPPER: ObjectMapper = Jackson.newObjectMapper()
    }
}