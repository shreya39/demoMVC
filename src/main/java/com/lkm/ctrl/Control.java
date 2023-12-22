package com.lkm.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.lkm.beans.Department;
import com.lkm.beans.Student;
import com.lkm.dao.studentdao;
import com.lkm.dao.departmentdao;

@Controller
public class Control {

	@Autowired
	private studentdao studentdao; 
	
	@Autowired
	private departmentdao departmentdao;
	
	private static final Logger logger=Logger.getLogger(Control.class);
	
	
	@RequestMapping("/home")
	public String home(Model m) {
		String str = "home";
		logger.info("Inside home method");
	    //logger.error("This is error message");
		m.addAttribute("page", str);
		List students=this.studentdao.showstudents();
		m.addAttribute("students", students);
		return "home";
	}

	@RequestMapping("/add")
	public String addStudent(Model m) {
		logger.info("Inside addStudent method");
		Student s = new Student();
		m.addAttribute("page", "add");
		m.addAttribute("student", s);
		return "home";
	}

	@RequestMapping(value = "/savestudent", method = RequestMethod.POST)
	public RedirectView savestudent(@Valid @ModelAttribute("student") Student stu , BindingResult result, 
			HttpServletRequest request) {
		
		RedirectView redirectView= new RedirectView();
		if(result.hasErrors()) {
			System.out.println("Error occured");
			redirectView.setUrl(request.getContextPath()+ "/add");
		}
		else {
			System.out.println(stu);
			this.studentdao.createstudent(stu);
			redirectView.setUrl(request.getContextPath()+ "/home");
		}
		return redirectView;
	}
	
	@RequestMapping("/departments")
	public String departments(Model m) {
		logger.info("Inside departments method");
		List departments=this.departmentdao.showdepartments();
		m.addAttribute("departments", departments);
		return "dept";
	}
	
	@RequestMapping("/addDept")
	public String addDept(Model m) {
		logger.info("Inside addDept method");
		Department d=new Department();
		m.addAttribute("department",d);
		m.addAttribute("page", "addDept");
		return "dept";
	}
	
	@RequestMapping(value = "/saveDept", method = RequestMethod.POST)
	public RedirectView savedepartment(@ModelAttribute Department dep, HttpServletRequest request) {
		System.out.println(dep);
		this.departmentdao.createdepartment(dep);
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+ "/departments");
		return redirectView;
	}
	
	@RequestMapping(value="/deleteDept/{dId}")
    public RedirectView deletedepartment(@PathVariable("dId") int dId,HttpServletRequest request) {
		this.departmentdao.deletedepartment(dId);
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+ "/departments");
		return redirectView;
	 }
	
	 @RequestMapping(value="/updateDept/{dId}")
	 public String updatedepartment(@PathVariable("dId") int dId,Model m) {
			Department dept=this.departmentdao.getdepartment(dId);
			System.out.println(dept);
			m.addAttribute("departmentobj",dept);
            m.addAttribute("page","updateDept");
			return "dept";
		 }
	 
	 @RequestMapping(value="/deletestudent/{sId}")
	 public RedirectView deletestudent(@PathVariable("sId") int sId,HttpServletRequest request) {
		 this.studentdao.deletestudent(sId);
		 RedirectView redirectView=new RedirectView();
		 redirectView.setUrl(request.getContextPath()+"/home");
		 return redirectView;
	 }
	 
	 @RequestMapping(value="/updatestudent/{sId}")
	 public String updatestudent(@PathVariable("sId") int sId,Model m) {
		 Student stu=this.studentdao.getstudent(sId);
		 System.out.println(stu);
		 m.addAttribute("studentobj",stu);
		 m.addAttribute("page","updatestudent");
		 return "home";
	 }
}
