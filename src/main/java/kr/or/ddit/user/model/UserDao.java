package kr.or.ddit.user.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.user.repository.UserDaoI;

public class UserDao implements UserDaoI{

	@Override
	public List<UserVo> selectAllUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		//공통적인 부분 select : 리턴되는 값의 복수 유무를 판단
		//			1.단건: 일반 객체를 반환(UserVo). selectOne()
		//			2.여러건: List(UserVo) selectList()
		//	insert,update,delete : insert,update,delete
		
		//메소드 이름과 실행할 sql id를 동인하게 맞추기(유지보수-다른 개발자의 가독성)
		List<UserVo> userList = sqlSession.selectList("users.selectAllUser");
		
		//사용한 자원 반환
		sqlSession.close();
		return userList;
	}

	@Override
	public UserVo selectUser(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		UserVo user =sqlSession.selectOne("users.selectUser", userid);
		sqlSession.close();
		return user;
	}

	@Override
	public List<UserVo> selectPagingUser(PageVo vo) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<UserVo> userList = sqlSession.selectList("users.selectPagingUser", vo);
		
		sqlSession.close();
		return userList;
	}

	@Override
	public int insertUser(UserVo vo) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int user = sqlSession.selectOne("users.insertUser", vo);
		sqlSession.close();
		return user;
	}

	@Override
	public int selectAllUserCnt() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int userCnt = sqlSession.selectOne("users.selectAllUserCnt");
		System.out.println(userCnt);
		sqlSession.close();
		
		return userCnt;
	}

	@Override
	public int modifyUser(UserVo uservo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		//필드로 빼면 안된다(시스템을 사용하는 사람이 여럿이다. 연결이 분리되어야함) 서로 다른 트랜잭션이라 그때 그때 생성야함
		int updateCnt = sqlSession.update("users.modifyUser", uservo);
		if(updateCnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return updateCnt;
	}

	@Override
	public int registUser(UserVo uservo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int insertCnt = sqlSession.insert("users.registUser", uservo);
		System.out.println(insertCnt);
		sqlSession.commit();

		sqlSession.close();
		return insertCnt;
	}


}
