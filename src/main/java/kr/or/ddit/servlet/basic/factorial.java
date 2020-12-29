package kr.or.ddit.servlet.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class factorial {
	private static final Logger Logger = LoggerFactory.getLogger(factorial.class);
	
	public static void main(String[] args) {
		factorial factorial = new factorial();
		int result = factorial.calculate(5);
		
		if(result == 120) {
			Logger.debug("success");
		}
		else {
			Logger.debug("fail");
		}
		
		if(result == 1) {
			Logger.debug("success");
		}
		else {
			Logger.debug("fail");
		}
	}
	//메소드 설명 : 인자로 들어온 n값을 이용하여 팩토리알을 계산
//	private int calculate(int n) {
//		int fac = 1;
//		for(int i = 1; i<= n; i++) {
//			fac = fac * 1;
//		}
//		
//		return fac;
//	}
	
	private int calculate(int n) {
		int fac = 1;
		
		if(n==1)
			return 1;
		else
			return n* calculate(n--);
	}
	

}
