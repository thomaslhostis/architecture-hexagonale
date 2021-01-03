package com.github.thomaslhostis.architecturehexagonale.core.domain.users.exceptions

class UserNotFoundException(email: String) : Exception("User with email $email doesn't exist")
