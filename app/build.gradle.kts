import org.gradle.kotlin.dsl.implementation as implementation1

plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.tesji.quizzdragonball"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.tesji.quizzdragonball"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation1(libs.appcompat)
    implementation1(libs.material)
    implementation1(libs.activity)
    implementation1(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation1(libs.retrofit2.retrofit)
    implementation1(libs.converter.gson)
    implementation1(libs.picasso)
    implementation1(libs.gson)

}