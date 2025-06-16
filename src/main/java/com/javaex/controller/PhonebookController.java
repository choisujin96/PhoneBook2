package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhonebookDAO;
import com.javaex.vo.PersonVO;

				//주소					
@WebServlet("/pbc")
public class PhonebookController extends HttpServlet {
	
	//필드
	private static final long serialVersionUID = 1L;
 
	//생성자 (기본생성자 사용 삭제해도 됨)
    public PhonebookController() {    
    }
    
    //메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직
		System.out.println("PhonebookController");
	
		//데이터 가져온다 --> list
		PhonebookDAO phonebookDAO = new PhonebookDAO();
		List<PersonVO> personList = phonebookDAO.personSelect();
	
		System.out.println(personList);
		
		
		
		//html + list
		//저 밑에 있는
		//list.jsp에 후반일(데이터를전달) html을 만들고 응답문서를 만들어 보낸다.
		//1)request 객체에 데이터를 넣어준다.
		request.setAttribute("pList", personList);
		
		//2)list.jsp에 request객체와 response객체를 보낸다
		//**포워드** java와 html 문법 둘이 세트로 묶어서 전달하는 기술
		RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
		rd.forward(request, response);

		
		//응답문서 바디 추가한다
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
