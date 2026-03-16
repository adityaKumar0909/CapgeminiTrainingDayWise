package com.ak;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class MyBeansConfig {
	@Bean
	StringBuilder stringBuilder() {
		return new StringBuilder("bean from configuration class");
	}

	@Bean
	@Primary
	Calc getCalc() {
		return new MyCalc();
	}

	@Bean(name = "calBeanBean")
	Calc getCalc2() {
		return new MyCalc();
	}

}
