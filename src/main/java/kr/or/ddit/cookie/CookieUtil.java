package kr.or.ddit.cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {
	private static final Logger logger = LoggerFactory.getLogger(CookieUtil.class);
	
	/**
	 * Method : getCookieValue
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param cookieStr
	 * @param cookieName
	 * @return
	 * Method 설명 : cookieStr에서 cookieName에 해당하는 쿠키 값을 조회
	 */
	
	//cookieStr : userid = brown; rememberme = Y; test = testcookie
	//cookieName : userid , rememberme
	//return: brown, Y
	public static String getCookieValue(String cookieStr,String cookieName) {
		
		cookieStr = "userid=brown; rememberme=Y; test=testcookie";
		cookieName = "rememberme";
		String[] cookies = cookieStr.split("; ");
		
		for(String cookieString : cookies) {
			logger.debug(cookieString);
			//못쓴거 마저 쓰기
			
			String[] cookie = cookieString.split("=");
			
			if(cookie[0].equals(cookieName)) {
				logger.debug(cookie[1]);
				return cookie[1];
				}
		}
		return "";
	}
}
