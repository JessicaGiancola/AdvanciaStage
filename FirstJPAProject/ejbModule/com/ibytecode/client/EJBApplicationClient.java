package com.ibytecode.client;

import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import com.ibytecode.businesslogic.ProjectBeanRemote;
import com.ibytecode.clientutility.JNDILookupClass;
import com.ibytecode.entities.Project;

public class EJBApplicationClient {
    private static final String LOOKUP_STRING = "/FirstJPAProject/ProjectBean!com.ibytecode.businesslogic.ProjectBeanRemote";
 
    public static void main(String[] args) {
    	ProjectBeanRemote bean = doLookup();
 
        Project p1 = new Project();
        p1.setPname("Banking App");
        p1.setPlocation("Town City");
        p1.setDeptNo(1);
 
        Project p2 = new Project();
        p2.setPname("Office Automation");
        p2.setPlocation("Downtown");
        p2.setDeptNo(2);
 
        // 3. Call business logic
        // Saving new Projects
        bean.saveProject(p1);
        bean.saveProject(p2);
 
        // Find a Project
        p1.setPnumber(1);
        Project p3 = bean.findProject(p1);
        System.out.println(p3);
 
        // Retrieve all projects
        System.out.println("List of Projects:");
        List<Project> projects = bean.retrieveAllProjects();
        for (Project project : projects)
            System.out.println(project);
    }
 
    private static ProjectBeanRemote doLookup() {
        Context context = null;
        ProjectBeanRemote bean = null;
        try {
            // 1. Obtaining Context
            context = JNDILookupClass.getInitialContext();
            // 2. Lookup and cast
            Object obj = context.lookup(LOOKUP_STRING);
            System.out.println("risorsa: "+ obj.toString());
            bean = (ProjectBeanRemote) obj;
//            bean = (ProjectBeanRemote) context.lookup(LOOKUP_STRING);
 
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
