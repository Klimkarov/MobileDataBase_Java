package com.example.MobileDB;

import java.sql.Connection;

import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPConfig {

	private static HikariDataSource datasource;

	public HikariCPConfig() {

	}

	public static void configurationInit() {

		ConfigurationFileReader configReader = new ConfigurationFileReader();

		HikariConfig config = new HikariConfig();
		
		config.setJdbcUrl(configReader.getProperty("db.url"));
		config.setUsername(configReader.getProperty("db.username"));
		config.setPassword(configReader.getProperty("db.password"));

		config.addDataSourceProperty("cachePrepStms", "true");
		config.addDataSourceProperty("prepStmtSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		datasource = new HikariDataSource(config);

	}

	public static Connection getConnection() throws SQLException {

		if (datasource == null) {
			configurationInit();
		}
		return datasource.getConnection();

	}

	public static void main(String[] args) {

		HikariCPConfig config = new HikariCPConfig();

		try {
			config.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
