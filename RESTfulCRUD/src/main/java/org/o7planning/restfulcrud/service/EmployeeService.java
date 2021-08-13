package org.o7planning.restfulcrud.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.o7planning.restfulcrud.dao.EmployeeDAO;
import org.o7planning.restfulcrud.model.Employee;
 
@Path("/employees")
public class EmployeeService {
	
	private EmployeeDAO dao = new EmployeeDAO();
	
    // URI:
    // /contextPath/servletPath/employees
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Employee> getEmployees_JSON() {
        List<Employee> listOfCountries = dao.getAllEmployees();
        return listOfCountries;
    }
 
    // URI:
    // /contextPath/servletPath/employees/{empNo}
    @GET
    @Path("/{empNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Employee getEmployee(@PathParam("empNo") int empNo) {
        return dao.getEmployee(empNo);
    }
 
    // URI:
    // /contextPath/servletPath/employees
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Employee addEmployee(Employee emp) {
        return dao.addEmployee(emp);
    }
 
    // URI:
    // /contextPath/servletPath/employees
//    @PUT
//    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//    public Employee updateEmployee(Employee emp) {
//        return EmployeeDAO.updateEmployee(emp);
//    }
 
    @DELETE
    @Path("/{empNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteEmployee(@PathParam("empNo") String empNo) {
        dao.deleteEmployee(empNo);
    }
 
}