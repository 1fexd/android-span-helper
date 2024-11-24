package fe.buildsrc.dependency

import de.fayard.refreshVersions.core.DependencyGroup
import de.fayard.refreshVersions.core.DependencyNotation
import de.fayard.refreshVersions.core.DependencyNotationAndGroup
import org.gradle.kotlin.dsl.IsNotADependency

object _1fexd : DependencyGroup(group = "com.github.1fexd") {
    val android = Android

    object Android : IsNotADependency {
        val preference = PreferenceHelper

        object PreferenceHelper : DependencyNotationAndGroup(
            group = "$group.android-pref-helper", name = "android-pref-helper"
        ) {
            val core = module("core")
            val compose = module("compose")
            val composeMock = module("compose-mock")
        }

        val compose = Compose

        object Compose : IsNotADependency {
            val route = DependencyNotation(group = group, name = "compose-route-util")
            val dialog = DependencyNotation(group = group, name = "compose-dialog-helper")
        }

        val span = Span

        object Span : DependencyNotationAndGroup(
            group = "$group.android-span-helper",
            name = "android-span-helper"
        ) {
            val compose = module("compose")
        }
    }

    val uriParser = DependencyNotation(group = group, name = "uriparser")

    val clearUrl = DependencyNotation(group = group, name = "clearurlkt")
    val fastForward = DependencyNotation(group = group, name = "fastforwardkt")
    val libredirectkt = DependencyNotation(group = group, name = "libredirectkt")
    val amp2html = DependencyNotation(group = group, name = "amp2htmlkt")
    val stringBuilder = DependencyNotation(group = group, name = "stringbuilder-util-kt")
    val embedResolve = DependencyNotation(group = group, name = "embed-resolve")
    val signify = DependencyNotation(group = group, name = "signifykt")

}