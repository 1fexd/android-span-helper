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
    "com.github.1fexd.android-span-helper",
    "core",
    versioning.info.tag ?: versioning.info.full,
    PublicationComponent.RELEASE
)
