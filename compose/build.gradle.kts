import de.fayard.refreshVersions.core.versionFor

plugins {
    id(libs.plugins.com.android.library)
    id(libs.plugins.org.jetbrains.kotlin.android)
    `maven-publish`
    id(libs.plugins.net.nemerosa.versioning)
}

val group = "fe.android.span.helper.compose"

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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = versionFor(AndroidX.compose.compiler)
    }

    publishing {
        multipleVariants {
            allVariants()
            withSourcesJar()
        }
    }
}

dependencies {
    implementation(project(":core"))
    implementation("androidx.compose.ui:ui:1.7.0-alpha07")

    implementation(AndroidX.core.ktx)
}


publishing.publish(
    project,
    "com.github.1fexd.android-span-helper",
    "compose",
    versioning.info.tag ?: versioning.info.full,
    PublicationComponent.RELEASE
)
