[Expression Language] 표현언어

1. JSP에서 표현 언어를 사용하려면 Page Directive 속성에서 isELIgonored 속성을 false로 변경
	- isELIgnored="false"
	
2. 표현 언어 특징
	- 변수와 연산자를 포함
	- JSP 내장 객체에 저장된 속성이나 자바빈 속성을 출력 가능
	- JSP 페이지 생성 시 기본 설정은 표현 언어를 사용할 수 없다.
	- isELIgnored="false"
	
3. 자료형
	- 논리 : true, false
	- 정수 : +, -, 0~9로 이루어진 값
	- 실수 : 소수점 값, 지수형
	- 문자열 : 작은따옴표('문자열'), 큰따옴표('문자열")
	- 무효값 : null
	
4. 연산자
	- 산술연산자 : +, -, *, /, div, %, mod
	- 비교연산자 
		->  ==, !=, >, <, >=, <= 
		->  eq, ne, gt, lt ,ge, le
	- 논리연산자 
		->  논리곱(&&, and)
		->  논리합(||, or)
		->  부정(!, not)
	- 빈연산자(empty) : null이거나 문자열이 비어 있으면 true 반환
	- 조건연산자 : 식 ? 값1 : 값2
	
--------------------------------------------------------------------------------

[커스텀 태그]
1. JSTL(JSP Standard Tag Library)
2. 사용자 태그 : 스트러츠, 스프링, 개발자
3. 사이트 : https://tomcat.apache.org/download-taglibs.cgi
	- Impl   :	taglibs-standard-impl-1.2.5.jar (pgp, sha512)
	- Spec   :	taglibs-standard-spec-1.2.5.jar (pgp, sha512)
	- EL	 :	taglibs-standard-jstlel-1.2.5.jar (pgp, sha512)
	- Compat :	taglibs-standard-compat-1.2.5.jar (pgp, sha512)
		ㄴ> Tomcat\lib 배치
	- Source Code Distributions : .zip
	
	
[Core 태그 라이브러리(c=core)]	
1. 변수
	- <c:set> : 변수지정
	- <c:remove> : 변수제거
	
2. 흐름제어
	- <c:if> : 조건문
	- <c:choose> : switch 문, <c:when> <c:otherwise>
	- <c:forEach> : 반복문
	- <c:forTokens> : 구분자를 이용한 토큰 처리
	
3. URL 처리
	- <c:import> : URL을 이용해서 다른 jsp를 추가
	- <c:redirect> : response.sendRedirect()
	- <c:url> : 요청 매개변수로부터 url 생성
	
4. 기타 태그
	- <c:catch> : 예외처리
	- <c:out> 	: JspWriter를 이용한 출력
	
5. JSP에서 태그 라이브러리 사용
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	을 추가한다
	
6. <c:set var="변수명" value="변수값" scope="변수의 범위"/>
	scope : page, request, session, application
	
7. <c:forEach var="변수이름" items="반복객체" begin="시작값" end="마지막값" step="증가값" varStatus="반복 상태 이름">
	- varStatus
		-> index : int, items의 인덱스 번호(0부터 시작), begin 값부터 시작
		-> count : int, 반복 순번, begin값부터 시작
		-> first : boolean, 첫 번째 반복 유무
		-> last  : boolean, 마지막 반복 유무
	
	
	
	