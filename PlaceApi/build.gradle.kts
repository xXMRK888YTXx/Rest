plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id(Deps.KolinSerialization.plugin)
}

android {
    namespace = "com.xxmrk888ytxx.placeapi"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = Config.sourceCompatibility
        targetCompatibility = Config.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
}

dependencies {
    implementation(project(Project.CoreAndroid))
    implementation(Deps.KolinSerialization.serialization)

    implementation(Deps.Ktor.KtorAndroid)
    implementation(Deps.Ktor.KtorSerialization)
    implementation(Deps.Ktor.loggier)
}