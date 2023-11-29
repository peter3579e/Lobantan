pluginManagement {
    includeBuild("build-logics")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Lobantan"
include(":app")
include(":home")
include(":message")
include(":profile")
include(":designsystem")
include(":search")
include(":data")
include(":common")
include(":app:convention")
include(":buildlogic")
