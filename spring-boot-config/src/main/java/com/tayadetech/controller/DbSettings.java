package com.tayadetech.controller;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration 				   //This annotation will tell spring to map this class as bean.
@ConfigurationProperties("db") //This annotation will look into application.properties file to find any value start with "db" if it is their 
							   //then it will map those value to the class variable, but Class variable and properties file variable need to be 
							   //same after db.
public class DbSettings {

	private String connection;
	private String host;
	private String port;
	
	public String getConnection() {
		return connection;
	}
	public void setConnection(String connection) {
		this.connection = connection;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	
}
