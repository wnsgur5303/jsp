package kr.or.ddit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.core.net.server.ServerListener;

public class ApplicationListener implements ServletContextListener{
	private static final Logger logger = LoggerFactory.getLogger(ApplicationListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//서버가 최초로 켜졌을때
		logger.debug("INIT");
		ServletContext sc = sce.getServletContext();
		sc.setAttribute("cp", sc.getContextPath());
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//서버가 꺼졌을때
		
	}
	
	
}
