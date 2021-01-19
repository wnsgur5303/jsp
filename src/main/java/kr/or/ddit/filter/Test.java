package kr.or.ddit.filter;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.tomcat.jni.Local;

public class Test {
	public static void main(String[] args) {
		for(Locale local : SimpleDateFormat.getAvailableLocales()) {
			System.out.println(local);
		}
	}
}
