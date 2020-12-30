# SSM架构/SpringBoot



## 搭建整合环境

Spring MVC 负责MVC设计模式， MyBatis 负责持久层，Spring 负责SpringMVC和mybatis的创建和依赖注入

### 导入maven依赖

```xml
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.11</version>
        <scope>compile</scope>
    </dependency>
    <!--SpringMVC-->
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.2.12.RELEASE</version>
    </dependency>
    <!--Spring JDBC-->
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>5.2.12.RELEASE</version>
    </dependency>
    <!--Spring AOP-->
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-aop -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-aop</artifactId>
        <version>5.2.12.RELEASE</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-aspects -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-aspects</artifactId>
        <version>5.2.12.RELEASE</version>
    </dependency>
</dependencies>
```



### pom.xml中读取类路径下的xml

```xml
<!--配置读取mysql语句的xml文件-->
<resources>
    <resource>
        <directory>src/main/java</directory>
        <includes>
            <include>**/*.xml</include>
        </includes>
    </resource>
    <resource>
        <directory>src/main/resources</directory>
        <includes>
            <include>*.xml</include>
            <include>*.properties</include>
        </includes>
    </resource>
</resources>
```



### web.xml

web.xml中需要配置spring MVC、Spring、字符编码过滤器、加载静态资源

```xml
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
  <display-name>Archetype Created Web Application</display-name>
  <!--启动spring-->
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:spring.xml</param-value>
  </context-param>
  <!--spring监听器-->
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>

  <!--SpringMVC-->
  <servlet>
    <servlet-name>dispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:springmvc.xml</param-value>
    </init-param>
  </servlet>

  <!--拦截所有请求-->
  <servlet-mapping>
    <servlet-name>dispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>

  <!--字符编码过滤器-->
  <filter>
    <filter-name>characterEncodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>characterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>

  <!--加载静态资源-->
  <servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.js</url-pattern>
  </servlet-mapping>
  <servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.css</url-pattern>
  </servlet-mapping>
  <servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.jpg</url-pattern>
  </servlet-mapping>
</web-app>
```

### 在spring.xml中配置mybatis和spring整合

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd">
    <!--整合mybatis-->
    <bean id="dataSources" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="com.mysql.cj.jdbc.Driver"/>
        <property name="jdbcUrl" value="jdbc:mysql://localhost/ssm?useSSL=false&amp;serverTimezone=UTC"/>
        <property name="user" value="root"/>
        <property name="password" value="root"/>
        <!--初始化连接对象-->
        <property name="initialPoolSize" value="5"/>
        <!--最大连接对象-->
        <property name="maxPoolSize" value="10"/>
    </bean>

    <!--配置mybatis SqlSessionFactory-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSources"/>
        <!--指定mapper位置-->
        <property name="mapperLocations" value="classpath:com/learn/repository/*.xml"/>
        <!--mybatis全局配置文件-->
        <property name="configLocation" value="classpath:mybatis-config.xml"/>
    </bean>

    <!--扫描自定义的mapper接口-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.learn.repository"/>
    </bean>

</beans>
```



### mybatis-config.xml中的配置

配置一些辅助信息

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <settings>
        <!--打印SQL-->
        <setting name="logImpl" value="STDOUT_LOGGING"/>
    </settings>
    <!--指定一个包，mybatis会在包下面搜索需要的javabean-->
    <typeAliases>
        <package name="com.learn.entity"/>
    </typeAliases>
</configuration>
```



### 配置springmvc.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/mvc
       http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!--启动注解驱动-->
    <mvc:annotation-driven/>

    <!--扫描业务代码-->
    <context:component-scan base-package="com.learn"/>

    <!--配置视图解析器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/"/>
        <property name="suffix" value=".jsp"/>
    </bean>

</beans>
```





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



### springboot自动配置

#### pom.xml

- `spring-boot-starter-parent`  【核心依赖在父工程中】
- 我们在写或者引入springboot依赖的时候不需要指定版本，因为springboot本身内置版本仓库



#### 启动器

```xml
<dependencies>
    <!--启动器-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
