# Hello, World! - AMQP producer app

[![Build Status](https://drone.c2a2.com/api/badges/ujar-org/basics-amqp-producing-hello/status.svg?ref=refs/heads/main)](https://drone.c2a2.com/ujar-org/basics-amqp-producing-hello)
[![Quality Gate Status](https://sonarqube.c2a2.com/api/project_badges/measure?project=ujar-org%3Abasics-amqp-producing-hello&metric=alert_status&token=687ebe26a096bdb14718ce8fb30c55534ddc6d0f)](https://sonarqube.c2a2.com/dashboard?id=ujar-org%3Abasics-amqp-producing-hello)

Minimal Spring Boot based sample of AMQP producer app.

### Pre-Requisites to run this example locally

- Setup git command line tool (https://help.github.com/articles/set-up-git)
- Clone source code to the local machine:

```
git clone https://github.com/ujar-org/basics-amqp-producing-hello.git

cd basics-amqp-producing-hello
```

- Install Docker [https://docs.docker.com/get-docker/](https://docs.docker.com/get-docker/) - at least 1.6.0
- Add new version of docker-compose [https://docs.docker.com/compose/install/](https://docs.docker.com/compose/install/)
- Spin-up single instance of RabbitMQ broker by running command:

```
docker-compose -f docker-compose.dev.yml up -d
```

### Running locally

This application is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built
using [Maven](https://spring.io/guides/gs/maven/). You can build a jar files and run it from the command line:

- Create jar packages:

```
mvn package
```

- Run **amqp-producing-hello** app:

```
java -jar target/*.jar
```

## Code conventions

The code follows [Google Code Conventions](https://google.github.io/styleguide/javaguide.html). Code
quality is measured by:

- [Sonarqube](https://sonarqube.c2a2.com/dashboard?id=ujar-org%3Abasics-amqp-producing-hello)
- [PMD](https://pmd.github.io/)
- [CheckStyle](https://checkstyle.sourceforge.io/)
- [SpotBugs](https://spotbugs.github.io/)

### Tests

This project has standard JUnit tests. To run them execute this command:

```
mvn test -P testcontainers-support
```

It is mandatory to keep test code coverage not below **80** percents and cover all business logic and edge cases.
