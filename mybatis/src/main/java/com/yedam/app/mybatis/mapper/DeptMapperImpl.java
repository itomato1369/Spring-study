package com.yedam.app.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.app.mybatis.common.MybatisSqlSessionFactory;
import com.yedam.app.mybatis.service.DeptVO;
import com.yedam.app.mybatis.service.EmpVO;

public class DeptMapperImpl implements DeptMapper {
	// DB와 연결 접속 정보가지는 factory
	// 구현객체는 Mybatis가 자동으로 생성
	private SqlSessionFactory factory = MybatisSqlSessionFactory.getSqlSessionFactory();

	@Override
	public List<DeptVO> selectAll() {
		// try-with-resources : 자동으로 자원을 닫아줌 false 하면 auto-commit을 안하겠다
		try (SqlSession session = factory.openSession()) {
			// selectList는 반드시 List Type
			List<DeptVO> list = session.selectList("com.yedam.app.mybaits.mapper.DeptMapper.selectAll");
			return list;
		}
	}

	@Override
	public DeptVO selectInfo(DeptVO dept) {
		try (SqlSession session = factory.openSession()) {
			// selectList는 반드시 List Type
			DeptVO find = session.selectOne("com.yedam.app.mybaits.mapper.DeptMapper.selectInfo");
			return find;
		}
	}

	@Override
	public int insertInfo(DeptVO dept) {
		try (SqlSession session = factory.openSession()) {
			// Insert update delete 는 return의 int
			int result = session.insert("com.yedam.app.mybaits.mapper.DeptMapper.insertInfo");
			return result;
		}
	}

	@Override
	public int updateInfo(DeptVO dept) {
		try (SqlSession session = factory.openSession()) {
			// Insert update delete 는 return의 int
			int result = session.update("com.yedam.app.mybaits.mapper.DeptMapper.updateInfo");
			return result;
		}
	}

	@Override
	public int deleteInfo(int deptId) {
		try (SqlSession session = factory.openSession()) {
			// Insert update delete 는 return의 int
			int result = session.delete("com.yedam.app.mybaits.mapper.DeptMapper.deleteInfo");
			return result;
		}
	}

}
