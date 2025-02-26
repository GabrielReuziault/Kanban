package fr.caensup.kanban.entities

import jakarta.persistence.*
import java.util.UUID

@Entity
open class Board(
    @Id
    open var id: UUID= UUID.randomUUID(),

    @Column(length = 255, nullable = false)
    open var name: String? = null,

    @Column(length = 120)
    open var description: String? = null,
    ) {

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    open var project: Project? = null

}