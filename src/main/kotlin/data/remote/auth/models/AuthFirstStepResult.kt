package data.remote.auth.models

import com.google.gson.annotations.SerializedName

data class AuthFirstStepResult(
        @SerializedName("access_token")
        val accessToken: String,

        @SerializedName("expires_in")
        val expiresIn: Long,

        @SerializedName("token_type")
        val tokenType: String,

        @SerializedName("uid")
        val uniqueId: Long
)