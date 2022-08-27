import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    //android ui
    private val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private val material = "com.google.android.material:material:${Versions.material}"
    private val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    private val paging = "androidx.paging:paging-runtime:${Versions.paging}"

    //Lifecycle
    private val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}"
    private val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}"


    //network
    private val retrofit =  "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    private val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLogging}"
    private val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.moshiConveter}"

    //Coroutines
    private val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    private val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    //Glide
    private val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    private val glideAnnotation = "com.github.bumptech.glide:compiler:${Versions.glide}"

    //test libs
    private val junit = "junit:junit:${Versions.junit}"
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    val appLibraries = arrayListOf<String>().apply {
        add(coreKtx)
        add(appcompat)
        add(material)
        add(constraintLayout)
        add(paging)
        add(retrofit)
        add(okhttp)
        add(okhttpLogging)
        add(moshiConverter)
        add(coroutinesCore)
        add(coroutinesAndroid)
        add(glide)
        add(glideAnnotation)
        add(lifecycleRuntimeKtx)
        add(lifecycleViewModelKtx)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }
}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}