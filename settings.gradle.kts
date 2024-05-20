rootProject.name = "android-span-helper"

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    plugins {
        id("de.fayard.refreshVersions") version "0.60.3"
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("de.fayard.refreshVersions") version "0.60.5"
}


include("core", "compose", "compose-material3")

if (System.getenv("JITPACK")?.toBooleanStrictOrNull() != false) {
    include("testapp")
}
