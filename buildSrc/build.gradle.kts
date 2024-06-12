plugins {
    java
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    implementation("org.eclipse.jgit", "org.eclipse.jgit", "6.10.0.202406032230-r")
}