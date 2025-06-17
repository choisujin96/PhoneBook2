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
	private Object personOne;
 
	//생성자 (기본생성자 사용 삭제해도 됨)
    public PhonebookController() {    
    }
    
    //메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직
		//작동했는지 확인용
		System.out.println("PhonebookController");
		
		//action 파라미터 값이 뭔지 알아야됨
		String action = request.getParameter("action");
		System.out.println(action); //업무구분
		
		
			//주소값이 null이어도 안전하게 비교할 수 있음(비교대상이 먼저 들어와야함)
		if("list".equals(action)) {
		//(action.equals("list")) 
			System.out.println("리스트");// 여기까지 체크 후 뒤에 코드 짜기
			
		//리스트//////////////////////////////////////////////////////////////
		
		
		//데이터 가져온다 --> list
		PhonebookDAO phonebookDAO = new PhonebookDAO();
		List<PersonVO> personList = phonebookDAO.personSelect();
	
		System.out.println(personList);

		//html + list
		//저 밑에 있는
		//list.jsp에 후반일(데이터를전달) html을 만들고 응답문서를 만들어 보낸다.
		//1)request 객체에 데이터를 넣어준다.
		request.setAttribute("pList", personList); //문자열/주소
		
		//2)list.jsp에 request객체와 response객체를 보낸다
		//**포워드** java와 html 문법 둘이 세트로 묶어서 전달하는 기술
		RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
		rd.forward(request, response);
		////////////////////////////////////////////////////////////////
		
		
		
		//*등록폼과 등록은 다른 업무다* 
		}else if("wform".equals(action)) {//등록폼 업무 (등록이랑은 다른 업무)
			
			//등록폼/////////////////////////////////////////////////////////
			System.out.println("등록폼"); //여기까지 체크 후 뒤에 코드 짜기
			//응답문서 바디 추가한다
		
			
			//등록폼을 응답해야한다
			//1)db관련 할 일이 없다 - 안하면된다
			
			//2)jsp에게 화면을 그리게 한다(포워드)
			//writeForm.jsp 포워드한다.
			
			RequestDispatcher rd = request.getRequestDispatcher("/writeForm.jsp");
			rd.forward(request,response);
	
		}else if("write".equals(action)) {// 얘가 등록업무임
			System.out.println("등록"); //여기까지 체크 후 뒤에 코드 짜기
			
			//파라미터 3개 꺼내기
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			/*
			System.out.println(name);
			System.out.println(hp);
			System.out.println(company);			
			*/
			
			// 파라미터를 하나로 묶는다.
			PersonVO personVO = new PersonVO(name, hp, company);
			System.out.println(personVO);
			
			//DAO를 통해서 저장시키기
			PhonebookDAO phonebookDAO = new PhonebookDAO();
			phonebookDAO.personInsert(personVO);
		
			
			//리다이렉트 list 요청해주세요
			//http://localhost:8080/phonebook2/pbc?action=list
			//많이들 포워드랑 헷갈려함 구별을 잘 하자
			//포워드는 내부끼리, 리다이렉트는 완전 새로운 주소
			
			response.sendRedirect("http://localhost:8080/phonebook2/pbc?action=list");
			

			
		/*
			//응답(리스트) 하기   ----------이거 안씀 리다이렉트 사용함----------------
			// DAO 시켜서 데이터 가져오기
			List<PersonVO> personList = phonebookDAO.personSelect();
			
			//request 객체에 데이터를 넣어준다.
			request.setAttribute("pList", personList); //문자열/주소
			//jsp 포워드
			RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
			rd.forward(request, response);
		*/	
			
		} else if("delete".equals(action)) {
			
			System.out.println("삭제");
			
			//파라미터에서 no 꺼내온다
			int no = Integer.parseInt(request.getParameter("no")); 
			//왜 int가 아니라 String이냐면 파라미터로 넘어올 땐 문자열로 변경되기 때문
			
			//DAO를 통해서 no 를 주고 삭제
			PhonebookDAO phonebookDAO = new PhonebookDAO();
			phonebookDAO.personDelete(no);
			
			
			//리다이렉트 action=list
			//"응답을 클라이언트(브라우저)에게 보내면서, ‘너 이 URL로 다시 요청해!’ 라고 지시하는 것"
			response.sendRedirect("http://localhost:8080/phonebook2/pbc?action=list");
			
			
			//얘는 수정폼 가쟈와
			
		} else if("mform".equals(action)) {
			System.out.println("수정폼");// 체크오케이
			  	int no = Integer.parseInt(request.getParameter("no"));
		

			    // DAO 호출 - 한 명 정보 가져오기
			  	PhonebookDAO phonebookDAO = new PhonebookDAO();
			  	PersonVO personVO = phonebookDAO.getPersonOne(no);  

			    // request에 담아서 수정폼에 전달
			    request.setAttribute("pList", personOne);

			    // 페이지 포워딩
			    RequestDispatcher rd = request.getRequestDispatcher("/modifyForm.jsp");
			    rd.forward(request, response);
		        
		}else if("modify".equals(action)) { //얘는 수정
			System.out.println("수정");  //체크 ok
			
			
		
			
		
		
		}
	}
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
