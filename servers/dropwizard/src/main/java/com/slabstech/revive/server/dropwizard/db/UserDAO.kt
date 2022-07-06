package com.slabstech.revive.server.dropwizard.db

import com.slabstech.revive.server.dropwizard.core.User
import io.dropwizard.hibernate.AbstractDAO
import org.hibernate.SessionFactory
import java.util.*

class UserDAO(factory: SessionFactory?) : AbstractDAO<User?>(factory) {
    fun findById(id: Long?): Optional<User> {
        return Optional.ofNullable(get(id))
    }

    fun create(user: User?): User? {
        return persist(user)
    }

    fun findAll(): List<User?> {
        return list(namedTypedQuery("com.slabstech.revive.server.dropwizard.core.User.findAll"))
    }
}