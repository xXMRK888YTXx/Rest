plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id(Deps.Dagger.DaggerKaptPlugin)
}

android {
    namespace = "com.xxmrk888ytxx.database"
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
    kapt {
        arguments {
            arg("room.schemaLocation","$projectDir/schemas")
        }
    }
}

dependencies {
    implementation(Deps.Room.RoomKTX)
    implementation(Deps.Room.RoomRuntime)
    kapt(Deps.Room.KaptCompiler)
}