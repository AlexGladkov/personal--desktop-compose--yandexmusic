package data.remote.auth

import data.remote.user.UserRemote
import kotlinx.coroutines.delay

interface AuthRepository {

    suspend fun performLogin(email: String, password: String): Boolean
}

class AuthRepositoryImpl(
        private val authRemote: AuthRemote,
        private val userRemote: UserRemote
) : AuthRepository {

    override suspend fun performLogin(email: String, password: String): Boolean {
        delay(3000)

        val clientId = "23cabbbdc6cd418abb4b39c32c41195d"
        val clientSecret = "53bc75238f0c4d08a118e51fe9203300"

        val deviceId = "377c5ae26b09fccd72deae0a95425559"
        val uuid = "3cfccdaf75dcf98b917a54afe50447ba"
        val packageName = "ru.yandex.music"

        val firstStepResult = authRemote.performAuthFirstStep(
                grantType = "password",
                username = email,
                password = password,
                clientId = clientId,
                clientSecret = clientSecret
        )

        val user = userRemote.fetchUser("OAuth ${firstStepResult.accessToken}")
//        authRemote.performAuthSecondStep(
//                deviceId = deviceId,
//                accessToken = firstStepResult.accessToken,
//                packageName = packageName,
//                uuid = uuid,
//                clientId = clientId,
//                clientSecret = clientSecret,
//                grantType = "x-token"
//        )

        return true
    }
}