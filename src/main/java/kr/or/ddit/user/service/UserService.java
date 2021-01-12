package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.xml.internal.ws.util.HandlerAnnotationInfo;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDaoI;

public class UserService implements UserServiceI{

	private UserDaoI userDao = new UserDao();
	
	@Override
	public List<UserVo> selectAllUser() {
		
		return userDao.selectAllUser();
	}

	@Override
	public UserVo selectUser(String userid) {
		// TODO Auto-generated method stub
		return userDao.selectUser(userid);
	}

//	@Override
//	public Map<String, Object> selectPagingUser(PageVo vo) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<UserVo> userList = userDao.selectPagingUser(vo);
//		
//		int userCnt = userDao.selectAllUserCnt();
//		
//		map.put("useList", userList);
//		map.put("userCnt", userCnt);
//		return map;
	@Override//Map<String,Object>
	public List<UserVo> selectPagingUser(PageVo vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserVo> userList = userDao.selectPagingUser(vo);
		
		int userCnt = userDao.selectAllUserCnt();
		
		map.put("useList", userList);
		map.put("userCnt", userCnt);
		return userList;
	}

	@Override
	public int insertUser(UserVo vo) {
		
		return (int)userDao.insertUser(vo);
	}

	@Override
	public int selectAllUserCnt() {
		
		
		return userDao.selectAllUserCnt();
	}
	
}
