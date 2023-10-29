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

rootProject.name = "Juara Android"
include(":app")
include(":app:racetracker")
include(":app:affirmation")
include(":app:courses")
include(":app:unscramble")
include(":app:woofapp")
include(":app:cupcake")
include(":app:marsphotos")
include(":app:inventory")
