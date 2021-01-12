package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserDaoI {
	//전체 사용자 정보 조회
	/*
	 * 전체 사용자 정보 조회
	 * SELECT * FROM users
	 * WHERE users
	 * */
	
	
	List<UserVo> selectAllUser();
	
	UserVo selectUser(String userid);
	
	List<UserVo> selectPagingUser(PageVo vo);
	
	int selectAllUserCnt();
	
	int insertUser(UserVo vo);
	
}
