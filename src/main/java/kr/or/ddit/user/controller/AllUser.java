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

import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDaoI;
import kr.or.ddit.user.model.UserDao;
/**
 * Servlet implementation class AllUser
 */
@WebServlet("/allUser")
public class AllUser extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(AllUser.class);
	private static final long serialVersionUID = 1L;
	private UserServiceI userService = new UserService();
	private UserDaoI userDao = new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllUser() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("ok");
		List<UserVo> userList = userDao.selectAllUser();
		
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/user/allUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
