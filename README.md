[![gatling-test-run](https://github.com/eataborda/load-gatling/actions/workflows/performance-test-run.yml/badge.svg)](https://github.com/eataborda/load-gatling/actions/workflows/performance-test-run.yml)
[![Gradle](https://img.shields.io/badge/Gradle-7.4.2-blue)](https://gradle.org/releases/)
[![Gradle Plugin Portal](https://img.shields.io/badge/io.gatling.gradle-3.9.0-blue)](https://plugins.gradle.org/plugin/io.gatling.gradle/3.9.0)

# Basic Gatling simulation
A basic gatling test with gradle and scala, based on the [gatling-gradle-plugin-demo-scala](https://github.com/gatling/gatling-gradle-plugin-demo-scala) repository

Contains:
- Basic build.gradle config
- Basic sample of a simulation with a friendly structure

## Use sample project locally
- Verify that you have `Git`
- Verify that you have `Java` installed, also that you already setup the following environment variables: `$PATH` and `$JAVA_HOME`
- Clone the repository and move inside that path:
```shellscript
$ git clone git@github.com:eataborda/load-gatling.git
$ cd ./load-gatling
```

## Run simulations
There are two ways to run the simulations depending on the number you want to run, please go to the root of the repository and execute the following command:
- Run all simulations:
```
$ ./gradlew gatlingRun
```
- Run a specific simulation:
```
$ ./gradlew gatlingRun-com.github.eataborda.gatling.basic.BasicSimulation
```
To run a simulation class it is necessary go to the path `src/gatling/scala` and identify:

- The package that contains the simulation class: `com.github.eataborda.gatling.basic`

- The name of the simulation class: `BasicSimulation`