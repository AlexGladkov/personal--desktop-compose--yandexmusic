package data.remote.auth

import data.remote.auth.models.AuthFirstStepResult
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthRemote {

    @POST("./1/token")
    @FormUrlEncoded
    suspend fun performAuthFirstStep(
            @Field("grant_type") grantType: String,
            @Field("username") username: String,
            @Field("password") password: String,
            @Field("client_id") clientId: String,
            @Field("client_secret") clientSecret: String
    ): AuthFirstStepResult
}