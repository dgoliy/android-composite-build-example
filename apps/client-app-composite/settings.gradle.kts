pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "My Composite Application"
includeBuild("../client-app")
// includeBuild("../../libraries/simple-lib") {
//     dependencySubstitution {
//         substitute(module("com.dgoliy.android:module1")).using(project(":module1"))
//         substitute(module("com.dgoliy.android:module2")).using(project(":module2"))
//     }
// }
includeBuild("../../libraries/simple-lib")
