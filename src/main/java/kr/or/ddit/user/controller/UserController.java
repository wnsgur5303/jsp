package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private UserService userService = new UserService();
	private static final long serialVersionUID = 1L;

    public UserController() {
        super();
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// userid parameter 확인
		// userService 객체를 이용하여 파라미터에 해당하는 사용자 정보 조회
		// request 객체에 2)번째 조회된 user라는 속성으로 저장
		// webapp/user/user.jsp로 화면 생성 위임
		
		
		logger.debug("ok");
		
		String userid = request.getParameter("userid");
		UserVo user = userService.selectUser(userid);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/user/user.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
