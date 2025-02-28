package fr.caensup.kanban.controllers

import fr.caensup.kanban.dtos.ProjectDto
import fr.caensup.kanban.dtos.UserDto
import fr.caensup.kanban.entities.Project
import fr.caensup.kanban.services.ProjectService
import fr.caensup.kanban.services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController (
        private val userService: UserService
){
    @GetMapping(path = ["/",""])
    fun findAll() = userService.findAll()

    @PostMapping(path = ["/",""])
    fun save(@RequestBody user:UserDto) = userService.save(user)

}