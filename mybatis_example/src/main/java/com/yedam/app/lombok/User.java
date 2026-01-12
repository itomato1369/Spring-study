package com.yedam.app.lombok;

import java.util.Date;

import lombok.Data;

/* @Getter
 * @Setter
 * @ToString
 * @EqualsAndHashCode 
 * 가 적용됨 
 * @NoArgsConstructor or @RequiredArgsConstructor
*/
@Data
public class User {
	// Field
	private String id;
	private String name;
	// Date는 util밑의 Date
	private Date birthday;
	
	
	// Constructor
	
	// Method

}
