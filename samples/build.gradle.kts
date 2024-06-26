plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.kotlinSerialization)
}

android {
    namespace = "com.futuristicmobilieapps.androidcommons"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.futuristicmobilieapps.androidcommons"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
configurations {
    // Exclude the conflicting hamcrest-core dependency
    all {
        exclude(group = "org.hamcrest", module = "hamcrest-core")
    }
}

dependencies {
    implementation(project(":commons"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.test.core.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    testImplementation ("org.mockito:mockito-core:3.12.4")
    androidTestImplementation ("org.mockito:mockito-android:3.12.4")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
    testImplementation ("org.robolectric:robolectric:4.5.1")

    implementation(project(":networking:ktor"))
    api(libs.bundles.ktor)

    implementation ("io.ktor:ktor-client-okhttp:1.6.4")



}