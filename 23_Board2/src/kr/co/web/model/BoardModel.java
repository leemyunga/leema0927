package kr.co.web.model;

import java.util.ArrayList;
import java.util.Map;

public class BoardModel {

	private static ArrayList<BoardBean> list = new ArrayList<BoardBean>();
	 
	public int write(String user_name, String subject, String content) {

		BoardBean bean = new BoardBean();
		
		bean.setUser_name(user_name);
		bean.setSubject(subject);
		bean.setContent(content);
		
		list.add(bean);
		
		int idx = list.size() - 1;
		return idx;
	}
	
	public ArrayList<BoardBean> getList() {
		return list;
	}
	
	public BoardBean detail(String idx) {		
		return list.get(Integer.parseInt(idx));
	}
	
	public BoardBean detail(int idx) {		
		return list.get(idx);
	}
	
	public void remove(String idx) {
		list.remove(Integer.parseInt(idx));
	}

	// 수정 버튼 클릭시
	public BoardBean update(String idx) {
		
		BoardBean bean = new BoardBean();
		
		bean = list.get(Integer.parseInt(idx));
		
		return bean;
	}
	
	// 수정 완료 버튼 클릭 시 
	public BoardBean done(String idx, String subject, String content) {
		BoardBean bean = new BoardBean();
 		bean = list.get(Integer.parseInt(idx));
		bean.setSubject(subject);
		bean.setContent(content);
		
		list.set(Integer.parseInt(idx), bean);
		
		return list.get(Integer.parseInt(idx));
	}
	
	
}
