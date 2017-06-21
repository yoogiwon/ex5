package com.choa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.choa.ex5.FileDTO;
import com.choa.util.FileSaver;

@Controller
public class FileUploadController {
	@RequestMapping("/test/fileUpForm")
	public void fileUp() {
		
	}
	
	// 첫 번째 방법
	//@RequestMapping(value = "/test/fileUp1", method = RequestMethod.POST)
	public void fileUpload1(String name, MultipartHttpServletRequest request) throws Exception {
		MultipartFile multipartFile = request.getFile("f1"); // 파일의 정보를 저장
		
		System.out.println("name : " + name);
		System.out.println("getName : " + multipartFile.getName());
		System.out.println("originalname : " + multipartFile.getOriginalFilename());
		System.out.println("size : " + multipartFile.getSize());
		
		String path = request.getSession().getServletContext().getRealPath("resources/upload");
		
		FileSaver fileSaver = new FileSaver();
		
		fileSaver.fileSave(path, multipartFile.getOriginalFilename(), multipartFile.getBytes());
	}
	
	// 두 번째 방법(파일 이름을 알고 있을 때 파일 이름을 매개변수명으로 받아옴)
	//@RequestMapping(value = "/test/fileUp1", method = RequestMethod.POST)
	public void fileUpload2(String name, MultipartFile f1, HttpSession session) throws Exception {
		System.out.println("name : " + name);
		System.out.println("getName : " + f1.getName());
		System.out.println("originalname : " + f1.getOriginalFilename());
		System.out.println("size : " + f1.getSize());
		
		String path = session.getServletContext().getRealPath("resources/upload");
		
		FileSaver fileSaver = new FileSaver();
		
		fileSaver.fileSave(path, f1.getOriginalFilename(), f1.getBytes());
	}
	
	// 세 번째 방법(파라미터를 묶는 방법)
	@RequestMapping(value = "/test/fileUp1", method = RequestMethod.POST)
	public void fileUpload3(FileDTO fileDTO, HttpSession session) throws Exception {
		FileSaver fileSaver = new FileSaver();
		
		String realPath = session.getServletContext().getRealPath("resources/upload");
		String oriName = fileDTO.getF1().getOriginalFilename();
		byte[] fileData = fileDTO.getF1().getBytes();
		
		fileSaver.fileSave(realPath, oriName, fileData);
	}
}
