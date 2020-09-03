plugins {
    java
    kotlin("jvm") version "1.3.72"
    application
    jacoco
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
//    following 2 maven calls were modified for kotlin dsl: changed url + string to setUrl(string)
    maven { setUrl ("https://dl.bintray.com/arrow-kt/arrow-kt/")}
    maven { setUrl ("https://oss.jfrog.org/artifactory/oss-snapshot-local/") }
}
val test by tasks.getting(Test::class) {
    useJUnitPlatform {}

    testLogging.showStandardStreams = true
}
dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.junit.jupiter:junit-jupiter:5.4.2")
    implementation("org.junit.jupiter:junit-jupiter:5.4.2")
    testCompile("junit", "junit", "4.12")

    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.1")
    testImplementation("io.mockk:mockk:1.9")
    testImplementation("org.mockito:mockito-core:1.9.5")
    implementation(kotlin("reflect:1.3.61"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3")
    implementation("com.beust:klaxon:5.0.2")
    // Arrow
    implementation("io.arrow-kt:arrow-core:0.10.4")
    implementation("io.arrow-kt:arrow-syntax:0.10.4")
    implementation("io.arrow-kt:arrow-fx:0.10.4")



}
tasks {
    getByName<JacocoReport>("jacocoTestReport") {
        afterEvaluate {
            getClassDirectories().setFrom(files(classDirectories.files.map {
                fileTree(it) { exclude("**/ui/**") }
            }))
        }
    }
}

jacoco {
    toolVersion = "0.8.3"
}

application {
    mainClassName = "airportAppKt"
}

defaultTasks("clean", "test", "jacocoTestReport")
