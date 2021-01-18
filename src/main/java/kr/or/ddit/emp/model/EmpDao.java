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

	@Override
	public int modifyEmp(EmpVo empvo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		//필드로 빼면 안된다(시스템을 사용하는 사람이 여럿이다. 연결이 분리되어야함) 서로 다른 트랜잭션이라 그때 그때 생성야함
		int updateCnt = sqlSession.update("emp.modifyEmp", empvo);
		if(updateCnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return updateCnt;
	}

}
