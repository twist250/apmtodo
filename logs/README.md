# Overview

Spring boot provides a way to log with its own log layout like so

```text
2021-11-22 13:55:39.223  INFO 268643 --- [           main] com.apm.todo.ApmtodoApplicationKt        : Started ApmtodoApplicationKt in 2.843 seconds (JVM running for 3.462)
```

Most of the tools needs to process these logs to know for example **_time of the log_**, **_log level(TRACE, DEBUG,
INFO, WARN, ERROR)_**, **_error stack traces_**, etc;

The issue with the default spring log layout it's that it is **_not simple to process_** those log file lines, sometimes
it may require another tool to process them;

One of the solution that can help is to format those logs into **_JSON format_** like so

```json
{
  "timestamp": "2021-11-24T11:41:22+0200",
  "level": "INFO",
  "thread": "main",
  "logger": "com.apm.todo.ApmtodoApplicationKt",
  "message": "Started ApmtodoApplicationKt in 2.838 seconds (JVM running for 3.445)",
  "context": "default"
}
```

With logs formatted in JSON format you can retrieve the properties easier

## Logging framework

In Spring boot project the default logging framework is [Logback](http://logback.qos.ch/) which is the successor to the
popular log4j project.

## Logback XML file

So let's configure Logback to format logs in JSON

1. Add the required dependencies
    1. [logback-jackson](https://mvnrepository.com/artifact/ch.qos.logback.contrib/logback-jackson/0.1.5)
   ```xml
   <dependency>
       <groupId>ch.qos.logback.contrib</groupId>
       <artifactId>logback-jackson</artifactId>
       <version>0.1.5</version>
   </dependency>
   ```
    2. [logback-json-classic](https://mvnrepository.com/artifact/ch.qos.logback.contrib/logback-json-classic/0.1.5)
   ```xml
   <dependency>
       <groupId>ch.qos.logback.contrib</groupId>
       <artifactId>logback-json-classic</artifactId>
       <version>0.1.5</version>
   </dependency>
   ```
    3. [logback-classic](https://mvnrepository.com/artifact/ch.qos.logback/logback-classic/1.2.7) You need to add this
       dependency when it's not included in spring boot dependencies
   ```xml
   <dependency>
       <groupId>ch.qos.logback</groupId>
       <artifactId>logback-classic</artifactId>
       <version>1.2.7</version>
   </dependency>
   ```
2. Create `logback.xml` file under `resources` folder with these configs

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>app.log</file>
        <layout class="ch.qos.logback.contrib.json.classic.JsonLayout">
            <jsonFormatter class="ch.qos.logback.contrib.jackson.JacksonJsonFormatter"/>
            <timestampFormat>yyyy-MM-dd'T'HH:mm:ssZ</timestampFormat>
            <appendLineSeparator>true</appendLineSeparator>
        </layout>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>%d{yyyy-MM-dd}.%i.log</fileNamePattern>
            <timeBasedFileNamingAndTriggeringPolicy
                    class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                <maxFileSize>100MB</maxFileSize>
            </timeBasedFileNamingAndTriggeringPolicy>
        </rollingPolicy>
    </appender>
    <root level="INFO">
        <appender-ref ref="FILE"/>
    </root>
</configuration>
```

The important part that converts logs format to JSON layout is this

```xml

<layout class="ch.qos.logback.contrib.json.classic.JsonLayout">
    <jsonFormatter class="ch.qos.logback.contrib.jackson.JacksonJsonFormatter"/>
    <timestampFormat>yyyy-MM-dd'T'HH:mm:ssZ</timestampFormat>
    <appendLineSeparator>true</appendLineSeparator>
</layout>
```