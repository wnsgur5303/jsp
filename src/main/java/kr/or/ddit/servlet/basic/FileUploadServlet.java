package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.util.FileUtil;

@MultipartConfig
@WebServlet("/fileupload")
public class FileUploadServlet extends HttpServlet{
	private static final Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);
	//doGet : 파일 업로드를 테스트할 화ㅓ면을 응답으로 생성
	//webapp.jsp/fileupload.jsp
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/fileUpload.jsp").forward(req, resp);
	}
	//doPost:파일 업로드 화면에서 서버로 파일 업로드 요청
	//요청 처리후에 파일 업로드 화면으로 이동
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		logger.debug("contentType: {}", req.getContentType());
		logger.debug("userid : {}",req.getParameter("userid"));
		logger.debug("file : {}",req.getParameter("file"));
		//파일을 받기위해 추가적으로 해줘야할것
		
		Part part = req.getPart("file");
		if(part.getSize()>0) {
		//사용자가 업로드한 파일이름
		String filename = FileUtil.getFileName(part.getHeader("Content-Disposition"));
		
		//서버에 저장할 때 다른 사용자의 파일과 중복되지 않도록 생성한 파일이름
		String realFilename = UUID.randomUUID().toString();
		
		part.write("d:\\upload\\"+filename);
		
		//복수개의 파일을 업로드 하고 파트의 이름을 모를때
		Collection<Part> parts = req.getParts();
		for(Part p : parts) {
			
		}
		logger.debug("Content-Disposition : {}", part.getHeader("Content-Disposition"));
		if(part.getHeader("Content-Disposition").equals("filename")) {
		}
		doGet(req,resp);
		}else {
			doGet(req,resp);
		}
	}
}