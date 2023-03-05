package com.icrypt.app;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.icrypt.app.flyway.DatabaseMigration;
import com.icrypt.app.multitenant.MultiTenantConfiguration;

@SpringBootApplication
public class SpringBootStarterApp {
	  public static void main(String[] args) {
		    DatabaseMigration.runConfiguration();
		    SpringApplication.run(SpringBootStarterApp.class, args);
		  }
	  
	  
	  
	  @Bean
	  public DataSource dataSource() {
		  MultiTenantConfiguration multiTenantConfiguration = new MultiTenantConfiguration();
		  multiTenantConfiguration.initDatasource(); 
		return  multiTenantConfiguration;
		  
	  }
}
