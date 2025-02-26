package fr.caensup.kanban.entities

import jakarta.persistence.*
import java.util.*

@Entity
open class Project(
    @Id
    open var id: UUID= UUID.randomUUID(),

    @Column(length = 120, nullable = false)
    open var name: String? = null,

    @Column(length = 255)
    open var description: String? = null
){
    @Column(nullable = false)
    open var createdAt: Date = Date()

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    open var owner: User? = null

    @ManyToMany(mappedBy = "sharedProjects")
    open var sharedWithUsers: MutableList<User> = mutableListOf()
}