package com.icrypt.app.multitenant;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.icrypt.app.tenantcontext.ClientDatabase;
import com.icrypt.app.tenantcontext.CustomerContextHolder;


public class MultiTenantConfiguration extends AbstractRoutingDataSource {

	
	public MultiTenantConfiguration() {
		System.out.println("Trestset");
	}
	
    @Override
    protected Object determineCurrentLookupKey() {
    	System.out.println("----------------"+CustomerContextHolder.getClientDatabase());    	
    	return CustomerContextHolder.getClientDatabase();
    }
    
    public void initDatasource() {
		Map<Object, Object> dataSourceMap = new HashMap<>();
		DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/tenant2?currentSchema=tenant2schema");
		DriverManagerDataSource dataSource1 = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/tenant1?currentSchema=tenant1schema");
		dataSourceMap.put(ClientDatabase.CLIENT_B, dataSource1);
		dataSource1.setUsername("postgres");
		dataSource1.setPassword("admin");
		dataSourceMap.put(ClientDatabase.CLIENT_A, dataSource);
		dataSource.setUsername("postgres");
		dataSource.setPassword("admin");
		this.setTargetDataSources(dataSourceMap);
		this.setDefaultTargetDataSource(dataSource1);
	}
}
