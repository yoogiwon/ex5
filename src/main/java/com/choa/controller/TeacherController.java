package com.choa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.choa.member.teacher.TeacherDTO;
import com.choa.member.teacher.TeacherServiceImpl;

@Controller
@RequestMapping("/member/**")
public class TeacherController {
	@Autowired
	private TeacherServiceImpl teacherServiceImpl;
	
	@RequestMapping(value = "teacherJoin", method = RequestMethod.POST)
	public String memberJoin(TeacherDTO teacherDTO, Model model) throws Exception {
		System.out.println("teacher");
		int result = teacherServiceImpl.memberJoin(teacherDTO);
		String message = "JOIN FAIL";
		
		if(result>0) {
			message = "JOIN SUCCESS";
		}
		
		model.addAttribute("message", message);
		model.addAttribute("path", "../");
		
		return "common/result";
	}
}
