package com.yedam.app.upload.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UploadController {
	
	// private String uploadPath = "D:/upload/";
	/*
	 * java -jar sp03.jar -Dfile.upload.path=D:/upload/
	 * ${} 변수값 가져오기
	 */
	@Value("${file.upload.path}")
	private String uploadPath;

	@GetMapping("formUpload")
	public void formUploadPage() {
	}

	@PostMapping("uploadForm")
	public String formUploadFile(@RequestPart MultipartFile file) {
		/*
		 *  @RequestPart MultipartFile 이렇게 해야됨 객체가 
		 *  
		 *  Http Request에 대한 MultipartRsolver가 해석해서 전달
		 *  멀티미디어파일을 내부에 들고 있는 객체
		 *  formUpload.html에서 name="file"이니 매개변수 이름도 동일하게
		 *  
		 *  그냥 memory에 올라가 있음
		 *  
		 *  project 내부에 파일 업로드 경로 설정하면 안됨
		 *  spring boot 는 .jar 파일 하나로 싹 다 압축
		 *  project 바깥에 경로 설정
		 *  
		 *  사용자와 상관없이 사용하는 이미지, 영상 등 static 파일은 내부에 저장
		 */
		log.info(uploadPath);
		log.info(file.getContentType()); // 파일의 종류 및 확장자   image/png    application/pdf
		
		log.info(file.getOriginalFilename()); // 파일 이름             폼폼푸린.png
		
		log.info(String.valueOf(file.getSize())); // 파일 크기 byte단위  4325
		
		String fileName = file.getOriginalFilename();
		String saveName = uploadPath + File.separator + fileName;
		// 저장경로를 구성 =  File.separato경로구분자 
		log.debug("saveName : " + saveName);
		
        /*
         * Paths.get() 메서드는 특정 경로의 파일 정보를 반환(경로 정의)
         * File class와 비슷한데 경로를 구성하는 문자열이 올바른가 정리를 함
         */
		Path savePath = Paths.get(saveName);
		try {
			/* 실제로 파일을 업로드(저장) 하는 Method          transferTo(file)
			 * 1MB 보다 파일이 크면 제한이 걸림
			 */
			file.transferTo(savePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:formUpload";
	}
	/* 
	 * application.properties에 저장경로를 설정
	 */
	
	
	@GetMapping("upload")
	public void uploadPage() {}
	
	@PostMapping("/uploadsAjax")
	@ResponseBody
	public List<String> uploadFile
			(@RequestPart MultipartFile[] uploadFiles) {
	    
		List<String> imageList = new ArrayList<>();
		
	    for (MultipartFile uploadFile : uploadFiles) {
	    	// image로 시작한 것만 처리한다
	    	if (uploadFile.getContentType().startsWith("image") == false) {
	    		System.err.println("this file is not image type");
	    		return null;
	        }
	  
	        String fileName = uploadFile.getOriginalFilename();
	        
	        System.out.println("fileName : " + fileName);
	    
	        // 날짜 폴더 생성
	        String folderPath = makeFolder();
	        // UUID
	        String uuid = UUID.randomUUID().toString();
	        /* 
	         * 저장할 파일 이름 중간에 "_"를 이용하여 구분
	         * 저장하는 방식 날짜를 기준으로 폴더 생성  年/月
	         * Universally Unique Identifier  =  Uniqueness 
	         * 절대 충돌나지 않음
	         */
	        
	        String uploadFileName = folderPath +File.separator + uuid + "_" + fileName;
	        
	        String saveName = uploadPath + File.separator + uploadFileName; 
	        // 파일명 만듬
	        
	        Path savePath = Paths.get(saveName);
	        // Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로 정의하기)
	        System.out.println("path : " + saveName);
	        try{
	        	uploadFile.transferTo(savePath);
	            // uploadFile에 파일을 업로드 하는 메서드 transferTo(file)
	        } catch (IOException e) {
	             e.printStackTrace();	             
	        }
	        /* DB에 해당 경로 저장
	            1) 사용자가 업로드할 때 사용한 파일명
	            2) 실제 서버에 업로드할 때 사용한 경로
	         */
	            
	        imageList.add(setImagePath(uploadFileName));
	     }
	    
	    return imageList;
	}
	
	private String makeFolder() {
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		// LocalDate를 문자열로 포멧 
		
		String folderPath = str.replace("/", File.separator);
		File uploadPathFoler = new File(uploadPath, folderPath);
		// File newFile= new File(dir,"파일명");
		if (uploadPathFoler.exists() == false) {
			uploadPathFoler.mkdirs();
			/* 만약 uploadPathFolder가 존재하지않는다면 makeDirectory하라는 의미입니다.
			 mkdir(): 디렉토리에 상위 디렉토리가 존재하지 않을경우에는 생성이 불가능한 함수
			 mkdirs(): 디렉토리의 상위 디렉토리가 존재하지 않을 경우에는 상위 디렉토리까지 모두 생성하는 함수
			 */
		}
		return folderPath;
	}
	
	private String setImagePath(String uploadFileName) {
		return uploadFileName.replace(File.separator, "/");
	}
	
	
	
}
