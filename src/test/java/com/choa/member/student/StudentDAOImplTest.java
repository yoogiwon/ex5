package com.choa.member.student;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.ex5.MyAbstractTestUnit;
import com.choa.member.MemberDAO;
import com.choa.member.MemberDTO;

public class StudentDAOImplTest extends MyAbstractTestUnit {
	@Autowired
	private StudentDAOImpl studentDAOImpl;
	private static StudentDTO studentDTO;
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@Test
	public void test() throws Exception {
		int result = studentServiceImpl.memberJoin(studentDTO);
		
		assertEquals(1, result);
	}

	@BeforeClass
	public static void makeStudent() throws Exception {
		studentDTO = new StudentDTO();
		
		String data = "akges2";
		
		studentDTO.setId(data);
		studentDTO.setPw(data);
		studentDTO.setName(data);
		studentDTO.setAge(14);
		studentDTO.setGrade("s");
		studentDTO.setFilename(data);
		studentDTO.setOriname(data);
		studentDTO.setSid(data);
		studentDTO.setPhone(data);
		studentDTO.setTid("kddkdkdk");
	}
}
