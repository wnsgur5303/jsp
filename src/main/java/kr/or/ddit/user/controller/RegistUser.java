package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.jsp.PageContext;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.FileUtil;

@MultipartConfig
@WebServlet("/registUser")
public class RegistUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();
	private static final Logger logger = LoggerFactory.getLogger(RegistUser.class);

	public RegistUser() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/user/registUser.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String pass = request.getParameter("pass");
		String dt = request.getParameter("reg_dt");
		String alias = request.getParameter("alias");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		logger.debug(addr1);
		
		usernm = new String(usernm.getBytes("8859_1"), "UTF-8");
		String convertMessage2 = new String(addr1.getBytes("8859_1"), "UTF-8");
		
		logger.debug(convertMessage2);
//		usernm = convertMessage;
		addr1 = convertMessage2;
		

		UserVo user = userService.selectUser(userid);

		if (user == null) {

			Date reg_dt = new Date();
			try {
				reg_dt = sdf.parse(dt);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			//사용자가 profile을 업로드 한경우
			//전송한 파일이름 (filename)
			//서버에 저장할 파일 이름(realfilename)
			//서버에 지정된 공간에 저장
			String filename = null;
			String realfilename =	null;
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
			
			UserVo uservo = new UserVo(userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode , filename,realfilename);
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
				
				doGet(request,response);
			}
		} else {
			
			doGet(request,response);
		}
	}
}
