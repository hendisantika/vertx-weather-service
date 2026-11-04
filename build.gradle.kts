import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
  java
  application
  id("com.gradleup.shadow") version "9.6.1"
}

group = "id.my.hendisantika"
version = "1.0.0-SNAPSHOT"

repositories {
  mavenCentral()
}

val vertxVersion = "5.2.2"
val junitVersion = "6.1.3"

application {
  mainClass.set("id.my.hendisantika.weather_service.Main")
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(25))
  }
}

dependencies {
  implementation(platform("io.vertx:vertx-stack-depchain:$vertxVersion"))
  implementation("io.vertx:vertx-core")
  implementation("io.vertx:vertx-web")
  implementation("com.squareup.retrofit2:retrofit:3.0.0")
  implementation("com.squareup.retrofit2:converter-gson:3.0.0")
  implementation("com.squareup.okhttp3:okhttp:5.5.1")
  implementation("org.asynchttpclient:async-http-client:3.0.14")

  testImplementation("io.vertx:vertx-junit5")
  testImplementation(platform("org.junit:junit-bom:$junitVersion"))
  testImplementation("org.junit.jupiter:junit-jupiter")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<JavaCompile>().configureEach {
  options.encoding = "UTF-8"
  options.release.set(25)
}

tasks.withType<ShadowJar>().configureEach {
  archiveClassifier.set("fat")
  mergeServiceFiles()
}

tasks.withType<Test>().configureEach {
  useJUnitPlatform()
  testLogging {
    events = setOf(PASSED, SKIPPED, FAILED)
  }
}
