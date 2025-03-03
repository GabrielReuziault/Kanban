package fr.caensup.kanban.entities

import jakarta.persistence.*

@Entity
open class Board:BaseWithName() {

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    open var project: Project? = null

}