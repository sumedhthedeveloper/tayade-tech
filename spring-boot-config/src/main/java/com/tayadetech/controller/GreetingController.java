package com.tayadetech.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
//@PropertySource("classpath:application2.yml")
public class GreetingController {

	@Value("${my.greeting: Default Value}") //In order to use any external properties file, keep that external properties file in same folder of as jar or war file 
	private String greetingMessage; //so that it will override with internal properties file 
	//Or with command line argument you can also change properties eg. java -jar spring-boot-config-0.0.1-SNAPSHOT.jar --my.greeting="Hello World! from Command Line Arguement"
	
	@Value("some static value")
	private String staticMessage;
	
	@Value("${my.list.values}")
	private List<String> listMessage;
	
	@Value("#{${dbValues}}")
	private Map<String,String> dbValues;
	
	@Autowired
	private DbSettings dbSettings;
	
	@GetMapping("/greeting")
	public String greeting()
	{
		return  greetingMessage+" "+staticMessage+" "+listMessage+" "+dbSettings.getConnection()+"  <<< ### >>>"+dbValues;
	}
}
