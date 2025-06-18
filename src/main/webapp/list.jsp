<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.javaex.vo.PersonVO"%>


<%                             //모든형을 받아야 하기 때문에 형변환
	List<PersonVO> personList = (List<PersonVO>)request.getAttribute("pList");
	System.out.println("여기는jsp");
	System.out.println(personList);
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
	<h1>주소록</h1>
	
	<h2>전화번호 리스트</h2>
	<p>전화번호 리스트입니다.</p>
	
	<%for(int i=0; i<personList.size(); i++){
	%>		
		
		<table border = '1'>
			<tbody>
				<tr>
					<td>이름(name)</td>
					<td><%=personList.get(i).getName() %>
					</td>
				</tr>
				
				<tr>
					<td>핸드폰(hp)</td>
					<td><%=personList.get(i).getHp() %></td>
				</tr>
				
				<tr>
					<td>회사(company)</td>
					<td><%=personList.get(i).getCompany() %></td>
				</tr>
				<tr>
					<td><a href="http://localhost:8080/phonebook2/pbc?action=mform&no=<%=personList.get(i).getPersonId() %>">[수정]</td></a> <!-- 여기에 수정폼 주소 먹이기..? -->
					<td><a href="http://localhost:8080/phonebook2/pbc?action=delete&no=<%=personList.get(i).getPersonId() %>">[삭제]</td></a>  <!--  원래 버튼으로 해야한다. js 필요 안배워서 a태그로 구횬-->
				</tr>
			
			
			</tbody>
		</table>	
		<br>
	<%	
	}
	%>
	
	[주소록 작성폼 이동]: 주소창에 aaa.html 입력하시고 엔터입력
	<br>
	<a href="http://localhost:8080/phonebook2/pbc?action=wform">주소록 작성폼 이동</a>
	
	
	</body>
</html>			