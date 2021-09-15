package application;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class ClientPizzeriaApp extends Application {               

	@Override
	public Set<Class<?>> getClasses(){
		return new HashSet<Class<?>>(Arrays.asList(application.restservice.RestService.class));
	}
}
