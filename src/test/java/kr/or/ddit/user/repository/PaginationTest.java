package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import kr.or.ddit.user.model.UserDao;

public class PaginationTest {

	@Test
	public void Paginationtest() {
		/***Given***/
		int userTotCnt = 16;
		int pageSize = 5;

		/***When***/
		int pageination = (int) Math.ceil((double)userTotCnt/pageSize);
		System.out.println(pageination);

		/***Then***/
		assertEquals(4,pageination);
	}
	@Test
	public void selectAllUserCntTest(){
		/***Given***/
		UserDaoI userDao = new UserDao();

		/***When***/
		int userCnt = 5;

		/***Then***/
		assertEquals(16,userCnt);
	}

}
