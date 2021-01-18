package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;

@WebServlet("/registUser")
public class RegistUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();
	private static final Logger logger = LoggerFactory.getLogger(RegistUser.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/user/registUser.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String pass = request.getParameter("pass");
		String dt = request.getParameter("reg_dt");
		String alias = request.getParameter("alias");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		String filename = request.getParameter("filename");
		String realfilename = request.getParameter("realfilename");

		UserVo user = userService.selectUser(userid);

		if (user == null) {

			Date reg_dt = new Date();
			try {
				reg_dt = sdf.parse(dt);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			UserVo uservo = new UserVo(userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode);

			uservo.setFilename(realfilename);
			uservo.setRealfilename(realfilename);

			int cnt = userService.registUser(uservo);
			
			  int updateCnt = 0;
			  
			  /*try { //이쪽이 같이한 방법
				  
			  updateCnt = userService.registUser(uservo);
			  
			  
			  }catch(Exception e){ doGet(request,response);
			  
			  doGet(request, response);
			  
			  }*/
			 
			if (cnt == 1) {
				// doGet(request,response); 가능
				request.getRequestDispatcher(request.getContextPath()+"/pagingUser").forward(request, response);
			} else {
				
				response.sendRedirect("/user/registUser.jsp");
				// request.getRequestDispatcher("/user").forward(request, response);
			}
		} else {
			response.sendRedirect("/user/registUser.jsp");
		}
	}
}
