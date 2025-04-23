// Root build.gradle.kts for "client-app-composite"

tasks.register("clean") {
    description = "Cleans build directories across all projects"
    group = "build"

    doLast {
        // Delete the root project build directory
        delete(rootProject.buildDir)

        // Run clean task in each included build
        gradle.includedBuilds.forEach { includedBuild ->
            println("Cleaning included build: ${includedBuild.name}")
            exec {
                commandLine("${rootDir}/gradlew", "-p", includedBuild.projectDir.absolutePath, "clean")
            }
        }
    }
}
