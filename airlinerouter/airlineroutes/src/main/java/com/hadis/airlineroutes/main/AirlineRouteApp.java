package com.hadis.airlineroutes.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hadis.airlineroutes.config.AirlineRouteAppConfig;
import com.hadis.airlineroutes.config.AirlineRouteAppConfigDB;
import com.hadis.airlineroutes.util.DataStoreUtil;

public class AirlineRouteApp {

	public AirlineRouteApp() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AirlineRouteAppConfig.class, AirlineRouteAppConfigDB.class);
		String activeProfiles = System.getProperty("spring.profiles.active");
		System.out.println("Active Profiles: " +activeProfiles);
		ctx.refresh();
		DataStoreUtil theBean = ctx.getBean(DataStoreUtil.class);
		System.out.println("theBean class name: " +theBean.getClass().getName());
	}
}
