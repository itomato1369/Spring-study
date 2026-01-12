package com.yedam.app.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.app.lombok.MybatisSqlSessionFactory;

public class EmpMapperImpl implements EmpMapper {

	private SqlSessionFactory factory = MybatisSqlSessionFactory.getSqlSessionFactory();
	
	@Override
	public List<EmpV> selectAll() {
		SqlSession session = factory.openSession(true);
		List<EmpV> list = session.selectList("EmpMapper.selectAll");
		return list;
	}

	@Override
	public EmpV selectInfo(EmpV emp) {
		return null;
	}

	@Override
	public int insertInfo(EmpV emp) {
		return 0;
	}

	@Override
	public int updateInfo(EmpV emp) {
		return 0;
	}

	@Override
	public int deleteInfo(EmpV emp) {
		return 0;
	}

}
