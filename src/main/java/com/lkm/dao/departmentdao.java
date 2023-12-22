package com.lkm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.lkm.beans.Department;

@Component
public class departmentdao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
     
    //to create a dept
    @Transactional
    public void createdepartment(Department dep) {
    	this.hibernateTemplate.saveOrUpdate(dep);
    }
    
    //to fetch all depts
    @Transactional
    public List<Department> showdepartments(){
    	List<Department> departments=this.hibernateTemplate.loadAll(Department.class);
		return departments;
    }
    
    @Transactional
    public Department getdepartment(int dID) {
		Department dept= this.hibernateTemplate.get(Department.class,dID);
		System.out.println(dept);
		return dept;
	}
    
    @Transactional
    public void deletedepartment(int dId) {
    	Department dept= this.hibernateTemplate.load(Department.class, dId);
    	this.hibernateTemplate.delete(dept);
    }
}
