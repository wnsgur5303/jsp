package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserServiceI {
	List<UserVo> selectAllUser();
	
	UserVo selectUser(String userid);
	
	List<UserVo> selectPagingUser(PageVo vo);
	
	int selectAllUserCnt();
	
	int insertUser(UserVo vo);
}
