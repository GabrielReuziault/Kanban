package fr.caensup.kanban.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.*

@Entity
open class User(
    @Id
    open var id: UUID= UUID.randomUUID(),

    @Column(length = 120, nullable = false)
    open var login: String? = null,

    @Column(length = 120, nullable = false)
    open var password: String? = null,

    @Column(length = 120, nullable = false)
    open var email: String? = null,

    @Column(length = 120, nullable = false)
    open var firstname: String? = null,

    @Column(length = 120, nullable = false)
    open var lastname: String? = null,
){}