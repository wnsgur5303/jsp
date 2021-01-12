package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDaoI;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

/**
 * Servlet implementation class InsertUser
 */
@WebServlet("/insertUser")
public class InsertUser extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(InsertUser.class);
	private static final long serialVersionUID = 1L;
	private UserServiceI userService = new UserService();
	private UserDaoI userDao = new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUser() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/user/insertUserForm.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String pass = request.getParameter("pass");
		String alias = request.getParameter("alias");
		
		
		System.out.println(userid);
		System.out.println(usernm);
		System.out.println(pass);
		System.out.println(alias);
		
		
		UserVo vo = new UserVo();
		vo.setUserid(userid);
		vo.setUsernm(usernm);
		vo.setPass(pass);
		vo.setAlias(alias);
		
		
		userDao.insertUser(vo);
		
		
		
		request.getRequestDispatcher("/allUser").forward(request, response);
	}

}
