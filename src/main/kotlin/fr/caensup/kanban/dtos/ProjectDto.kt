package fr.caensup.kanban.dtos

import java.util.UUID

class ProjectDto(
    var id: UUID? = null,
    var name: String? = null,
    var description: String? = null,
)