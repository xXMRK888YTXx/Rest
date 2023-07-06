plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id (Deps.Dagger.DaggerKaptPlugin)
}

android {
    namespace = Config.packageName
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.packageName
        minSdk = Config.minSdk
        targetSdk = Config.compileSdk
        versionCode = 1
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = Config.isR8ProGuardEnableForRelease
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),"proguard-rules.pro")

        }

        debug {
            isMinifyEnabled = Config.isR8ProGuardEnableForDebug
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),"proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = Config.sourceCompatibility
        targetCompatibility = Config.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Deps.Compose.ComposeKotlinCompiler
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }

        resources.excludes.add("META-INF/*")
    }
}

dependencies {
    implementation(project(Project.CoreCompose))
    implementation(project(Project.SplashScreen))
    implementation(project(Project.PreferencesStorage))
    implementation(project(Project.AuthScreen))
    implementation(project(Project.AuthApi))
    implementation(project(Project.PlaceApi))
    implementation(project(Project.Database))
    implementation(project(Project.BottomBarScreen))
    implementation(project(Project.PlaceListScreen))
    implementation(project(Project.ViewPlaceScreen))
    implementation(project(Project.HistoryScreen))



    //Dagger
    kapt(Deps.Dagger.DaggerKaptCompiler)

    //Compose
    implementation(Deps.Compose.Navigation)
    implementation(Deps.Compose.SystemUiController)

    //Room
    implementation(Deps.Room.RoomRuntime)
    implementation(Deps.Room.RoomKTX)
    kapt(Deps.Room.KaptCompiler)
}