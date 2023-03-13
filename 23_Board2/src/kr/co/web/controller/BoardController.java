package kr.co.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.web.model.BoardModel;

/* 추가 해본 기능
 * 
 *수정 기능
 *
 * writeForm을 통해서 만들어진 페이지가 글목록이 아니라 detail.jsp를 통해 작성한 글을 바로 확인할 수 있게 함
 * 
 * 수정 버튼 클릭시 업데이트 페이지가 켜지고 업데이트 페이지로 해당 글의 내용이 로딩됨
 * 제목/내용 수정 후 수정 완료 버튼을 누르면 내용이 수정되고 수정한 글 내용을 확인할 수 있음
 * 만약 업데이트 페이지에서 취소를 누르면 수정 전 글의 내용으로 돌아가짐 
 * 
 * 의문 
 * 1. url 패턴에 ,"/done"추가 안했는데 왜 돌아가냐 ->"/"에 의해서 일단 들어오고 비교는 따로니까?
 * 
 * 2. 파라메터를 받아 오는 방법 or 다른 방법(세션이나 쿠키에 저장?)
 * 파라매터를 받아오는 방법 
 * 1. Form태그 안 name과 value가 지정된 input 태그가 submit되면서
 * 2. 주소값으로 파라메터를 붙여옴

*/				

@WebServlet(urlPatterns = {"/", "/write","/update","/detail","/remove"})
public class BoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dual(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dual(req,resp); 
	}
	
	private void dual(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");		
		String uri = req.getRequestURI();
		String cxt = req.getContextPath();
		String addr = uri.substring(cxt.length());
		RequestDispatcher dis = null; 
		BoardModel model = new BoardModel();

		if(addr.equals("/")) {

			req.setAttribute("list", model.getList());
			dis = req.getRequestDispatcher("list.jsp");
			dis.forward(req, resp);			
		}

		if(addr.equals("/write")) {
			String user_name =req.getParameter("user_name");
			String subject = req.getParameter("subject");
			String content =req.getParameter("content");
			
			int idx = model.write(user_name, subject, content);
			
			req.setAttribute("board", model.detail(idx));
			req.setAttribute("idx", idx);
			dis = req.getRequestDispatcher("/detail.jsp");
			dis.forward(req, resp);

		}
		
		
		if(addr.equals("/update")) {
			String idx =req.getParameter("idx");
			model.update(idx);
			
			req.setAttribute("idx", idx);
			req.setAttribute("board", model.update(idx));
			dis = req.getRequestDispatcher("/update.jsp");
			dis.forward(req, resp);
		}
		
		
		if(addr.equals("/done")) {
			String idx =req.getParameter("idx");
			String subject = req.getParameter("subject");
			String content = req.getParameter("content");
			//System.out.println(idx + subject + content);
			model.done(idx, subject, content);
			
			req.setAttribute("idx", idx);
			req.setAttribute("board", model.detail(idx));
			dis = req.getRequestDispatcher("/detail.jsp");
			dis.forward(req, resp);

		}
		
	
		if(addr.equals("/detail")) {
			String idx =req.getParameter("idx");
			
			req.setAttribute("idx", idx);
			req.setAttribute("board", model.detail(idx));
			dis = req.getRequestDispatcher("/detail.jsp");
			dis.forward(req, resp);
		}
		
	
		if(addr.equals("/remove")) {
			String idx =req.getParameter("idx");
			
			model.remove(idx);
			resp.sendRedirect(cxt);
		
		
		}

	}
}
