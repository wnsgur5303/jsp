package kr.or.ddit.emp.service;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpDao;
import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.emp.repository.EmpDaoI;

public class EmpService implements EmpServiceI{
	private EmpDaoI empDao = new EmpDao();
	
	@Override
	public List<EmpVo> selectAllUser() {
		return empDao.selectAllEmp();
	}

	@Override
	public EmpVo selectUser(int no) {
		return empDao.selectEmp(no);
	}

	@Override
	public List<EmpVo> selectPagingUser(PageVo vo) {
		return empDao.selectPagingEmp(vo);
	}

}
