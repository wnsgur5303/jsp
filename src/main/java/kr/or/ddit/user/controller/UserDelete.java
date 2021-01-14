package kr.or.ddit.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.service.UserService;


@WebServlet("/deleteUser")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();
	private static final Logger logger = LoggerFactory.getLogger(UserDelete.class);


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		logger.debug(userid);
		int deleteCnt = 0;
		
		try {
			deleteCnt = userService.deleteUser(userid);
			logger.debug("{}",deleteCnt);
		}catch (Exception e) {
			deleteCnt = -1;
		}
		
		if(deleteCnt == 1) {
			response.sendRedirect(request.getContextPath()+"/pagingUser");
		}else {
			response.sendRedirect(request.getContextPath()+"/user?userid="+userid);
		}
	}

}
