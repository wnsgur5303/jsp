package kr.or.ddit.emp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.emp.model.EmpDao;
import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.emp.repository.EmpDaoI;
import kr.or.ddit.emp.service.EmpService;
import kr.or.ddit.emp.service.EmpServiceI;

/**
 * Servlet implementation class EmpInfo
 */
@WebServlet("/empInfo")
public class EmpInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpServiceI empService = new EmpService();
	private EmpDaoI empDao = new EmpDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int empno = Integer.parseInt(request.getParameter("empno"));
		
		EmpVo vo = empDao.selectEmp(empno);
		request.setAttribute("empInfo", vo);
		request.getRequestDispatcher("/emp/empInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
