package com.mountmeru.entitymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.mountmeru.entitymanagement.config.StorageProperties;	


// This is for JAR

// @SpringBootApplication 
// @EnableScheduling
// @EnableConfigurationProperties(StorageProperties.class)
// public class AuditManagementSystemApplication {
//	 public static void main(String[] args) {
//		 SpringApplication.run(AuditManagementSystemApplication.class, args); 
//	 } 
//  }
 




// This is for Web Archive
 @SpringBootApplication 
 @EnableScheduling
 @EnableConfigurationProperties(StorageProperties.class)
  public class AuditManagementSystemApplication extends SpringBootServletInitializer{
 
  public static void main(String[] args)
  {
	  SpringApplication.run(AuditManagementSystemApplication.class, args);
  }
  
  @Override
  protected SpringApplicationBuilder  configure(SpringApplicationBuilder application) { 
	  return  application.sources(AuditManagementSystemApplication.class);
	  }
 }
 
 
 