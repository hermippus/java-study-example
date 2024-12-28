# Java example using singleton pattern, single responsibility  principle and multithreaded-safe

### Tech stack:
* Java 21
* Lombok
* Gradle

## Requirements
* Java 21 (Any JDK)

## Build setup
You can use Jenkins (pipeline) to build and use a .jar artifact using the `Jenkinsfile` in this repository. Or you can use Github Actions.

```bash
# clone repository
$ git clone https://github.com/hermippus/java-singleton-spr-example

# build with Gradle
$ ./gradlew build
```

The jar file is located in `build/libs/`
