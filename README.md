# SSM架构



## 搭建整合环境

### 搭建整合环境

- SSM可以使用多种方式整合（这里使用的是 xml + 注解方式整合）
- 整合思路
  - 搭建整合环境
  - 完成 spring 配置的搭建
  - 使用 spring 整合 springMVC 框架
  - 使用 spring 整合 mybatis 框架

### 创建 maven 工程

- 创建 ssm_parent 父工程【打包方式选择 pom，必要的操作】
- 创建 ssm_web 子模块【打包方式 war 包】
- 创建 ssm_service 子模块【打包方式为 jar 包】
- 创建 ssm_dao 子模块【打包方式为 jar 包】
- 创建 ssm_pojo 子模块【打包方式为 jar 包】



## Spring Boot

### 创建springboot项目步骤

#### 导入父工程依赖

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.4.1</version>
</parent>
```

#### 导入项目依赖

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```



#### 编写主程序应用

```java
package com.learn.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//主程序类
@SpringBootApplication      //告知springboot，这是一个springboot应用
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);    //运行主程序应用(固定写法)
    }
}
```

在此，我们只需要运行main方法就可以启动 tomcat



### springboot的打包

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

在pom.xml中导入以上依赖，springboot会自动帮我们把项目打包为jar包



### 快速生成springboot项目

使用官网提供的工具生成压缩包：  https://start.spring.io/



## springboot常用注解

#### @RestController

> 功能

集合了 `@Controller` 与 `@ResponseBody`  的功能

`@Controller` 声明web类
`@ResponseBody` 注明这个类中的所有方法都是返回给浏览器的字符串，而不是返回到jsp

> 实例

```java
import ...;

@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello() {
        return "Hello, SpringBoot2!";
    }
}
```



## springboot_01_hello项目目录

- src/main
  - java/com/learn
    - boot	【存放项目启动类】
      - controller  【存放项目控制器】
  - resource  【存放配置文件】
    - `application.properties`  【springboot的配置文件，在springboot中，已经简化了配置，因此只需要配置该文件即可】