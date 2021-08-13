package org.o7planning.restfulcrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "user")
public class Employee {
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empID")
    private int empNo;
	
    @Column(name = "name")
    private String empName;
    
    @Column(name = "position")
    private String position;
 
    // This default constructor is required if there are other constructors.
    public Employee() {
 
    }
 
    public Employee(String empName, String position) {
        this.empName = empName;
        this.position = position;
    }
 
    public int getEmpNo() {
        return empNo;
    }
 
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }
 
    public String getEmpName() {
        return empName;
    }
 
    public void setEmpName(String empName) {
        this.empName = empName;
    }
 
    public String getPosition() {
        return position;
    }
 
    public void setPosition(String position) {
        this.position = position;
    }
 
}
