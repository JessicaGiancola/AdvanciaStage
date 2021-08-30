package com.jwt.ejb.business.impl;

import javax.ejb.Remote;

import com.jwt.ejb.entity.Employee;

@Remote
public interface ManageEmployeeBeanRemote {

	public boolean addEmployee(Employee employee);
}
