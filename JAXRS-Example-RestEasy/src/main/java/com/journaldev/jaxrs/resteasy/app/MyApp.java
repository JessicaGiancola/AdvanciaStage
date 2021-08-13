package com.journaldev.jaxrs.resteasy.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.journaldev.jaxrs.service.PersonServiceImpl;

public class MyApp extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();

	public MyApp() {
		singletons.add(new PersonServiceImpl());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