</dependencies>
```

- 启动器就是springboot的启动场景
- springboot会将所有的功能场景变成启动器
- 如果需要使用对应版本，只需要启动对应的 `starter` 即可



#### 主程序

```java
@SpringBootApplication	//标注这是一个springboot应用
public class Springboot01HelloApplication {

	public static void main(String[] args) {
        //将springboot应用启动
		SpringApplication.run(Springboot01HelloApplication.class, args);
	}

}
```

##### @SpringBootApplication

>  它包含了以下注解

- `@SpringBootConfiguration` 【springboot的配置】
  - `@Configuration`  【spring的配置类】
  - `@Component`  【说明这是spring的一个组件】
- `@EnableAutoConfiguration`  【自动导入配置】
  - `AutoConfigurationPackage`	【自动配置包】
    - `@Import(AutoConfigurationPackage.Registrar.class)`   【导入选择器包注册】
  - `@Import(AutoConfiguartionImportSelector.class)`  【自动导入选择】



#### springboot自动加载

> springboot所有自动配置都是在启动的时候扫描并加载

spring-boot-test-autoconfigure-x.x.x.jar/META-INF/`spring.factories`

- 要判断条件是否生效，就看是否装配了对应的启动器，如果装配（手动配置），那么才会启动成功
- 所有自动配置类都在 *spring-boot-test-autoconfigure-x.x.x.jar* 这个包下
- 它会把所有需要导入的组件以类名方式返回，这些组件就会被添加到容器中



### SpringBoot理解

- 自动装配
- `run()` 方法
  - 判断应用的类型是普通项目还是web项目
  - 查找并加载所有可用初始化器，设置到 *initializers* 属性中
  - 找出所有的应用程序监听器，设置到 *listeners* 属性中
  - 推断并设置 *main* 方法的定义类，找到运行的主类



### yaml配置文件

#### 基本语法

> yaml写入对象

```yaml
student: 
	name: Tom
	age: 3
	
#以上语句等同于
student: {
	name: Tom,
	age: 3
}
```

> yaml写入数组

```yaml
pets:
	- cat
	- dog
	- pig
	
#等同于
pets: [cat, dog, pig]
```



#### yaml可以给实体类赋值

在实体类中使用注解 `@ConfigurationProperties` 可以指定赋值

> 实例

- yaml.xml

```yaml
 #自动赋值
 person:
  name: "Tony"
  age: ${random.int}  #随机生成数字
  happy: false
  birth: 2020/12/28
  maps: {k1: v1, k2: v2}
  hello: happy
  lists:
    - code
    - music
    - girls
  dog:
    name: ${person.hello:hello}_旺财  #类似于三目运算符
    age: 4
```

- 对应的实体类

```java
@Component
@ConfigurationProperties(prefix = "person")     //绑定yaml文件中注入的值
public class Person {
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;
    
    /*getter and setter*/
}
```



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

#### @ConfigurationProperties(prefix = "key") 

> 功能

绑定yaml文件中注入的值



#### @Validated

> 功能

将其置于实体类上，可以进行属性的数据校验



## springboot_01_hello项目目录

- src/main
  - java/com/learn
    - boot	【存放项目启动类】
      - controller  【存放项目控制器】
  - resource  【存放配置文件】
    - `application.properties`  【springboot的配置文件，在springboot中，已经简化了配置，因此只需要配置该文件即可】
    - `banner.txt`  【用作自定义logo】



## SpringBoot web开发

### springboot特点

> 自动装配

- `xxxAutoConfiguration`  向容器中自动装配组件
- `xxxProperties`  自动配置类，装配文件中自定义的内容



### springboot web需要解决的问题

- 导入静态资源
- 制作网站首页
- jsp，导入模板引擎 *Thymeleaf* 
- 装配扩展 SpringMVC 
- 增删改查
- 拦截器
- 国际化



### 静态资源

> 处理静态资源的方式

- webjars	
  - `http://localhost:8080/webjars/需要访问的文件`

- `classpath`目录下的*public*、*static*、*resources*、*/*** 目录下的文件都可以直接被接口所访问到
  - `http://localhost:8080/在以上三个文件夹下的文件`

> 优先级

resources > static（默认使用） > public



### 定制首页

将首页命名为 index 随后将其放入classpath目录下，springboot会自动识别