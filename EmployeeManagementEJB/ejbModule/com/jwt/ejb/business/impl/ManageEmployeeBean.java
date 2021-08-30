package com.jwt.ejb.business.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jwt.ejb.entity.Employee;

/**
 * Session Bean implementation class ManageEmployeeBean
 */
@Stateless
@LocalBean
public class ManageEmployeeBean implements ManageEmployeeBeanRemote {

	 @PersistenceContext(unitName = "EmpMgmtPU")
	 private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ManageEmployeeBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addEmployee(Employee employee) {
		entityManager.persist(employee);
        return true;
	}

}
