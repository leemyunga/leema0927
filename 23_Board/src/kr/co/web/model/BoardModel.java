package kr.co.web.model;

import java.util.ArrayList;
import java.util.Map;

public class BoardModel {
	
	// list라는 ArrayList 안에 user_name, subject,content가 모두 들어가야함
	// 하나의 리스트에 3개 값이 들어가려면 어떤 데이터 타입? -> class (beans)
	private static ArrayList<BoardBean> list = new ArrayList<BoardBean>();
	
	
	// class(bean)을 이용한 ArrayList에 값넣기 
	public void write(String user_name, String subject, String content) {
		// 1. BoardBean 객체 생성
		BoardBean bean = new BoardBean();
		
		// 2. 객체에 매개변수로 받아온 값을 넣는다.
		bean.setUser_name(user_name);
		bean.setSubject(subject);
		bean.setContent(content);
		
		// 3. 값을 넣은 객체를 리스트에 넣는다. 
		list.add(bean);
	}
	
	
	
	
	
	public ArrayList<BoardBean> getList() {
		
	
//		Box box = new Box(); // 만약 이 박스에 숫자만 넣고 싶다면?
//		box.no = 13;
//		box.name="사과박스";
//		box.grade='a';
//		
//		// Box 클래스를 객체화 할때 타입을 지정할 수 있음
//		Box<Integer> box = new Box<Integer>();
//		box.no = 13;
//		box.name=123456;
//		box.grade=123456789;
		
//		Box<String, Integer, String> box = new Box<String, Integer, String>();
//		
//		box.no="1";
//		box.name=1234;
//		box.grade="A";
		
		return list;
		
	}
	
	public BoardBean detail(String idx) {
//		BoardBean bean = list.get(Integer.parseInt(idx));
//		return bean;
		
		// 위코드와 동일
		return list.get(Integer.parseInt(idx));
	}
	
	public void remove(String idx) {
		list.remove(Integer.parseInt(idx));
	}
}
