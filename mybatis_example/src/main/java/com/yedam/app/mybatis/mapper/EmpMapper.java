package com.yedam.app.mybatis.mapper;

import java.util.List;

/* Mapper 실제 SQL문을 수행하는 객체
  테이블 하나당 mapper도 하나 1:1 대응함
  구현객체를 직접 만들어야함 */
public interface EmpMapper {
	
   // 전체조회 query문 하나에 method 하나
	public List<EmpV> selectAll();
	
   // 단건조회
	public EmpV selectInfo(EmpV emp);
   // 등록
	public int insertInfo(EmpV emp);
   // 수정
	public int updateInfo(EmpV emp);
   // 삭제
	public int deleteInfo(EmpV emp);
	
	
	
	
	
	
	
	
	
}
