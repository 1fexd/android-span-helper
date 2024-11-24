import fe.buildsrc.Version
import fe.buildsrc.publishing.PublicationComponent
import fe.buildsrc.publishing.publish
import fe.buildsrc.publishing.asProvider


plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("net.nemerosa.versioning")
    `maven-publish`
}

group = "fe.android.span.helper.compose"

android {
    namespace = group.toString()
    compileSdk = Version.COMPILE_SDK

    defaultConfig {
        minSdk = Version.MIN_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    testOptions.unitTests.isIncludeAndroidResources = true

    buildFeatures {
        compose = true
    }

    kotlin {
        jvmToolchain(Version.JVM)
        explicitApi()
    }

    publishing {
        multipleVariants {
            allVariants()
            withSourcesJar()
        }
    }
}

dependencies {
    api(project(":core"))
    api(AndroidX.compose.ui)
    api(AndroidX.compose.ui.text)
}

publishing.publish(
    project,
    group.toString(),
    versioning.asProvider(project),
    PublicationComponent.RELEASE
)
