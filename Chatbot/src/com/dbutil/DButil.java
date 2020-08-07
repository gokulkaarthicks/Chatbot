package com.dbutil;


import java.sql.SQLException;


import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

public class DButil {
	private static final String DB_USERNAME="root";
	private static final String DB_PASSWORD="root";
	private static final String DB_URL ="jdbc:mysql://localhost:3306/Virtusa";
	private static final String DB_DRIVER_CLASS="com.mysql.jdbc.Driver";
	
	
	private static HikariDataSource dataSource;
	static{
		try {
	
			dataSource = new HikariDataSource();
			dataSource.setDriverClassName(DB_DRIVER_CLASS);
			
			dataSource.setJdbcUrl(DB_URL);
			dataSource.setUsername(DB_USERNAME);
			dataSource.setPassword(DB_PASSWORD);
			
			dataSource.setMinimumIdle(100);
			dataSource.setMaximumPoolSize(2000);//The maximum number of connections, idle or busy, that can be present in the pool.
			dataSource.setAutoCommit(false);
			dataSource.setLoginTimeout(3);
			
		} catch ( SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource(){
		return dataSource;
	}
}