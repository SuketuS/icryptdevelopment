package com.icrypt.app.flyway;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.context.annotation.Configuration;
public final class DatabaseMigration {
	
	private DatabaseMigration()
	{
		super();
	}
	public static void runConfiguration() {
	String flywayScripts = "classpath:migration";
	Class cls = DatabaseMigration.class;
		FluentConfiguration flywayConfig = Flyway.configure();
	flywayConfig.dataSource("jdbc:postgresql://localhost:5432/tenant2?currentSchema=tenant2schema", "postgres", "admin");
	flywayConfig.baselineOnMigrate(true);
	flywayConfig.outOfOrder(true);	
	flywayConfig.locations(flywayScripts);
	flywayConfig.placeholderPrefix("$$$${");
	flywayConfig.placeholderPrefix("}$$$$");
//	flywayConfig.sqlMigrationPrefix("icrypt");
	flywayConfig.load().migrate();
	
//	flywayConfig.placeholderSuffix("icrypt");
	}
	public static void runConfigurationDataSource() {
		
	}
}
