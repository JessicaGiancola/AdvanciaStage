package com.jwt.ejb.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jwt.ejb.business.impl.ManageEmployeeBeanRemote;
import com.jwt.ejb.entity.Employee;
 
public class Client {
    public static void main(String[] args) {
    	ManageEmployeeBeanRemote remote = doLookup();
        Employee employee = new Employee();
        employee.setFirstName("Jessica");
        employee.setLastName("Giancola");
        employee.setEmail("mrajnitro@gmail.com");
 
        Employee employee1 = new Employee();
        employee1.setFirstName("Loris");
        employee1.setLastName("Nanni");
        employee1.setEmail("ravi@gmail.com");
        remote.addEmployee(employee);
        remote.addEmployee(employee1);
    }
 
    private static ManageEmployeeBeanRemote doLookup() {
        Context context = null;
        ManageEmployeeBeanRemote bean = null;
        try {
            // 1. Obtaining Context
            context = getInitialContext();
            // 2. Lookup and cast
            bean = (ManageEmployeeBeanRemote) context.lookup(LOOKUP_STRING);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return bean;
    }
 
    private static final String LOOKUP_STRING = "/EmployeeManagementEJB/ManageEmployeeBean!com.jwt.ejb.business.impl.ManageEmployeeBeanRemote";
    /*
     *  * location of JBoss JNDI Service provider the client will use. It should
     * be * URL string.
     */
    private static final String PROVIDER_URL = "http-remoting://localhost:8080";
    /*
     *  * specifying the list of package prefixes to use when loading in URL *
     * context factories. colon separated
     */
    private static final String JNP_INTERFACES = "org.jboss.ejb.client.naming";
    /*
     *  * Factory that creates initial context objects. fully qualified class
     * name.
     */
    private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
    private static Context initialContext;
 
    public static Context getInitialContext() throws NamingException {
        if (initialContext == null) {
            // Properties extends HashTable
            Properties prop = new Properties();
            prop.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
            prop.put(Context.URL_PKG_PREFIXES, JNP_INTERFACES);
            prop.put(Context.PROVIDER_URL, PROVIDER_URL);
            initialContext = new InitialContext(prop);
        }
        return initialContext;
    }
}