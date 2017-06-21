package com.choa.util;

import java.io.File;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class FileSaver {
	// 파일을 디스크에 저장
	public String fileSave(String realPath, String oriName, byte[] fileData) throws Exception {
		File file = new File(realPath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		String fileName = UUID.randomUUID().toString() + "_" + oriName; // 실제 폴더에 저장되는 파일 이름

		File target = new File(file, fileName);

		FileCopyUtils.copy(fileData, target); // 파일 저장
		
		return fileName;
	}
}
