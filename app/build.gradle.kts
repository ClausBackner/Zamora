

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {

    defaultConfig {
        applicationId = "com.example.zamora"
        minSdk = 26
        //noinspection EditedTargetSdkVersion
        targetSdk = 35
        compileSdk = 35
        versionCode = 1
        versionName = "1.0"

    }

    namespace = "com.example.zamora"
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    kotlinOptions {
        jvmTarget = "17"
    }




}





dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)


    implementation(libs.androidx.navigation.compose.v253)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.foundation)

    implementation(libs.androidx.ui)
    implementation(libs.mpandroidchart)
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.gson)


    // Libreria Pcs (utilidades)
    implementation(libs.libreria.pcs)
    implementation (libs.clickablepiechart)

    implementation(libs.androidx.material)
    implementation(libs.androidx.runtime)
    implementation (libs.androidx.appcompat.v161)
    implementation (libs.androidx.core.ktx.v1101)
    implementation (libs.androidx.navigation.fragment.ktx)
    implementation(libs.android.holo.graph)
    implementation(libs.androidx.slice.core)
    implementation(libs.play.services.maps)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}