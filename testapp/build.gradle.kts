import fe.buildsrc.Version
import fe.buildsrc.dependency.PinnedVersions
import fe.buildsrc.dependency._1fexd
import fe.buildsrc.publishing.PublicationComponent
import fe.buildsrc.publishing.publish
import fe.buildsrc.publishing.asProvider

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("net.nemerosa.versioning")
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
