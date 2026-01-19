package com.yedam.app.upload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	/*
	 * @Overriding에 대해서 아무 반응이 없음
	 * 
	 * WebMvcConfigurer는 abstract Method 가 없음 Interface는 abstract Method를 가진
	 * Object인데 static Method가 존재할 수 있음 default Method도 존재할 수 있음(추가하고자 하는 부분만 수정해라)
	 * {} 실행블럭을 가지는 Method를 추가할 수 있음
	 * 
	 * abstract class 는 객체에 대한 정의를 담당 Interface는 기능적인 담당
	 */
	@Value("${file.upload.path}")
	private String uploadPath;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// file.upload.path=D:/upload/를 찾아감
		registry.addResourceHandler("/images/**") // URL
				.addResourceLocations("file:///" + uploadPath, ""); // 실제 경로
		/* => 하나의 URL에 여러 경로를 매핑하는 게 가능함
		 *  file:/// 이 붙어야함 file에 대한 경로니까
		 */
	}

}
