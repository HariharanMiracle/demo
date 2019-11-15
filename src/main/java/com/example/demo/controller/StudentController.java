package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.StudentService;

@Controller
public class StudentController {

	private final StudentService studentService;
	
	@Autowired
    public StudentController(StudentService studentService) {this.studentService = studentService;}
	
	@RequestMapping(value = "/findAllStudentsToManageMarkForThisTerm")
	@ResponseBody
	public ModelAndView findAllStudentsToManageMarkForThisTerm() {		
		ModelAndView modelAndView = new ModelAndView("AddMarkForThisTerm.jsp");
        modelAndView.addObject("students", studentService.findAllStudentsToManageMarkForThisTerm());
        System.out.println("this is Student controller line 26");
        return modelAndView;
	}
	
	@RequestMapping(value = "/findAllStudentsToEditMarkForThisTerm")
	@ResponseBody
	public ModelAndView findAllStudentsToEditMarkForThisTerm() {		
		ModelAndView modelAndView = new ModelAndView("EditMarkForThisTerm.jsp");
        modelAndView.addObject("students", studentService.findAllStudentsToEditOrDeleteMarkForThisTerm());
        System.out.println("this is Student controller line 35");
        return modelAndView;
	}
	
	@RequestMapping(value = "/findAllStudentsToDeleteMarkForThisTerm")
	@ResponseBody
	public ModelAndView findAllStudentsToDeleteMarkForThisTerm() {		
		ModelAndView modelAndView = new ModelAndView("DeleteMarkForThisTerm.jsp");
        modelAndView.addObject("students", studentService.findAllStudentsToEditOrDeleteMarkForThisTerm());
        System.out.println("this is Student controller line 44");
        return modelAndView;
	}
	
	@RequestMapping(value = "/findAllStudentsToViewProgressAndMarks")
	@ResponseBody
	public ModelAndView findAllStudentsToViewProgressAndMarks() {		
		ModelAndView modelAndView = new ModelAndView("ViewProgressAndMarks.jsp");
        modelAndView.addObject("students", studentService.findAllStudents());
        System.out.println("this is Student controller line 53");
        return modelAndView;
	}
	
}
