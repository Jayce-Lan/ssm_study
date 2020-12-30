package com.example.config;

import com.example.pojo.Pet;
import com.example.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //配置文件类，配置类本身也是组件
public class MyConfig {
    /**
     * 给容器添加组件，以方法名作为组件id(如果假如参数，那么就以参数作为组件名)
     * bean注解默认是单实例的
     * @return 返回类型是组件类型，返回值就是容器的实例
     */
    @Bean
    public User user01() {
        //类似于bean文件中将user注入容器
        User user01 = new User();
        user01.setName("李四");
        user01.setAge(20);
        return user01;
    }

    @Bean
    public Pet pet01() {
        Pet pet01 = new Pet();
        pet01.setName("Tomcat");
        return pet01;
    }
}
