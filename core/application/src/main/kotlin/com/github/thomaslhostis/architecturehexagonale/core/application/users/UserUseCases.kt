package com.github.thomaslhostis.architecturehexagonale.core.application.users

import com.github.thomaslhostis.architecturehexagonale.core.domain.users.UserProjectionRepository
import com.github.thomaslhostis.architecturehexagonale.core.domain.users.entities.User
import com.github.thomaslhostis.architecturehexagonale.core.domain.users.exceptions.UserAlreadyExistsException
import com.github.thomaslhostis.architecturehexagonale.core.domain.users.exceptions.UserNotFoundException
import com.github.thomaslhostis.architecturehexagonale.core.domain.users.views.UserView
import org.springframework.stereotype.Component

@Component
class UserUseCases(private val userProjectionRepository: UserProjectionRepository) {

    fun createUser(user: User) {
        if (userProjectionRepository.userExists(user.email)) {
            throw UserAlreadyExistsException(user.email)
        }
        userProjectionRepository.createUser(user)
    }

    fun updateUser(user: User) {
        if (!userProjectionRepository.userExists(user.email)) {
            throw UserNotFoundException(user.email)
        }
        userProjectionRepository.updateUser(user)
    }

    fun deleteUser(email: String) {
        if (!userProjectionRepository.userExists(email)) {
            throw UserNotFoundException(email)
        }
        userProjectionRepository.deleteUser(email)
    }

    fun findUser(email: String): UserView {
        return userProjectionRepository.findUser(email) ?: throw UserNotFoundException(email)
    }

    fun findAllUsers(): List<UserView> {
        return userProjectionRepository.findAllUsers()
    }
}
