plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.hilt)
}

android {
    namespace = "com.aktepetugce.pagingmovieexample"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.aktepetugce.pagingmovieexample"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
    }

    flavorDimensions.add(AppConfig.dimension)
    productFlavors {
        create("dev") {
            applicationIdSuffix = ".dev"
            dimension = AppConfig.dimension
        }
        create("prod") {
            dimension = AppConfig.dimension
        }
    }
}

dependencies {
    //app libs
    implementation(Dependencies.appLibraries)

    //kapt
    kapt(Dependencies.kaptLibraries)

    //test libs
    testImplementation(Dependencies.testLibraries)
    androidTestImplementation(Dependencies.androidTestLibraries)
}

