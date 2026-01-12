package com.yedam.app.lombok;

import java.util.Date;

import lombok.Data;

@Data 
// @Getter
// @Setter
// @ToString
// @EqualsAndHashCode
// @NoArgsConstructor or @RequiredArgsConstructor
public class User {
	//필드
	private String id;
	private String name;
	private Date birthday;
	//생성자
	//메서드
}
