package com.example;

import com.example.config.MyConfig;
import com.example.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication	//添加参数，则可以指定扫描的包，默认只扫描同级或者子包
public class Springboot01HelloApplication {

	public static void main(String[] args) {
		//返回IOC容器
		ConfigurableApplicationContext run = SpringApplication.run(Springboot01HelloApplication.class, args);

		getMyConfig(run);
	}

	/**
	 * 查看容器组件
	 * @param run IOC容器
	 */
	public static void showBeanDefinitionNames(ConfigurableApplicationContext run) {
		String[] beanDefinitionNames = run.getBeanDefinitionNames();

		for (String beanDefinitionName : beanDefinitionNames) {
			if (beanDefinitionName.equals("user01"))
				System.out.println("=======================================");
			if (beanDefinitionName.equals("pet01"))
				System.out.println("=======================================");
			System.out.println(beanDefinitionName);
		}
	}

	/**
	 * 从容器中获取组件
	 * @param run
	 */
	public static void getBean(ConfigurableApplicationContext run) {
		User user01 = run.getBean("user01", User.class);
		User user02 = run.getBean("user01", User.class);

		System.out.println(user01);
		System.out.println(user02);
		System.out.println(user01 == user02);
	}

	/**
	 * 获取组件容器对象
	 * @param run
	 */
	public static void getMyConfig(ConfigurableApplicationContext run) {
		MyConfig bean = run.getBean(MyConfig.class);
		User user01 = bean.user01();
		User user02 = bean.user01();

		//组件默认是一个代理类，因此不是调用方法，而是调用容器对象
		System.out.println(user01 == user02);
	}

}
