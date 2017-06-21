package com.choa.member.teacher;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.ex5.MyAbstractTestUnit;

public class TeacherDAOImplTest extends MyAbstractTestUnit {
	@Autowired
	private TeacherDAOImpl teacherDAOImpl;
	private static TeacherDTO teacherDTO;
	@Autowired
	private TeacherServiceImpl teacherServiceImpl;
	
	@Test
	public void test() throws Exception {
		int result = teacherServiceImpl.memberJoin(teacherDTO);
		
		assertEquals(1, result);
	}

	@BeforeClass
	public static void makeTeacher() throws Exception {
		teacherDTO = new TeacherDTO();
		
		String data = "kykyn2";
		
		teacherDTO.setId(data);
		teacherDTO.setPw(data);
		teacherDTO.setName(data);
		teacherDTO.setAge(44);
		teacherDTO.setGrade("t");
		teacherDTO.setFilename(data);
		teacherDTO.setOriname(data);
		teacherDTO.setTid(data);
		teacherDTO.setSubject(data);
	}
}
