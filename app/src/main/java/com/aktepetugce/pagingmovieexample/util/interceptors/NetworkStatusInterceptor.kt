package com.aktepetugce.pagingmovieexample.util.interceptors

import com.aktepetugce.pagingmovieexample.util.error.NetworkUnavailableException
import com.aktepetugce.pagingmovieexample.util.network.ConnectionManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkStatusInterceptor @Inject constructor(
    private val connectionManager: ConnectionManager
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return if (connectionManager.isConnected) {
            chain.proceed(chain.request())
        } else {
            throw NetworkUnavailableException()
        }
    }
}
