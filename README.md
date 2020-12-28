# SSM架构/SpringBoot



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