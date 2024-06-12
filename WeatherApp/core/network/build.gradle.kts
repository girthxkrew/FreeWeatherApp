import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.plugin)
    alias(libs.plugins.ksp.plugin)
}

android {
    namespace = "com.rkm.network"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        val apiProperties = project.rootProject.file("api.properties")
        val properties = Properties()
        properties.load(apiProperties.inputStream())

        buildConfigField("String", "BASE_URL", "\"https://api.weatherapi.com/v1/\"")
        buildConfigField("String", "API_KEY", properties.getProperty("API_KEY") ?: "")
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

    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)
    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp)
    testImplementation(libs.junit)
    testImplementation(libs.mock.web.server)
    testImplementation(libs.kotlin.coroutines.testing)
}