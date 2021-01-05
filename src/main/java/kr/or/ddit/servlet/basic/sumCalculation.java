package kr.or.ddit.servlet.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class sumCalculation
 */
@WebServlet("/sumcalculation")
public class sumCalculation extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(sumCalculation.class);
	private static final long serialVersionUID = 1L;

    public sumCalculation() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/sumcalculation.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		int sumResult = 0;
		for(int i = start; i < end+1; i++) {
			sumResult += i;
		}
		logger.debug("합계 {}", sumResult);	
		HttpSession session = request.getSession();		
		session.setAttribute("sumResult", sumResult);	
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
	}

}
