package com.github.thomaslhostis.architecturehexagonale.core.presentation.io

import com.github.thomaslhostis.architecturehexagonale.core.domain.users.entities.User
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

class UserInput(
    @NotEmpty
    @Email
    val email: String,
    @NotEmpty
    val name: String
) {

    fun toDomainInstance(): User {
        return User(email, name)
    }
}
