# MyBatis SpringBoot Demo Setup
Describes how we built up the skeleton of this simple mybatis demo app  

If you have the Spring CLI installed 
```
https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-installing-spring-boot.html#getting-started-installing-the-cli
```
then the following will scaffold a simple skeleton application.
```
spring init -dweb,actuator,hateoas,h2,jdbc    mybatis-spring-boot
```

# MyBatis Spring Boot Starter
Mybatis provides a spring boot starter to simplify mybatis setup and configuration.
For more info see
http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/

```
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.3.0</version>
</dependency>
```

# Setup H2 in-memory datasource

Also in the same application.properties file 
define a embedded in memory H2 datasource

```
# in memory embedded database. resets after app closes
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
```
##  Enable H2 Web Console
Enable the H2 database web console in src/main/resources/application.properties

```
# enable H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2
```

To Verify H2 setup Start the App
```
mvn spring-boot:run 
```

Open up the H2 admin console
```
http://localhost:8080/h2
```
login using 
JDBC url =jdbc:h2:mem:testdb
username=sa  
password should be empty

There should just be a INFORMATION_SCHEMA direatory and a Users section
You can close the 

## Api guide
This page lists the major RESTful APIs. The default url is `http://localhost:8080`.

### HTTP Response Design
We follow general rules to design the REST APIs. In the HTTP response that is sent to a client, 
the status code, which is a three-digit number, is accompanied by a reason phrase (also known as status text) that simply describes the meaning of the code. 
The status codes are classified by number range, with each class of codes having the same basic meaning.
* The range 100-199 is classed as Informational.
* 200-299 is Successful.
* 300-399 is Redirection.
* 400-499 is Client error.
* 500-599 is Server error.

### Valid Response
The valid HTTP response is designed as follows:

| Action | HTTP Status | Response Body |
| ---- | ------------------ | ------ |
| POST | 201, "Created" | created item |
| GET | 200, "OK" | requested items | 

### Get news
`GET /api/v1/news`

#### Response example
```
[
    {
        "id": 1,
        "title": "逆势突围、攻坚克难，中国经济凭啥不掉链",
        "author": "新华社",
        "publishDate": "2020-12-16",
        "description": "2020年即将过去。这一年，新冠肺炎疫情全球蔓延，外部不稳定不确定因素较多，经济下行压力持续加大，极不寻常。风险挑战下，中国发展如何攻坚克难、行稳致远，令世人瞩目。",
        "content": "加强基础工艺、关键材料、核心技术创新，加快推进新基建，提速5G与工业互联网的融合……夯实工业和数字基础，力度更甚。我们将围绕筑牢产业基础和提升产业链现代化水平出台更多具体措施，促进更多创新要素聚集，服务高质量发展。工信部新闻发言人黄利斌说。",
        "image": "https://p6-tt.byteimg.com/origin/pgc-image/1e147a49e78b4bd0bec66291398778a6"
    }
]
```


### Get news by title
`GET /api/v1/news/{title}`

#### Response example
```
[
    {
        "id": 1,
        "title": "逆势突围、攻坚克难，中国经济凭啥不掉链",
        "author": "新华社",
        "publishDate": "2020-12-16",
        "description": "2020年即将过去。这一年，新冠肺炎疫情全球蔓延，外部不稳定不确定因素较多，经济下行压力持续加大，极不寻常。风险挑战下，中国发展如何攻坚克难、行稳致远，令世人瞩目。",
        "content": "加强基础工艺、关键材料、核心技术创新，加快推进新基建，提速5G与工业互联网的融合……夯实工业和数字基础，力度更甚。我们将围绕筑牢产业基础和提升产业链现代化水平出台更多具体措施，促进更多创新要素聚集，服务高质量发展。工信部新闻发言人黄利斌说。",
        "image": "https://p6-tt.byteimg.com/origin/pgc-image/1e147a49e78b4bd0bec66291398778a6"
    }
]
```

### Add news
`POST /api/v1/news`

#### Request Header
| key          | value            |
| ------------ | ---------------- |
| Content-Type | application/json |


#### Request example
```
curl -X POST \
  http://localhost:8080/news \
  -H 'content-type: application/json' \
  -d '{
    "title":"习近平主席",
    "author":"新华社",
    "description":"重要讲话",
    "content":"加强垄断寡头管理",
    "image":"www.baidu.com/image"
}'
```

#### Response example
```
{
    "id": 1,
    "title": "习近平主席",
    "author": "新华社",
    "publishDate": "2020/12/16",
    "description": "重要讲话",
    "content": "加强垄断寡头管理",
    "image": "www.baidu.com/image"
}
```