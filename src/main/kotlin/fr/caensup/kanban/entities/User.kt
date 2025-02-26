package fr.caensup.kanban.entities

import jakarta.persistence.*
import java.util.*

@Entity
open class User(
    @Id
    open var id: UUID= UUID.randomUUID(),

    @Column(length = 60, nullable = false, unique = true)
    open var username: String? = null,

    @Column(length = 255, nullable = false)
    open var password: String? = null,

    @Column(length = 255, nullable = false, unique = true)
    open var email: String? = null,

    @Column(length = 60)
    open var firstname: String? = null,

    @Column(length = 60)
    open var lastname: String? = null,
){

    @OneToMany(mappedBy = "creator", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var myProjects: MutableList<Project> = mutableListOf()

    @ManyToMany
    @JoinTable(
        name = "shared_projects",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "project_id")]
    )
    open var projects: MutableList<Project> = mutableListOf()
}