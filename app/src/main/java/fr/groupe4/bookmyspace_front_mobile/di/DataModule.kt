package fr.groupe4.bookmyspace_front_mobile.di

import fr.groupe4.bookmyspace_front_mobile.data.remote.ApiServices
import fr.groupe4.bookmyspace_front_mobile.data.repositories.BookingRepositoryImpl
import fr.groupe4.bookmyspace_front_mobile.data.repositories.SpaceRepositoryImpl
import fr.groupe4.bookmyspace_front_mobile.domain.repositories.BookingRepository
import fr.groupe4.bookmyspace_front_mobile.domain.repositories.SpaceRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

private const val BASE_URL = "http://10.4.40.254:5000/"

private val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

private val client = unsafeOkHttpClient.newBuilder()
    .addInterceptor(logger)
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(client)
    .build()

val unsafeOkHttpClient: OkHttpClient
    get() {
        try {
            // Create a trust manager that does not validate certificate chains
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {}

                override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {}

                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }
            })

            // Install the all-trusting trust manager
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, java.security.SecureRandom())

            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory = sslContext.socketFactory

            val builder = OkHttpClient.Builder()
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier { _, _ -> true }

            return builder.build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

val dataModule = module {

    single { retrofit.create(ApiServices::class.java) }

    single<SpaceRepository> { SpaceRepositoryImpl(get()) }

    single<BookingRepository> { BookingRepositoryImpl(get()) }
}