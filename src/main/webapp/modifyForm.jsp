<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.javaex.vo.PersonVO"%>


<%                             //모든형을 받아야 하기 때문에 형변환
	PersonVO personVO = (PersonVO)request.getAttribute("personVO");
	System.out.println("여기는jsp");
	System.out.println(personVO);
%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
	
	
		<h1>주소록</h1>
		<h2>전화번호 수정폼</h2>
		<p>전화번호를 수정하는 폼 입니다.</p>
		
		
	
		<!-- 액션: 앞에 주소를 만들어줌 / 겟방식으로 데이터를 가져온다. -->
		<form action="http://localhost:8080/phonebook2/pbc" method="get">
			<label>이름(name)</label>	
			<input type="text" name="name" value="<%=personVO.getName()%>">
			<br>
			
			<label>핸드폰(hp)</label>
			<input type="text" name="hp" value="<%=personVO.getHp()%>">
			<br>
			
			<label>회사(company)</label>
			<input type="text" name="company" value="<%=personVO.getCompany()%>">
			<br>
		
			<label>액션</label>		
			<input type="hidden" name="action" value="modify">
			<br>
		
			<input type="hidden" name="no" value="<%=personVO.getPersonId()%>">
			<br>
		
		
		
			<button>수정(등록)</button>
		</form>
	</body>
</html>