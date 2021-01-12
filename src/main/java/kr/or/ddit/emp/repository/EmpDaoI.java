package kr.or.ddit.emp.repository;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;


public interface EmpDaoI {
	
	List<EmpVo> selectAllEmp();
	
	EmpVo selectEmp(int no);
	
	List<EmpVo> selectPagingEmp(PageVo vo);

}
