package kr.or.ddit.emp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.emp.service.EmpService;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;


@WebServlet("/empModify")
public class empModify extends HttpServlet {
	EmpService empService = new EmpService();
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(empModify.class);
       

    public empModify() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	
    	int empno = (Integer.parseInt(request.getParameter("empno")));
		EmpVo emp = empService.selectEmp(empno);
		
		System.out.println(emp);
		
		request.setAttribute("empInfo", emp);
		request.getRequestDispatcher("/emp/empModify.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터를 읽기 전에 실행
		//servlet의 doPost메소드 마다 실행 필요 ==> Filter
		request.setCharacterEncoding("utf-8");	
		
		int empno = (Integer.parseInt(request.getParameter("empno")));
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		int mgr = (Integer.parseInt(request.getParameter("mgr")));
		int sal = 0;
		if(!request.getParameter("sal").equals("0")) {
		sal = (Integer.parseInt(request.getParameter("sal")));
		}
		int comm = 0;
		if(!request.getParameter("comm").equals("0")) {
		comm = (Integer.parseInt(request.getParameter("comm")));
		}
		int deptno = (Integer.parseInt(request.getParameter("deptno")));
		

		EmpVo empvo = new EmpVo(empno,ename,job,mgr,sal,comm,deptno);
		int cnt = empService.modifyEmp(empvo);
		if(cnt == 1) {
			
			response.sendRedirect(request.getContextPath()+"/empInfo?empno="+empno);
		}
		else {
			doGet(request,response);
			//request.getRequestDispatcher("/user").forward(request, response);
		}
	}

}
