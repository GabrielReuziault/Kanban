package fr.caensup.kanban.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import java.util.*

@Entity
open class Project(
    id: UUID = UUID.randomUUID(),
    name: String? = null,
    description: String? = null,
    @ManyToOne(optional = false)
    open var creator:User
):BaseWithName(
    id = id,
    name = name,
    description = description
)
{
    @Column(nullable = false)
    open var createdAt:Date = Date()

    @ManyToMany
    open var members:MutableList<User> = mutableListOf()
}