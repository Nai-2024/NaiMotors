plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.dinsalehy.naimotorss"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.dinsalehy.naimotorss"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)

    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("com.google.accompanist:accompanist-pager:0.33.2-alpha")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.33.2-alpha")

    // pagination indicators dependencies
    implementation("com.google.accompanist:accompanist-pager:0.30.1")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.30.1")

    // Jetpack Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.5.3")

    //
    implementation("androidx.compose.material3:material3:1.2.0")
    implementation("androidx.compose.material:material:1.4.3")
    // Date and time picker
    // Core Compose
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.compose.material3:material3:1.2.0") // For Material 3 components
    // or use Material 2:
    // implementation 'androidx.compose.material:material:1.6.0'

    // Compose tooling
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.0")
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.0")

    // Horizontal Pager dependencies
   // implementation("com.google.accompanist:accompanist-pager:0.34.0")
   // implementation("com.google.accompanist:accompanist-pager-indicators:0.34.0")

    implementation("com.google.accompanist:accompanist-pager:0.23.0")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.23.0")

    // AsyncImage
    implementation("io.coil-kt:coil-compose:2.1.0")

    // Arrow drop up
    implementation("androidx.compose.material:material-icons-extended:<version>")

    //rememberImagePainter
    implementation("io.coil-kt:coil-compose:2.4.0")

    //
    implementation("io.coil-kt:coil-compose:2.5.0")

    // Java 8+ API desugaring support (for LocalTime on older Android versions)
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")
    // If you don't have these already
    implementation("androidx.compose.material3:material3:1.2.0")
    implementation("androidx.compose.material:material-icons-extended:1.6.0")
    //Pager
    implementation("androidx.compose.foundation:foundation:1.5.0")
    //Pager indicatitor
    implementation("com.google.accompanist:accompanist-pager:0.32.0") // or latest
    implementation("com.google.accompanist:accompanist-pager-indicators:0.32.0")

    implementation("androidx.compose.foundation:foundation:1.6.0")

    // Firebase dependencies
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation("com.google.firebase:firebase-database-ktx")
    implementation("com.google.firebase:firebase-storage-ktx")


    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}