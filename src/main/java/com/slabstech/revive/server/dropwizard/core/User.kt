package com.slabstech.revive.server.dropwizard.core

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user")
@NamedQuery(name = "com.slabstech.revive.server.dropwizard.core.Product.findAll", query = "SELECT u FROM user u")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(name = "fullName", nullable = false)
    var fullName: String? = null

    @Column(name = "address", nullable = false)
    var address: String? = null

    @Column(name = "yearBorn")
    var yearBorn = 0

    constructor() {}
    constructor(fullName: String?, address: String?, yearBorn: Int) {
        this.fullName = fullName
        this.address = address
        this.yearBorn = yearBorn
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o !is User) {
            return false
        }
        val user = o
        return id == user.id && yearBorn == user.yearBorn && fullName == user.fullName && address == user.address
    }

    override fun hashCode(): Int {
        return Objects.hash(id, fullName, address, yearBorn)
    }
}