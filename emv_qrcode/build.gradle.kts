plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("maven-publish")

}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
publishing {
    publications {
        create("bar", MavenPublication::class) {
            groupId = "com.nizk"
            artifactId = "emvqrcode"
            version = "1.0.0"
            from(components["java"])
        }
    }



    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/mohamedayed/emv_qrcode")

            credentials {
                val githubUsername = System.getenv("GITHUB_USERNAME")
                val githubToken = System.getenv("GITHUB_TOKEN")

                if (!githubUsername.isNullOrEmpty() && !githubToken.isNullOrEmpty()) {
                    username = githubUsername
                    password = githubToken
                } else {
                    println("Warning: GitHub credentials are not set.")
                }
            }
        }

    }
}


