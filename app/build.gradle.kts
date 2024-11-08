plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
    id ("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.newsapiclient"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.newsapiclient"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        buildConfigField ("String", "API_KEY", project.properties["MY_KEY"].toString())
        buildConfigField ("String", "BASE_URL", project.properties["MY_URL"].toString())

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources=true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        buildConfig=true
        viewBinding=true
    }
}

dependencies {
    //gson
    implementation (libs.gson)
    //coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //Room
    implementation (libs.androidx.room.runtime)
    kapt (libs.androidx.room.compiler)
    implementation (libs.androidx.room.ktx)

    // ViewModel
    implementation (libs.androidx.lifecycle.viewmodel.ktx)

    // LiveData
    implementation (libs.androidx.lifecycle.livedata.ktx)

    // Annotation processor
    kapt (libs.androidx.lifecycle.compiler)

    //hilt
    implementation (libs.hilt.android)
    kapt (libs.hilt.compiler)

    // Views/Fragments Integration
    implementation (libs.androidx.navigation.fragment.ktx)
    implementation (libs.androidx.navigation.ui)

    implementation(libs.okhttp)

    //glide
    implementation (libs.glide)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.mockwebserver)
    testImplementation (libs.truth)
    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}