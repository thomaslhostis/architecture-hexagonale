package com.github.thomaslhostis.architecturehexagonale.core.presentation.controllers

import com.github.thomaslhostis.architecturehexagonale.core.application.users.UserUseCases
import com.github.thomaslhostis.architecturehexagonale.core.domain.users.entities.User
import com.github.thomaslhostis.architecturehexagonale.core.presentation.io.UserInput
import com.github.thomaslhostis.architecturehexagonale.core.presentation.io.UserOutput
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("/api/users")
class UsersController(private val userUseCases: UserUseCases) {

    @PostMapping
    fun createUser(@Valid @RequestBody userInput: UserInput): ResponseEntity<String> {
        val user: User = userInput.toDomainInstance()
        userUseCases.createUser(user)
        return ResponseEntity.created(URI.create("/api/users/${user.email}")).build()
    }

    @PutMapping
    fun updateUser(@Valid @RequestBody userInput: UserInput): ResponseEntity<String> {
        val user: User = userInput.toDomainInstance()
        userUseCases.updateUser(user)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{email:.*}")
    fun deleteUser(@PathVariable("email") email: String): ResponseEntity<String> {
        userUseCases.deleteUser(email)
        return ResponseEntity.ok("User $email deleted")
    }

    @GetMapping(value = ["/{email:.+}"])
    fun getUser(@PathVariable("email") email: String): ResponseEntity<UserOutput> {
        val userView = userUseCases.findUser(email)
        val userOutput = UserOutput(userView)
        return ResponseEntity.ok(userOutput)
    }

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<UserOutput>> {
        val userViews = userUseCases.findAllUsers()
        val userOutputs = UserOutput.fromViews(userViews)
        return ResponseEntity.ok(userOutputs)
    }
}
