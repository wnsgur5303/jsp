package kr.or.ddit.servlet.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Factorial {
	private static final Logger Logger = LoggerFactory.getLogger(Factorial.class);
	
	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		int result = factorial.calculate(5);
//		int fac = 1;
		
		if(result == 120) {
			Logger.debug("success");
		}
		else {
			Logger.debug("fail");
		}
		
		result = factorial.calculate(0);
		
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
	
	public int calculate(int n) {
		if(n<=1)
			return 1;
		else
			return n * calculate(--n);
	}
	

}
