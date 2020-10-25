package data

import data.remote.auth.AuthRemote
import data.remote.user.UserRemote
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Application private constructor() {

    lateinit var authRemote: AuthRemote
    lateinit var userRemote: UserRemote

    companion object {
        private var application: Application? = null

        fun getInstance(): Application {
            if (application == null) {
                application = Application()
            }

            application?.createRetrofitInstances()
            return application!!
        }
    }

    private fun createRetrofitInstances() {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.music.yandex.net/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val oauthRetrofit = Retrofit.Builder()
                .baseUrl("https://oauth.mobile.yandex.net/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        authRemote = oauthRetrofit.create(AuthRemote::class.java)
        userRemote = retrofit.create(UserRemote::class.java)
    }
}