import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.mokkery)
    `maven-publish`
    alias(libs.plugins.vaniktechMavenPublish)
    alias(libs.plugins.dokka)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
        publishLibraryVariants("release","debug")
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "onBoardingLibrary"
            isStatic = true
        }
    }

    tasks.dokkaHtml {
        outputDirectory.set(layout.buildDirectory.dir("documentation/html"))
    }

    sourceSets {

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.koin.android)
        }
        commonMain.dependencies {
            implementation(libs.coil.compose.core)
            implementation(libs.coil.compose)
            implementation(libs.coil.compose.svg)

            api(libs.datastore)
            api(libs.datastore.preferences)

            api(libs.multiplatform.settings.no.arg)

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.lifecycle.viewmodel.compose)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.kotlinx.coroutines.test)
            implementation(libs.turbine)
        }

        iosMain.dependencies {
            
        }
    }
}
android {
    namespace = "com.hopcape.onboarding"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.lifecycle.common.jvm)
    debugImplementation(compose.uiTooling)
}
mavenPublishing {
    coordinates(
        groupId = "io.github.aumaidkh",
        artifactId = "onboarding-mobile",
        version = "1.0.4"
    )

    pom{
        name.set("OnBoarding Library")
        description.set("An OnBoarding Library which can be used in Android and iOS apps")
        inceptionYear.set("2025")
        url.set("https://github.com/Aumaidkh/HopcapeMobileOnBoarding")

        licenses {
            license{
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
            }
        }

        developers {
            developer{
                id.set("Aumaidkh")
                name.set("Murtaza Khursheed")
                email.set("aumaidm.m.c@gmail.com")
            }
        }

        scm {
            url.set("https://github.com/Aumaidkh/HopcapeMobileOnBoarding")
        }

    }

    // Configure publishing to maven central
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    // Enable gpg signing for all publications
    signAllPublications()
}
