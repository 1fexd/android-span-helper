plugins {
    id(libs.plugins.com.android.library)
    id(libs.plugins.org.jetbrains.kotlin.android)
    `maven-publish`
    id(libs.plugins.net.nemerosa.versioning)
}

val group = "fe.android.span.helper"

android {
    namespace = group
    compileSdk = Version.COMPILE_SDK

    defaultConfig {
        minSdk = Version.MIN_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    testOptions.unitTests.isIncludeAndroidResources = true

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
    implementation(AndroidX.core.ktx)
}


publishing.publish(
    project,
    "com.github.1fexd.android-span-helper",
    "core",
    versioning.info.tag ?: versioning.info.full,
    PublicationComponent.RELEASE
)
