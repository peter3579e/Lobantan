// Top-level build file where you can add configuration options common to all sub-projects/modules.
// Lists all plugins used throughout the project without applying them.
buildscript {
    repositories {
        google()
        mavenCentral()

        // Android Build Server
//        maven { url = uri("../nowinandroid-prebuilts/m2repository") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath(libs.google.oss.licenses.plugin) {
            exclude(group = "com.google.protobuf")
        }
    }
}

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.hilt) apply false
}
true // Needed to make the Suppress annotation work for the plugins block