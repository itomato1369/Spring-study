package com.yedam.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yedam.app.emp.EmpVO;
import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.service.EmpService;

import lombok.RequiredArgsConstructor;

// business bean 생성 AOP를 적용
@Service
// Construcotr 생성자 주입
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {
	// 다른 mapper 호출 가능
	private final EmpMapper empMapper;

	@Override
	public List<EmpVO> selectAll() {
		// 사원전체 조회
		return empMapper.selectEmpAll();
	}

	@Override
	public EmpVO findByEmployeeId(EmpVO empVO) {
		// 단건조회 QueryString 
		return empMapper.selectEmp(empVO);
	}

	@Override
	public int addEmpInfo(EmpVO empVO) {
		// INSERT
		// key를 기반으로 setter를 불러
		int result = empMapper.insertEmp(empVO);
		return result == 1 ? empVO.getEmployeeId() : -1;
	}

	// return type이 있는 경우 return먼저 놓고 아니면 null자체를 없애고 
	@Override
	public Map<String, Object> modify(EmpVO empVO) {
		// UPDATE
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result = empMapper.updateEmp(empVO.getEmployeeId(), empVO);
		
		if (result == 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		// 어떤 data를 UPDATE했는지 알려줌
		map.put("target", empVO);
		/*
		 * { "result" : true,
		 *   "target" : {
		 *            "employeeID" : 100,
		 *            "lastName" : "King",
		 *            ...
		 *            }
		 * }         
		 */
		
		return map;
	}

	// Map은 통신할려고 자주 씀
	@Override
	public Map<String, Object> remove(int empId) {
		// DELETE
		Map<String, Object> map = new HashMap<>();
		
		int result = empMapper.deleteEmp(empId);
		
		if (result == 1) {
			map.put("employeeId", empId);
		}
		return map;
		// true면 { "employeeId" : 100 } 값 나오고 
		// false면 빈 객체 {} 
	}
	

}
