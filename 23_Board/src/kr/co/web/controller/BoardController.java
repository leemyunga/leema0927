package kr.co.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.web.model.BoardModel;

/* Board의 흐름 
	"/" : list.jsp화면으로 BoardModel.java의 getList()메서드를 사용하여 BoardModel.java의 list 목록을 보여줌
	"/" : list.jsp 화면에서 글쓰기 버튼 클릭시 writeForm.jsp로 이동
	"/writeForm.jsp" : 제목, 작성자, 내용 작성 후 작성 버튼 클릭 시 
						"/write"에 post 방식으로 form에 담긴 데이터를 보냄
	"/write" : 	"user_name", "subject", "content"이름으로 온 파라메터를  
				 BoardModel.java의 write()메서드를 사용하여 BoardModel.java의 list에 저장
	"/detail" : "idx"이름으로 온 파라메터를 매개변수(list의 index값)로 
				BoardModel.java의 detail() 메서드를 실행시켜 detail.jsp로 이동
	"/remove" :"idx"이름으로 온 파라메터를 매개변수(list의 index값)로 
				BoardModel.java의 remove() 메서드를 실행
*/				
// annotation을 사용하여 "/"이거나 "/write"인 url pattern으로 들어오면 이페이지를 로딩
@WebServlet(urlPatterns = {"/", "/write"})
public class BoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dual(req,resp); // get 방식으로 들어오며면 dual 메서드로 처리하기 위해 실행
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dual(req,resp);  // post 방식으로 들어오며면 dual 메서드로 처리하기 위해 실행
	}
	
	private void dual(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8"); // post 방식으로 들어왔을 때 한글 깨짐 방지
		
		// 들어오는 url 패턴마다 할일을 지정해주기 위해 구분		
		String uri = req.getRequestURI(); //전체 주소
		String cxt = req.getContextPath(); // 프로젝트명까지만
		String addr = uri.substring(cxt.length()); //substring을 사용하여 프로젝트명 길이만큼 잘라냄
		//System.out.println(cxt);
		
		// 공통적으로 사용하기 위해 먼저 선언 
		// 필드 선언은 최상단에 하는게 가장 좋음 (가독성 및 활용)
		RequestDispatcher dis = null; 
		BoardModel model = new BoardModel();
		
		
		// URL Patter이 "/" 일때 : 화면에 글목록 출력
		// BoardModel.java에 선언된 list를 model에 담아와 getList() 메서드를 사용하여 가져오고
		// 그값을 "list"라는 이름으로 저장 하여 "list.jsp" 경로로 응답과 함께 보냄
		if(addr.equals("/")) {
			
			// getList() : BoardModel.java의 list를 반환하는 메서드
			// BoardModel.java의 필드 멤버인 list는 접근제한자가 private로 선언되어 있으므로
			//	BoardModel class를 객체화한 model의 메서드를 통해서만 접근이 가능하다. 		
			req.setAttribute("list", model.getList());
			dis = req.getRequestDispatcher("list.jsp");
			dis.forward(req, resp);			
		}
		
		// URL Patter이 "/write" 일때 
		// "user_name", "subject", "content"이름으로 온 파라메터를 저장하고 이를 매개변수로 
		// BoardModel.java의 write()메서드를 사용하여  BoardModel.java의 list에 저장
		if(addr.equals("/write")) {
			String user_name =req.getParameter("user_name");
			String subject = req.getParameter("subject");
			String content =req.getParameter("content");
			
			
			// System.out.println(user_name + " / " + subject + " / " + content);
			
			// write() : 매개변수로 넘어온 값을 list에 저장 후 list를 반환하는 메서드
			model.write(user_name, subject, content);
			resp.sendRedirect(cxt); // 다시 페이지만 로딩 시키면 되기 때문
			
			
			
		}
		
		// URL Patter이 "/detail" 일때 
		// "idx"이름으로 온 파라메터를 매개변수(list의 index값)로 
		// BoardModel.java의 detail() 메서드를 실행시켜 그 반환값을 "board"라는 이름으로 저장하고
		// detail.jsp로 이동
		if(addr.equals("/detail")) {
			String idx =req.getParameter("idx");
			
			// detail() : 매개변수로 받은 특정 인덱스의 list를 반환하는 메서드
			// list는 ArrayList<BoardBean>타입의 변수 이므로 BoardBean class 타입의 ArrayList를 반환한다.
			// BoardBean 클래스는 필드멤버로 private타입의 "user_name","subject","content"를 가지고 있지만 
			// getter/setter 메서드를 가지고 있으므로 detail.jsp에서 EL TAG를 통해 ${board.username}로도 출력이 가능하다. 
			req.setAttribute("idx", idx);
			req.setAttribute("board", model.detail(idx));
			dis = req.getRequestDispatcher("/detail.jsp");
			dis.forward(req, resp);
		}
		
		
		// URL Patter이 "/remove" 일때 
		// "idx"이름으로 온 파라메터를 매개변수(list의 index값)로 
		// BoardModel.java의 remove() 메서드를 실행
		if(addr.equals("/remove")) {
			String idx =req.getParameter("idx");
			
			// remove() : 매개변수로 넘어온 값을 list의 index값으로 받아 해당 인덱스를 삭제하는 메서드
			model.remove(idx);
			resp.sendRedirect(cxt);// "/"로 다시 페이지만 로딩 시키면 되기 때문
		}
		
		
	}

}
