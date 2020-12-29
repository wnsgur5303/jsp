package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TimesTablesServlet
 */
@WebServlet("/TimesTablesServlet")
public class TimesTablesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimesTablesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

//		 height : 100%;
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("	<style>");
		pw.println("	td{");
		pw.println("		border: 1px solid black; ");
		pw.println("	}");
		pw.println("	table{");
		pw.println("		width : 100%; text-align:center;");
		pw.println("	}");
		pw.println("	</style>");
		pw.println("		<title>Times Tables Servlet</title>");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("	<table border='1'>");
		
		for(int i = 2; i<10;i++) {
			pw.println("<tr>");
			
			for(int j = 1; j<10; j++) {
				pw.println("<td>");
					pw.println(i +" * "+j+ " = "+i*j);
				pw.println("</td>");
			}
		
			pw.println("</tr>");
		}

		pw.println("	</table>");
		pw.println("	</body>");
		pw.println("</html>");

		pw.flush(); // 더이상 작성할 내용이 없으므로 작업을 마무리 한다
		pw.close(); // 사용한 자원 반납
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
