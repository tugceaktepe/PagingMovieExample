package com.aktepetugce.pagingmovieexample.util.error

import java.io.IOException

class NetworkUnavailableException(message: String = "No network available :(") : IOException(message)
