package com.github.thomaslhostis.architecturehexagonale.core.domain.users

import com.github.thomaslhostis.architecturehexagonale.core.domain.users.entities.User
import com.github.thomaslhostis.architecturehexagonale.core.domain.users.views.UserView

interface UserProjectionRepository {
    fun userExists(email: String): Boolean
    fun createUser(user: User)
    fun updateUser(user: User)
    fun deleteUser(email: String)
    fun findUser(email: String): UserView?
    fun findAllUsers(): List<UserView>
}
