package com.yedam.app.mybatis.mapper;

import java.util.List;

import com.yedam.app.mybatis.service.DeptVO;

public interface DeptMapper {
	// 전체조회
	public List<DeptVO> selectAll();
	// 단건조회
	public DeptVO selectInfo(DeptVO dept);
	// 등록
	public int insertInfo(DeptVO dept);
	// 수정
	public int updateInfo(DeptVO dept);
	// 삭제
	public int deleteInfo(int deptId);
}
