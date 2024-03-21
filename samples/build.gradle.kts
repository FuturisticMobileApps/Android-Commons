plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.futuristicmobilieapps.androidcommons"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.futuristicmobilieapps.androidcommons"
        minSdk = 21
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

dependencies {
    implementation(project(":commons"))
    implementation(libs.androidx.test.core.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    testImplementation ("org.mockito:mockito-core:3.12.4")
//    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
    androidTestImplementation ("org.mockito:mockito-android:3.12.4")



}