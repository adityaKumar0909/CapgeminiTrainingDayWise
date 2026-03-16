package com.ak;

import org.springframework.stereotype.Component;

//asking IOC container (Applicationcontext : AnnotationConfigApplicationContext)
//create an object for this class
@Component
public class PasswordHasher {
	String hash(String password) {
		return new StringBuilder(password).reverse().toString();
	}

	PasswordHasher() {

	}

}
