package com.ak;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.mysql.cj.jdbc.MysqlDataSource;

@Component
public class DataSource {

	@Bean
	public MysqlDataSource mysqlDataSource() {
		MysqlDataSource ds = new MysqlDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/company_db");
		ds.setPassword("12345");
		ds.setUser("root");
		return ds;
		// TODO Auto-generated constructor stub
	}

}
