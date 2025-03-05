package fr.caensup.kanban.controllers

import fr.caensup.kanban.dtos.UserDto
import fr.caensup.kanban.entities.User
import fr.caensup.kanban.repositories.UserRepository
import fr.caensup.kanban.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@CrossOrigin(origins = ["http://127.0.0.1:3000"])
@RequestMapping("/users")
class UserController(
    private val userService: UserService,
    private val userRepository: UserRepository
){
    @GetMapping(path = ["/",""])
    fun findAll() = userService.findAll()

    @PostMapping(path = ["/",""])
    fun save(@RequestBody user:UserDto):ResponseEntity<User>{
        val savedUser=userService.save(user)
        return ResponseEntity(savedUser, HttpStatus.CREATED)
    }

    @DeleteMapping(path = ["/{id}"])
    fun deleteById(@PathVariable id:UUID):ResponseEntity<Void>{
        if(userRepository.existsById(id)){
            userService.deleteById(id)
            return ResponseEntity(HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PutMapping(path = ["/{id}"])
    fun updateById(@PathVariable id:UUID, @RequestBody user:UserDto): ResponseEntity<User> {
        if(userRepository.existsById(id)){
            return ResponseEntity.ok(userService.save(user))
        }
        return ResponseEntity.notFound().build()
    }

}