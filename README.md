# What do we want to achieve?

- A better log monitoring infrastructure
    - visualize logs instead of using terminal
    - aggregated logs for example to know how many errors the system is throwing, filter logs by log level
- A better application performance monitoring infrastructure
    - What is the state of our application (UP,DOWN) for example is it receiving requests, is the db health through our
      application
    - What is the CPU and Memory usage
    - How long is the http requests taking to respond

# What frameworks and libraries do we have in this project?

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.0/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.0/gradle-plugin/reference/html/#build-image)
* [Prometheus](https://docs.spring.io/spring-boot/docs/2.6.0/reference/html/production-ready-features.html#production-ready-metrics-export-prometheus)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)

# TODO

- [x] Complete TODO API
- [ ] Setup docker environment for the API
- [ ] Setup logs by providing log4j.xml file
- [ ] Setup ELK(Elasticsearch, Logstash and Kibana) stack for the logs
- [ ] Setup Prometheus and Spring Actuator for APM
- [ ] Connect Prometheus to Kibana for APM
- [ ] Introduce Spring Security