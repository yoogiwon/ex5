package com.choa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.choa.member.student.StudentDTO;
import com.choa.member.student.StudentServiceImpl;

@Controller
@RequestMapping(value = "/member/**")
public class StudentController {
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.GET)
	public void memberJoin() throws Exception {
		
	}
	
	@RequestMapping(value = "studentJoin", method = RequestMethod.POST)
	public String memberJoin(StudentDTO studentDTO, Model model) throws Exception {
		System.out.println("student");
		int result = studentServiceImpl.memberJoin(studentDTO);
		String message = "JOIN FAIL";
		
		if(result>0) {
			message = "JOIN SUCCESS";
		}
		
		model.addAttribute("message", message);
		model.addAttribute("path", "../");
		
		return "common/result";
	}
}
