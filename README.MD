# Java study example
### Tech stack:
* Java 21
* Lombok
* Gradle

## Requirements
* Java 21 (Any JDK)

## Build setup
### Jenkins
To set up continuous integration with Jenkins, use the `Jenkinsfile` located in the root of the project. Jenkins will automatically detect and use this file when you configure your Jenkins job with the "Pipeline from SCM" option. This will trigger the pipeline to build the project and generate the `.jar` file.
### GitHub Actions
To set up continuous integration with GitHub Actions, use the `.github/workflows/gradle.yml` file located in the root of the repository. This file defines the steps required to build the project and generate the `.jar` file.

GitHub Actions will automatically detect and use this workflow when you push code to the repository. It will trigger the defined steps, including setting up the environment, installing dependencies, and running the Gradle build tasks to create the `.jar` file.
### Manual
To manually build the project, follow these steps:
```bash
# clone the repository
$ git clone https://github.com/hermippus/java-singleton-spr-example

# navigate to the project directory
$ cd java-singleton-spr-example

# build with Gradle
$ ./gradlew build
```

The jar file is located in `build/libs/`
