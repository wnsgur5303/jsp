package kr.or.ddit.db;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class InitDBCP
 */
@WebServlet(value = "/initDBCP", loadOnStartup = 1)
public class InitDBCP extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(InitDBCP.class);
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException{
		logger.debug("InitDBCP.init()");
		//요청을 안했는데도 초기화가 됐다 - 설정때문에 그렇다.
		
		//커넥션 풀 생성
		//application scope에 커넥션 풀 저장	
		BasicDataSource bs = new BasicDataSource();
		bs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bs.setUsername("wnsgur5303");
		bs.setPassword("java");
		bs.setInitialSize(20);//초기사이즈
		
		//dbcp.jsp에서는 application scope 저장된 커넥션 풀을 사용하여 컨넥션 객체를
		//얻고 해제하는 과정을 반복 - 시간체크
		//application ==> ServletContext
		
		ServletContext sc = getServletContext();
		sc.setAttribute("bs", bs);
	}
	
}