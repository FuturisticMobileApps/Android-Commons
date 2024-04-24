plugins {
    alias(libs.plugins.jetbrainsKotlinJvm)
    alias(libs.plugins.kotlinSerialization)

}
dependencies {
    api(libs.bundles.ktor)
    implementation("org.testng:testng:6.9.6")

    implementation ("io.ktor:ktor-client-okhttp:1.6.4")

    implementation ("com.google.guava:guava:27.0.1-jre")

}

