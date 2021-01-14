package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;

public class UserDaoTest {

	
	//전체 사용자 조회 테스트
	@Test
	public void selectAllUserTest() {
		/***Given***/
		UserDaoI userDao = new UserDao();

		/***When***/
		List<UserVo> userList = userDao.selectAllUser();

		/***Then***/
		assertEquals(16, userList.size());
	}
	
	//사용자 아이디를 사용하여 특정 사용자 정보 조회
	
	@Test
	public void selectUserTest() {
//접근제어자
		/***Given***/
		UserDao userDao = new UserDao();
		String userid = "brown";

		/***When***/
		UserVo user = userDao.selectUser(userid);

		/***Then***/
		assertNotNull(user);
		assertEquals("brown", user.getUserid());
	}
	
	@Test
	public void selectPagingUserTest() {
		/***Given***/
		UserDao userDao = new UserDao();
		PageVo pageVo = new PageVo();
		
		pageVo.setPage(2);
		pageVo.setPageSize(5);
		
		/***When***/userDao.selectAllUser();
		List<UserVo> user = userDao.selectPagingUser(pageVo);
		/* Map<String, Object> map = userService. */

		
		/***Then***/
		assertEquals(5, user.size());
	}

	@Test
	public void modifyUserTest(){
		/***Given***/
		UserDao userDao = new UserDao();
		
		//userid,usernm,pass,reg_dt,alias,addr1,addr2,zipcode
		UserVo uservo = new UserVo("ddit","대덕인재","dditpass", new Date(), 
				"개발원_m", "대전 중구 중앙로 76","4층 대덕인재개발원","34940");

		/***When***/
		int updateCnt = userDao.modifyUser(uservo); 
// @formatter:on


		/***Then***/
		assertEquals(1, updateCnt);
	}
}
