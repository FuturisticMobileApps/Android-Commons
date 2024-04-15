plugins {
    alias(libs.plugins.jetbrainsKotlinJvm)

}
dependencies{
    api(libs.bundles.retrofit)
    implementation("org.testng:testng:6.9.6")
}
