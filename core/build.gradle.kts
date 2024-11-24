import fe.buildsrc.Version
import fe.buildsrc.dependency.PinnedVersions
import fe.buildsrc.dependency._1fexd
import fe.buildsrc.publishing.PublicationComponent
import fe.buildsrc.publishing.publish
import fe.buildsrc.publishing.asProvider

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("net.nemerosa.versioning")
    `maven-publish`
}

group = "fe.android.span.helper"

android {
    namespace = group.toString()
    compileSdk = Version.COMPILE_SDK

    defaultConfig {
        minSdk = Version.MIN_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
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
    api(AndroidX.core.ktx)

    testImplementation(Testing.robolectric)
    testImplementation(Testing.junit.jupiter)
    testImplementation(AndroidX.test.core)
    testImplementation(AndroidX.test.coreKtx)
    testImplementation(AndroidX.test.ext.truth)
    testImplementation(AndroidX.test.ext.junit)
    testImplementation(AndroidX.test.ext.junit.ktx)
    testImplementation(AndroidX.test.runner)
    androidTestUtil(AndroidX.test.orchestrator)

    testImplementation(kotlin("test"))
}

publishing.publish(
    project,
    group.toString(),
    versioning.asProvider(project),
    PublicationComponent.RELEASE
)
