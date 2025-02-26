package fr.caensup.kanban.services


import fr.caensup.kanban.dtos.UserDto
import fr.caensup.kanban.entities.User
import fr.caensup.kanban.repositories.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService
    (
    private val userRepository: UserRepository
) {
    fun findAll() = userRepository.findAll()
    fun findById(id: UUID)= userRepository.findById(id)
    fun save(userDto: UserDto) = userRepository.save(dtoToUser(userDto))
    fun delete(id: UUID) = userRepository.deleteById(id)
    fun dtoToUser(userDto: UserDto) = User(
        id = userDto.id ?: UUID.randomUUID(),
        username = userDto.username,
        password = userDto.password,
        email = userDto.email,
        firstname = userDto.firstName,
        lastname = userDto.lastName,
    )
}