package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Encoding implements Filter{
	private static final Logger logger = LoggerFactory.getLogger(Encoding.class);

	private Map<String, Integer> requestCountMap = new HashMap<String, Integer>();
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("init()");
		logger.debug("두번째");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// request 객체를 이용하여 요청된 uri 정보를 카운팅
		HttpServletRequest req = (HttpServletRequest)request;
		request.setCharacterEncoding("utf-8");

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	

}
