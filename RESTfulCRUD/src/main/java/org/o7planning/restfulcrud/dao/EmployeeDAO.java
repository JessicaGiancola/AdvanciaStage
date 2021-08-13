package org.o7planning.restfulcrud.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.o7planning.restfulcrud.model.Employee;

 
public class EmployeeDAO {
 
    private static final Map<String, Employee> empMap = new HashMap<String, Employee>();
    
    private EntityManager manager = null;
	private EntityTransaction txn = null;
	private static boolean initialized = false;
	
	private EntityManager getManager() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		txn = entityManager.getTransaction();
        return entityManager;
	}
	
	private void commitAndClose() {
		
		txn.commit();
		manager.close();
	}
	
    {
    	if (!initialized) {
    		initEmps();
    		initialized = true;
    	}
    }
 
    private void initEmps() {
        Employee emp1 = new Employee("Smith", "Clerk");
        Employee emp2 = new Employee("Allen", "Salesman");
        Employee emp3 = new Employee("Jones", "Manager");
 
        addEmployee(emp3);
        addEmployee(emp2);
        addEmployee(emp1);
    }
 
    public Employee getEmployee(int empNo) {
    	 manager = getManager();
         txn.begin(); 
         
         Query query = manager.createQuery("from Employee where id="+Integer.toString(empNo));
         Employee result = (Employee) query.getSingleResult();
         
         commitAndClose();
     	return result;
    }
 
    public Employee addEmployee(Employee emp) {
        manager = getManager();
        txn.begin();
        manager.persist(emp);
        commitAndClose();
        return emp;
    }
 
//    public static Employee updateEmployee(Employee emp) {
//        empMap.put(emp.getEmpNo(), emp);
//        return emp;
//    }
 
    public void deleteEmployee(String empNo) {
    	manager = getManager();
    	txn.begin();
    	
    	Employee obj = (Employee) manager.createQuery("from Employee where id = "+ empNo).getSingleResult();
    	manager.remove(obj);
    	
    	commitAndClose();
    }
 
    public List<Employee> getAllEmployees() {
    	manager = getManager();
        txn.begin(); 
        
        Query query = manager.createQuery("from Employee");
        List<Employee> result = query.getResultList();
        
        commitAndClose();
    	return result;
    }
     
    List<Employee> list;
 
}
