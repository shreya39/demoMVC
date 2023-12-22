package com.lkm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.lkm.beans.Department;
import com.lkm.beans.Student;

@Component
public class studentdao   {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
     
    //to create or update a student
    @Transactional
    public void createstudent(Student stu) {
    	this.hibernateTemplate.saveOrUpdate(stu);
    }
    
    //to fetch all students
    @Transactional
    public List<Student> showstudents(){
    	List<Student> students=this.hibernateTemplate.loadAll(Student.class);
		return students;
    }

    @Transactional
	public void deletestudent(int sId) {
		// TODO Auto-generated method stub
		Student stu= this.hibernateTemplate.load(Student.class, sId);
    	this.hibernateTemplate.delete(stu);
	}

    @Transactional
	public Student getstudent(int sId) {
		// TODO Auto-generated method stub
		Student stu= this.hibernateTemplate.get(Student.class,sId);
		System.out.println(stu);
		return stu;
	}
}

