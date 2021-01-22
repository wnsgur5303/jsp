package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.FileUtil;

/**
 * Servlet implementation class ModifyUser
 */
@MultipartConfig
@WebServlet("/userModify")
public class UserModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();
	private static final Logger logger = LoggerFactory.getLogger(UserModify.class);
       

    public UserModify() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	
		String userid = request.getParameter("userid");
		UserVo user = userService.selectUser(userid);
		
		System.out.println(user);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/user/member.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터를 읽기 전에 실행
		//servlet의 doPost메소드 마다 실행 필요 ==> Filter
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
		
		
		Date reg_dt = new Date();
		try {
			reg_dt = sdf.parse(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		

		logger.debug("d {}",reg_dt);
		

		Part profile = request.getPart("profile");
		
		if(profile.getSize() > 0) {	
			filename = FileUtil.getFileName(profile.getHeader("Content-Disposition"));
			String fileExtension = FileUtil.getFileExtension(filename);
			logger.debug(fileExtension);
			//brown / brown.png
			realfilename = UUID.randomUUID().toString()+fileExtension;
			logger.debug(realfilename);
			profile.write("d:\\upload\\"+realfilename);	
		}
		
		UserVo uservo = new UserVo(userid,usernm,pass,reg_dt,alias,addr1,addr2,zipcode,filename,realfilename);
		
		int cnt = userService.modifyUser(uservo);
		if(cnt == 1) {
			//doGet(request,response); 가능
			
			response.sendRedirect(request.getContextPath()+"/user?userid="+userid);
		}
		else {
			doGet(request,response);
			//request.getRequestDispatcher("/user").forward(request, response);
		}
	}

}
