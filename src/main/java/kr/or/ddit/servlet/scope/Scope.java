package kr.or.ddit.servlet.scope;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Scope
 */
@WebServlet("/Scope")
public class Scope extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Scope() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	req.getRequestDispatcher("jsp/scope.jsp").forward(req, resp);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Scope.java의 doPost에서는 요청 파라미터중 스코프 파라미터를 확인하여
		String scopeParameter = req.getParameter("scope");
		
		//스코프객체.setAttribute("속성명","속성값").반환 타입: void
		//request, session, application scope에 다음과 같이 속성을 저장
		//request : 속성명 = request, 속성값 = scope파라미터값 + "_request"
		req.setAttribute("request", scopeParameter+"_request");
		
		//request : 속성명 = request, 속성값 = scope파라미터값 + "_session"
		HttpSession session = req.getSession();
		session.setAttribute("session", scopeParameter+"_session");
		
		//req.getSession().setAttribute("session",scopeParameter+"_session");
		
		//application : 속성명 - application, 속성값 = scope파라미터값 + "_application"
		ServletContext application = getServletContext();
		application.setAttribute("application", scopeParameter+"_application");

		//webapp/jsp/scopeResult.jsp로 forward
		req.getRequestDispatcher("jsp/scopeResult.jsp").forward(req, resp);
	}

}
