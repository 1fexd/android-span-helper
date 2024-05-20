import de.fayard.refreshVersions.core.versionFor

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "fe.android.span.helper"
    compileSdk = Version.COMPILE_SDK

    defaultConfig {
        applicationId = "fe.span.helper"
        minSdk = Version.MIN_SDK
        targetSdk = Version.COMPILE_SDK
        compileSdk = Version.COMPILE_SDK
        versionCode = (System.currentTimeMillis() / 1000).toInt()
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    kotlin {
        jvmToolchain(Version.JVM)
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = versionFor(AndroidX.compose.compiler)
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":compose"))
    implementation(AndroidX.compose.material3)

    implementation(AndroidX.core.ktx)
    implementation(AndroidX.activity.compose)
}
