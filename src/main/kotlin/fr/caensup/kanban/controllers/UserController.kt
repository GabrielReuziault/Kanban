package fr.caensup.kanban.controllers

import fr.caensup.kanban.dtos.UserDto
import fr.caensup.kanban.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {
    @GetMapping(path = ["/", ""])
    fun findAll() = userService.findAll()

    @PostMapping(path = ["/", ""])
    fun save(@RequestBody user: UserDto)= userService.save(user)

}