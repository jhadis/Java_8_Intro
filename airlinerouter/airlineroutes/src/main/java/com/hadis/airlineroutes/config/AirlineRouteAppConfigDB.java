package com.hadis.airlineroutes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hadis.airlineroutes.util.DataStoreUtil;
import com.hadis.airlineroutes.util.DataStoreUtilInMemGraph;

@Profile("embedded")
@Configuration
public class AirlineRouteAppConfigDB {

	public AirlineRouteAppConfigDB() {
		// TODO Auto-generated constructor stub
	}
	
	@Bean
	public DataStoreUtil setDataStoreUtil() {
		DataStoreUtil dataStore = new DataStoreUtilInMemGraph();
		return dataStore;
	}

}
