package kr.or.ddit.cookie;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtilTest {
	private static final Logger logger = LoggerFactory.getLogger(CookieUtilTest.class);

	
	//테스트 메소드 명명 규칙 : 테스트할 메소드 + "Test"
	@Test
	public void getCookieValueTest() {
		//gwt
		/***Given***/
		String cookieStr = "userid=brown;rememberme=Y;test=testcookie";
		String cookieName = "rememberme";
		String[] cookies = cookieStr.split("; ");
		
		/***When***/
		String cookieValue = CookieUtil.getCookieValue(cookieStr, cookieName);
		/***Then***/
		assertEquals("Y", cookieValue);
		//cookies[0] = userid = brown
		
	}

}
