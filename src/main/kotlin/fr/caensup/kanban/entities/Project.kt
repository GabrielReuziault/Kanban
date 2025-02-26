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
    open var description: String? = null,

    @ManyToOne(optional = false)
    open var creator: User
){
    @Column(nullable = false)
    open var createdAt: Date = Date()

    @ManyToMany(mappedBy = "projects")
    open var members: MutableList<User> = mutableListOf()

    @OneToMany(mappedBy = "project", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var boards: MutableList<Board> = mutableListOf()
}