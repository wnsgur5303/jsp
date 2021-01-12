package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDaoI;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

/**
 * Servlet implementation class PagingUser
 */
@WebServlet("/pagingUser")
public class PagingUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceI userService = new UserService();
	private UserDaoI userDao = new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagingUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//left.jsp : /pagingUser?page=1&pageSize=5
		// ==> /pagingUser
		
		//doGet메소드에서 page,pageSize 파라미터가 request 객체에 존재하지 않을 때
		//page는 1로 pageSize 5로 코드를 작성
		//파라미터가 존재하면 해당 파라미터를 사용
		
		request.setCharacterEncoding("UTF-8");
		
		String pageParam = request.getParameter("page");
		String pageSizeParam = request.getParameter("pageSize");
		//if/else ==>? //조건 ? true 일때 반환할 값 : false일때 반환할 값  형식으로 하기
		//refactoring : 코드를 (깔끔하게)바꾸는데 기존 동작방식을 유지한채로 변경하는 기법
		int page = pageParam == null ? 1 : Integer.parseInt(pageParam);
		int pageSize = pageSizeParam==null ? 5 : Integer.parseInt(pageSizeParam);
		
		
//		int pageSize = 0;
//		int page = 0;
//		if(request.getParameter("page")==null) {
//			page = 1;
//		}
//		if(request.getParameter("pageSize")==null) {
//			pageSize = 5;
//		}
//		else {
//			page = Integer.parseInt(request.getParameter("page"));
//			pageSize = Integer.parseInt(request.getParameter("pageSize"));
//		}
		//선생님이 하신것 
		PageVo pageVo = new PageVo(page,pageSize);
		
//		PageVo pageVo = new PageVo();
//		pageVo.setPage(page);
//		pageVo.setPageSize(pageSize);
		
//		Map<String, Object> map = userService.selectPagingUser(pageVo);
		
		List<UserVo> userList = userDao.selectPagingUser(pageVo);
		int cnt = userDao.selectAllUserCnt();
		int allpage = (int)Math.ceil((double)cnt/pageSize);
		request.setAttribute("pageVo", pageVo);
		
		request.setAttribute("allpage", allpage);
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/user/pagingUser.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
