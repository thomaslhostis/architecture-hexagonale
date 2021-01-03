package com.github.thomaslhostis.architecturehexagonale.core.domain.users.views

import java.time.LocalDateTime

class UserView(
    val email: String,
    val name: String,
    val subscriptionDate: LocalDateTime
)
