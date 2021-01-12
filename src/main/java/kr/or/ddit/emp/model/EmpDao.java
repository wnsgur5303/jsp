package kr.or.ddit.emp.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.emp.repository.EmpDaoI;
import kr.or.ddit.user.model.UserVo;

public class EmpDao implements EmpDaoI{

	@Override
	public List<EmpVo> selectAllEmp() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<EmpVo> empList = sqlSession.selectList("emp.selectAllEmp");
		
		sqlSession.close();
		return empList;
	}

	@Override
	public EmpVo selectEmp(int no) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		EmpVo user = sqlSession.selectOne("emp.selectEmp", no);
		sqlSession.close();
		
		return user;
	}

	@Override
	public List<EmpVo> selectPagingEmp(PageVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<EmpVo> empList = sqlSession.selectList("emp.selectPagingEmp", vo);
		
		sqlSession.close();
		return empList;
	}

}
