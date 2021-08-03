# Introduction 

It's a project for demonstrating how to apply DDD/TDD in project and It's also an answer to the experiments given by Volvo.

# Content

The folder `src` is a maven project which follow the maven convention.

The details of experiments can be found in `ASSIGNMENT.md` file.

The file `questions.md` is also part of answer to experiments.

The file `requirement analysis.docx` is a requirement analysis document against `ASSIGNMENT.md` .

# Getting Started

Use maven tool to build and run project.

1.	Build & Installation

~~~
mvn package; mvn spring-boot:run;
~~~

2.	Software dependencies

    java 8, swagger, spring boot, lombok, hsqldb

3.  Technology

    DDD/TDD, JPA

# Build and Test

1. Unit Test

~~~
mvn test
~~~

2. API Test

    Swagger URL: <http://localhost:8080/swagger-ui/index.html>
    
    Expected result is 60, as it exceeded maximum fee allowed.
    
    Sample Request:
~~~
{
    "city":"Gothenburg",
    "timeline":[
        "2013-01-14 21:00:00",
        "2013-01-15 21:00:00",
        "2013-02-07 06:23:27",
        "2013-02-07 15:27:00",
        "2013-02-08 06:27:00",
        "2013-02-08 06:20:27",
        "2013-02-08 14:35:00",
        "2013-02-08 15:29:00",
        "2013-02-08 15:47:00",
        "2013-02-08 16:01:00",
        "2013-02-08 16:48:00",
        "2013-02-08 17:49:00",
        "2013-02-08 18:29:00",
        "2013-02-08 18:35:00",
        "2013-03-26 14:25:00",
        "2013-03-28 14:07:27"
    ],
    "vehicle":"Car"
}
~~~

3. Health Check Endpoint

    Actuator URL: <http://localhost:8080/actuator/health>
    
    Expected result is:

~~~
{"status":"UP"}
~~~

