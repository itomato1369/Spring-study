package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.EmpVO;

/*"com.yedam.app.**.mapper" 
 * @MapperScan(basePackages = "com.yedam.app.**.mapper") 
 */

public interface EmpMapper {
	// 전체조회
	public List<EmpVO> selectEmpAll();
	
	// 단건조회
	public EmpVO selectEmp(EmpVO empVO);
	
	// INSERT
	public int insertEmp(EmpVO empVO);
	
	// UPDATE
	public int updateEmp(@Param("eid")int employeeId,
	                     @Param("emp")EmpVO empVO);
	
	// DELETE
	// @Param mybatis꺼임
	/*
	 * メソッド引数 : 
	 * Mapperインターフェースのメソッド引数とXMLのSQL文中のプレースホルダを紐付けるためのもの
	 * Mybatis 사용 하는 경우 매개변수는 1개만 등록
	 * ＠Param　매개변수２개　이상
	 * 단순 SQL문이 아닌 Procedure 사용할 때
	 */
	public int deleteEmp(int employeeId);
	

}
