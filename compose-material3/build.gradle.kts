import de.fayard.refreshVersions.core.versionFor

plugins {
    id(libs.plugins.com.android.library)
    id(libs.plugins.org.jetbrains.kotlin.android)
    `maven-publish`
    id(libs.plugins.net.nemerosa.versioning)
}

val group = "fe.android.span.helper.compose.material3"

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
    implementation(project(":compose"))

    implementation(AndroidX.compose.ui)
    implementation("androidx.compose.material3:material3:1.3.0-alpha05")
}


publishing.publish(
    project,
    "com.github.1fexd.android-span-helper",
    "compose-material3",
    versioning.info.tag ?: versioning.info.full,
    PublicationComponent.RELEASE
)
