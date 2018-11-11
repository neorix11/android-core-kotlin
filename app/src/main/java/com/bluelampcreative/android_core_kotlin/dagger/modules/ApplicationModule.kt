package com.bluelampcreative.android_core_kotlin.dagger.modules

import android.content.Context.MODE_PRIVATE
import com.bluelampcreative.android_core_kotlin.BuildConfig
import com.bluelampcreative.android_core_kotlin.MainApplication
import com.bluelampcreative.android_core_kotlin.dagger.DaggerConstants.Companion.AUTH_OKHTTP
import com.bluelampcreative.android_core_kotlin.dagger.DaggerConstants.Companion.AUTH_RETROFIT
import com.bluelampcreative.android_core_kotlin.dagger.DaggerConstants.Companion.OKHTTP
import com.bluelampcreative.android_core_kotlin.dagger.DaggerConstants.Companion.RETROFIT
import com.bluelampcreative.android_core_kotlin.data.local.SharedPreferenceService
import com.bluelampcreative.android_core_kotlin.utility.NetworkUtility
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class ApplicationModule(private val application: MainApplication) {

    @Provides
    fun provideSharedPreferencesService()
            = SharedPreferenceService(application.getSharedPreferences(SharedPreferenceService.SHARED_PREFS, MODE_PRIVATE), Gson())

    @Provides
    fun provideNetworkUtility() = NetworkUtility(application.applicationContext)

    @Provides
    @Named(OKHTTP)
    fun getOkHttp(): OkHttpClient {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
    }

    @Provides
    @Named(AUTH_OKHTTP)
    fun getAuthOkHttp(sharedPreferencesService: SharedPreferenceService): OkHttpClient {

        val requestInterceptor = Interceptor { chain ->
            chain.proceed(
                    chain.request()
                            .newBuilder()
                            /*.addHeader("Authorization", String.format("Bearer %s",
                                    sharedPreferencesService.getObject(AUTH_TOKEN, String::class.java)))*/
                            .build()
            )
        }

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(logging)
                .build()
    }

    @Provides
    @Named(RETROFIT)
    fun getRetrofit(@Named(OKHTTP) okHttpClient: OkHttpClient) = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Named(AUTH_RETROFIT)
    fun getAuthRetrofit(@Named(AUTH_OKHTTP) okHttpClient: OkHttpClient) = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}