package com.yedam.app.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.app.mybatis.common.MybatisSqlSessionFactory;
import com.yedam.app.mybatis.service.EmpVO;

// 구현객체는 Mybatis가 자동으로 생성
public class EmpMapperImpl implements EmpMapper {
	// DB와의 연결 접속 정보를 가지는 factory
	private SqlSessionFactory factory = MybatisSqlSessionFactory.getSqlSessionFactory();

	@Override
	public List<EmpVO> selectAll() {
		// try-with-resources : 자동으로 자원을 닫아줌 false 하면 auto-commit을 안하겠다
		try (SqlSession session = factory.openSession()) {
			// selectList는 반드시 List Type
			List<EmpVO> list = session.selectList("com.yedam.app.mybaits.mapper.EmpMapper.selectAll");
			return list;
		}
	}

	@Override
	public EmpVO selectInfo(EmpVO emp) {
		try (SqlSession session = factory.openSession()) {
			EmpVO find = session.selectOne("com.yedam.app.mybaits.mapper.EmpMapper.selectInfo", emp);
			return find;
		}
	}

	@Override
	public int insertInfo(EmpVO emp) {
		try (SqlSession session = factory.openSession(true)) {
			int result = session.insert("com.yedam.app.mybaits.mapper.EmpMapper.insertInfo", emp);
			return result;
		}
	}

	@Override
	public int updateInfo(EmpVO emp) {
		try (SqlSession session = factory.openSession(true)) {
			int result = session.update("com.yedam.app.mybaits.mapper.EmpMapper.updateInfo", emp);
			return result;
		}
	}

	@Override
	public int deleteInfo(int empId) {
		try (SqlSession session = factory.openSession(true)) {
			int result = session.delete("com.yedam.app.mybaits.mapper.EmpMapper.deleteInfo", empId);
			return result;
		}
	}
	

}
