pluginManagement {
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
rootProject.name = "Rest"
include (":app")
include(":CoreAndroid")
include(":CoreCompose")
include(":AuthApi")
include(":SplashScreen")
include(":PreferencesStorage")
include(":AuthScreen")
