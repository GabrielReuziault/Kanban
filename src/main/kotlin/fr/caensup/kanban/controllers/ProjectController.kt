package fr.caensup.kanban.controllers

import fr.caensup.kanban.dtos.ProjectDto
import fr.caensup.kanban.services.ProjectService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/projects")
class ProjectController(private val projectService: ProjectService) {
    @GetMapping(path = ["/", ""])
    fun findAll() = projectService.findAll()

    @PostMapping(path = ["/", ""])
    fun save(@RequestBody project: ProjectDto)= projectService.save(project)

    @PostMapping(path = ["/{id}/members"])
    fun addMembers(@RequestBody project: ProjectDto)= projectService.addMembers()
}