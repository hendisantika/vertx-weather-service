# vertx-weather-service

[![Java CI with Gradle](https://github.com/hendisantika/vertx-weather-service/actions/workflows/gradle.yml/badge.svg)](https://github.com/hendisantika/vertx-weather-service/actions/workflows/gradle.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Vert.x](https://img.shields.io/badge/Vert.x-5.2.2-purple)
![Gradle](https://img.shields.io/badge/Gradle-9.8.2-02303A?logo=gradle)

A small reactive weather service built with [Eclipse Vert.x](https://vertx.io). It proxies the
[Forecast9 RapidAPI](https://rapidapi.com/wettercom-wettercom-default/api/forecast9) and exposes the
summary and hourly forecast for Berlin.

## Tech Stack

| Component        | Version |
|------------------|---------|
| JDK              | 25      |
| Gradle (wrapper) | 9.8.2   |
| Vert.x (core/web)| 5.2.2   |
| AsyncHttpClient  | 3.0.14  |
| Shadow plugin    | 9.6.1 (`com.gradleup.shadow`) |
| JUnit            | 6.1.3   |

## Prerequisites

- JDK 25 (Gradle toolchain is set to Java 25)
- A RapidAPI key for the Forecast9 API

## Endpoints

The server listens on port `8080`. All incoming request headers are forwarded to RapidAPI, so pass your
RapidAPI headers with each call.

| Method | Path    | Description                         |
|--------|---------|-------------------------------------|
| GET    | `/`     | Weather summary forecast for Berlin |
| GET    | `/hour` | Hourly weather forecast for Berlin  |

If the upstream call fails, the service responds with HTTP `500`.

```shell
curl http://localhost:8080/ \
  -H "x-rapidapi-key: <YOUR_RAPIDAPI_KEY>" \
  -H "x-rapidapi-host: forecast9.p.rapidapi.com"

curl http://localhost:8080/hour \
  -H "x-rapidapi-key: <YOUR_RAPIDAPI_KEY>" \
  -H "x-rapidapi-host: forecast9.p.rapidapi.com"
```

## Build & Run

```shell
# Run tests
./gradlew clean test

# Build (compile, test, and package)
./gradlew clean build

# Run the application
./gradlew run

# Build and run the fat jar
./gradlew shadowJar
java -jar build/libs/weather-service-1.0.0-SNAPSHOT-fat.jar
```

## CI/CD & Dependency Management

- **GitHub Actions** (`.github/workflows/gradle.yml`) builds and tests the project on JDK 25 (Temurin) for every
  push and pull request to `main`, and submits the dependency graph for Dependabot alerts.
- **Dependabot** (`.github/dependabot.yml`) checks Gradle dependencies and GitHub Actions daily at 05:00
  (Asia/Jakarta). Related updates are grouped (Vert.x, JUnit, Square libs, Gradle plugins, minor/patch, and
  GitHub Actions) to reduce pull request noise.

## Project Structure

```
src/main/java/id/my/hendisantika/weather_service
├── Main.java        # Entry point and HTTP verticle (routes / and /hour)
└── WeatherDTO.java  # Forecast response model
src/test/java/id/my/hendisantika/weather_service
└── TestMainVerticle.java
```

## Author

**Hendi Santika**

- Email: hendisantika@gmail.com
- Telegram: [@hendisantika34](https://t.me/hendisantika34)
- Link: [s.id/hendisantika](https://s.id/hendisantika)
