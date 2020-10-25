package data.remote.user.models

data class UserRemoteResponse(
        val result: UserRemoteModel
)

data class UserRemoteModel(
        val result: UserRemoteAccount
)

data class UserRemoteAccount(
        val fullName: String,
        val displayName: String,
)