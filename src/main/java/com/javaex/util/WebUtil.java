package com.javaex.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {
	
	//필드
	
	//생성자 public WebUtil(){}
	
	
	// 06-19 3-4교시 수업영상 다시 보기 꼭!!!!!!!!!!!!!!!!
	
	//메소드gs
//	forward(request, response, "/list.jsp");
	
	public static void redirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
	
		response.sendRedirect(url);
	}
		
	
	//메소드일반
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	
	

}
