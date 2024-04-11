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
afterEvaluate {
    publishing {
        publications {
            create("release", MavenPublication::class) {
                // Assuming you are publishing a Java library; adjust if it's an Android library
                from(components["java"])

                groupId = "com.nizk.mohamedayed"
                artifactId = "emv-qrcode"
                version = "1.0.0"
            }
        }
    }
}

