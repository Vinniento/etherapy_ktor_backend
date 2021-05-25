val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.5.0"
}
tasks.create("stage") {

    dependsOn("installDist")
}
group = "fh_campus"
version = "0.0.1"
application {
    mainClass.set("fh_campus.ApplicationKt")
}

repositories {
    mavenLocal()
    jcenter()
}


dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    implementation("io.ktor:ktor-gson:$ktor_version")

    //DB
    implementation("com.zaxxer:HikariCP:3.2.0")
    implementation("org.jetbrains.exposed:exposed:0.17.6")
    implementation("org.postgresql:postgresql:42.2.2")


}