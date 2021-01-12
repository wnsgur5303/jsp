package kr.or.ddit.emp.service;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;


public interface EmpServiceI {
	List<EmpVo> selectAllUser();
	
	EmpVo selectUser(int no);
	
	List<EmpVo> selectPagingUser(PageVo vo);
}
