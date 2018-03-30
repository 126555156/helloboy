package com.hwx.dao;

import java.beans.PropertyVetoException;


import org.springframework.stereotype.Service;

import com.mchange.v2.c3p0.ComboPooledDataSource;
@Service
public class HelloBoyJdbc {
	 ComboPooledDataSource dataSource = new ComboPooledDataSource();
	public HelloBoyJdbc() {
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/hello_boy");
			dataSource.setUser("root");
			System.out.println("数据库连接创建");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
