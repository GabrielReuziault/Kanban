package fr.caensup.kanban.entities

import jakarta.persistence.*
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
){

    @OneToMany(mappedBy = "owner", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var ownedProjects: MutableList<Project> = mutableListOf()

    @ManyToMany
    @JoinTable(
        name = "shared_projects",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "project_id")]
    )
    open var sharedProjects: MutableList<Project> = mutableListOf()
}