package com.github.thomaslhostis.architecturehexagonale.core.presentation.io

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.thomaslhostis.architecturehexagonale.core.domain.users.views.UserView
import java.time.LocalDateTime

class UserOutput(
    val email: String,
    val name: String,
    @JsonProperty("subscription_date")
    val subscriptionDate: LocalDateTime
) {

    constructor(userView: UserView) : this(
        userView.email,
        userView.name,
        userView.subscriptionDate
    )

    companion object {
        fun fromViews(userViews: List<UserView>): List<UserOutput> {
            return userViews.map(::UserOutput)
        }
    }
}
