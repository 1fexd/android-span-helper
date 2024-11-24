plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("net.nemerosa.versioning:net.nemerosa.versioning.gradle.plugin:_")
}

//kotlin {
//    compilerOptions {
//        languageVersion.set(KotlinVersion.KOTLIN_1_9)
//        apiVersion.set(KotlinVersion.KOTLIN_1_9)
//    }
//}
