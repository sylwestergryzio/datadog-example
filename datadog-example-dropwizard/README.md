# Dropwizard Metrics

This project is an example of Dropwizard metrics with a reporter set up to send them to Datadog.

## Prerequisites

* Create free account in [Datadog](https://www.datadoghq.com/) if you would like to test your results visually using this project template
* Update `server.yml` file and replace `--change-to-your-api-key--` with your own API key
* Install Scala if you would like to run gatling simulation from this project

## Running Dropwizard application

If you are running on Linux/MacOSX
```
  ./gradlew run
```
otherwise
```
  gradlew.bat run
```
The application port is 8080 and the admin port is 8081.

## Running Gatling simulation

```
  ./gradlew gatlingRun-com.techarchnotes.UserLoginSimulation
```
or
```
  gradlew.bat gatlingRun-com.techarchnotes.UserLoginSimulation
```

## Built With

* [Dropwizard](https://www.dropwizard.io/1.3.5/docs/) - The web framework used
* [Gradle](https://gradle.org/) - Dependency Management
* [Gatling](https://gatling.io/) - Used to simulate http traffic
* [Metrics Datadog](https://github.com/coursera/metrics-datadog) Reporting bridge between Dropwizard Metrics and Datadog service
* [Gradle Gatling plugin](https://github.com/lkishalmi/gradle-gatling-plugin)
* [Gradle Application plugin](https://docs.gradle.org/current/userguide/application_plugin.html)

## Authors

* **Sylwester Gryzio** - [Tech Arch Notes](https://techarchnotes.com/)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.