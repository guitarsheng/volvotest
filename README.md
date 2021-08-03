**Project**

1. describe
demo project for volvo test

2. technology used

DDD/TDD, JPA, java 8, swagger, spring boot, lombok, hsqldb


**Build**

1. maven buid command
~~~
mvn package
~~~
**Start**

1. maven spring boot command 
~~~
mvn spring-boot:run
~~~
**Test**

1. maven test command
~~~
mvn test
~~~
2. swagger url:
   
<http://localhost:8080/swagger-ui/index.html>
~~~
sample request:
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
expected result is 60, as it exceeded maximum fee allowed

**Health**

1. spring boot actuator url

<http://localhost:8080/actuator/health>

~~~
{"status":"UP"}
~~~