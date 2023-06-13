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

    //Hilt
    private val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    private val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    //Activity
    private val activityKtx = "androidx.activity:activity-ktx:${Versions.activity}"

    //Room
    private val room = "androidx.room:room-runtime:${Versions.room}"
    private val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    //SwipeRefreshLayout
    private val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"

    //test libs
    private val junit = "junit:junit:${Versions.junit}"
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    private val hiltTesting = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
    private val androidXTesting = "androidx.test:core-ktx:${Versions.androidxTesting}"

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
        add(hilt)
        add(activityKtx)
        add(swipeRefreshLayout)
        add(room)
    }

    val kaptLibraries = arrayListOf<String>().apply {
        add(hiltCompiler)
        add(roomCompiler)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
        add(hiltTesting)
        add(androidXTesting)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }
}