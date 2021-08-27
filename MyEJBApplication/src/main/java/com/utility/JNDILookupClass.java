package com.utility;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDILookupClass {

	private static final String INITIAL_CONTEXT_FACTORY = 
			"org.jboss.naming.remote.client.InitialContextFactory";
 
    private static Context initialContext;
     
    public static Context getInitialContext() throws NamingException
    {
        if (initialContext == null) {
            //Properties extends HashTable
            Properties prop = new Properties();  
//            prop.put(Context.INITIAL_CONTEXT_FACTORY,  INITIAL_CONTEXT_FACTORY);
//            prop.put(Context.URL_PKG_PREFIXES, "java:global/FirstJPAProject/com.ibytecode.");
//            prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            prop.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
            prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            initialContext = new InitialContext(prop);
        }
        return initialContext;
    }
}
