package fr.caensup.kanban.dtos

import java.util.UUID

class UserDto(
    var id: UUID? = null,
    var login: String? = null,
    var password: String? = null,
    var email: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
)