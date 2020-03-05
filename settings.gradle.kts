rootProject.name = "COMP3021_Lab"

object Meta {
    val excludedPackagesDirectory = listOf(
            "build"
    )

    val projectPrefix = "stevefan1999"
}

fun addDirectoryEntriesAsProjects(path: String, excludedPackagesDirectory: List<String> = listOf()) {
    file(path).list()?.filterNot { it in excludedPackagesDirectory }?.forEach {
        include(":$it")

        val proj = project(":$it")
        proj.projectDir = file("packages/$it")
    }
}

addDirectoryEntriesAsProjects("packages")