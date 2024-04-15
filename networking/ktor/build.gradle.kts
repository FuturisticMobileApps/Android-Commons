plugins {
    alias(libs.plugins.jetbrainsKotlinJvm)
    alias(libs.plugins.kotlinSerialization)

}
dependencies {
    api(libs.bundles.ktor)
    implementation("org.testng:testng:6.9.6")
}

