package fr.caensup.kanban.dtos

import java.util.UUID

data class UserDto(
    var id: UUID? = null,
    var username: String? = null,
    var password: String? = null,
    var email: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
)