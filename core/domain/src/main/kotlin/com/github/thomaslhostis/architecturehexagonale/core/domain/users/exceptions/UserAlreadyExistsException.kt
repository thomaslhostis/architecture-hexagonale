package com.github.thomaslhostis.architecturehexagonale.core.domain.users.exceptions

class UserAlreadyExistsException(email: String) : Exception("User with email $email already exists")
