package data.remote.user

import data.remote.user.models.UserRemoteResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface UserRemote {

    @GET("./account/status")
    suspend fun fetchUser(@Header("Authorization") token: String): UserRemoteResponse
}